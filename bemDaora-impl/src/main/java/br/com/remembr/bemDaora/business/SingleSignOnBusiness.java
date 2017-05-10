package br.com.remembr.bemDaora.business;

import java.util.Date;
import java.util.Random;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.NoResultException;

import br.com.remembr.bemDaora.dao.AcessoDAO;
import br.com.remembr.bemDaora.dao.UsuarioDAO;
import br.com.remembr.bemDaora.enums.AcessoStatusEnum;
import br.com.remembr.bemDaora.exception.SingleSignOnException;
import br.com.remembr.bemDaora.model.Acesso;
import br.com.remembr.bemDaora.model.LockLogin;
import br.com.remembr.bemDaora.model.Usuario;
import br.com.remembr.bemDaora.service.sso.Login;
import br.com.remembr.bemDaora.vo.LoginVO;

@Named
public class SingleSignOnBusiness {
	
	@Inject
	private UsuarioDAO usuarioDao;
	
	@Inject
	private AcessoDAO acessoDao;
	
	@Inject
	private LoginBusiness loginBusiness;
	
	public LoginVO login(Login email) throws SingleSignOnException, NoResultException {
		return login(email,true);
	}

	private LoginVO login(Login email, boolean deslogar) {
		try {
			LockLogin lockLogin = usuarioDao.lockLogin(email.getEmail());
			if (lockLogin == null) {
				loginBusiness.criarLockLoginSeNaoExistir(email.getEmail());
				usuarioDao.lockLogin(email.getEmail());
			}

			Usuario usuario = usuarioDao.buscarPorLoginAtivo(email.getLogin());
			if (usuario.getSenha() == null) {
				usuario.setSenha("");
			}
			
			String senhaCrypto = email.getSenha() != null ? PasswordEncrypter.encrypt(email.getSenha()) : "";
			
			if (!usuario.getSenha().equals(senhaCrypto)) {
				throw new SingleSignOnException("usuário e/ou senha inválido(s)");
			}
			
			if(usuario.isResetarSenha()){
				throw new SenhaExpiradaException("Senha expirada");
			}
			
			if (deslogar){
				acessoDao.deslogar(email.getEmail());
			}
			
			Acesso acesso = new Acesso();
			acesso.setDataInicio(new Date());
			acesso.setIp(email.getIp());
			acesso.setStatus(AcessoStatusEnum.LOGADO);
			
			String preTicket = gerarTicket(email.getEmail(), email.getIp(), acesso.getDataInicio());
			String ticket = Base64Utils.tob64(preTicket.getBytes("UTF-8"));
			acesso.setTicket(ticket);
			
			acesso.setUsuario(usuario);
			acessoDao.insert(acesso);
			
			return new LoginVO(usuario.getId(),ticket);
		} catch (NoResultException | SenhaExpiradaException | SingleSignOnException e) {
			throw e;
		} catch (Exception e) {
			throw new SingleSignOnException(e);
		}
	}
	
	
	private String gerarTicket(String email, String ip, Date data) {
		return email + "|" + ip + "|" + data.getTime() + "|" + Math.abs(new Random().nextInt());
	}	
}