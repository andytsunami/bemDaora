package br.com.remembr.bemDaora.business;

import java.util.Date;
import java.util.Random;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.NoResultException;

import org.jboss.security.Base64Utils;

import br.com.remembr.bemDaora.dao.AcessoDAO;
import br.com.remembr.bemDaora.dao.UsuarioDAO;
import br.com.remembr.bemDaora.enums.AcessoStatusEnum;
import br.com.remembr.bemDaora.exception.SenhaExpiradaException;
import br.com.remembr.bemDaora.exception.SingleSignOnException;
import br.com.remembr.bemDaora.model.Acesso;
import br.com.remembr.bemDaora.model.LockLogin;
import br.com.remembr.bemDaora.model.Usuario;
import br.com.remembr.bemDaora.service.sso.Login;
import br.com.remembr.bemDaora.utils.PasswordEncrypter;
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

	public LoginVO login(Login email, boolean deslogar) {
		try {
			LockLogin lockLogin = usuarioDao.lockLogin(email.getEmail());
			if (lockLogin == null) {
				loginBusiness.criarLockLoginSeNaoExistir(email.getEmail());
				usuarioDao.lockLogin(email.getEmail());
			}

			Usuario usuario = usuarioDao.buscarPorEmailAtivo(email.getEmail());
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

	public void logout(String email) {
		try {
			Usuario usuario = usuarioDao.buscarPorEmail(email);
			if(!usuario.getEmail().toLowerCase().equals("central")){				
				acessoDao.deslogar(email);
			}
		} catch (Exception e) {
			throw new SingleSignOnException(e);
		}
	}	
	
	public Usuario getUsuarioLogado(String ticket) throws SingleSignOnException {
		try {
			Usuario usuario = acessoDao.buscarUsuarioPorTicketLogado(ticket, false);
			if (usuario == null) {
				return null;
			}
			
			return usuario;
		} catch (Exception e) {
			throw new SingleSignOnException(e);
		}
	}
	
	public boolean isTicketValido(String ticket) throws SingleSignOnException {
		try {
			boolean logado = acessoDao.isTicketValido(ticket);
			return logado;
		} catch (Exception e) {
			throw new SingleSignOnException(e);
		}
	}
	
	public boolean isTicketsMesmoLogin(String ticket1, String ticket2) throws SingleSignOnException {
		try {
			String login1 = new String(Base64Utils.fromb64(ticket1), "UTF-8").split("[|]")[0];
			String login2 = new String(Base64Utils.fromb64(ticket2), "UTF-8").split("[|]")[0];
			
			return login1.equals(login2);
		} catch (Exception e) {
			throw new SingleSignOnException("Erro ao checar se tickets são do mesmo usuário", e);
		}
	}
	
	public String ticketPermanente(String login) throws SingleSignOnException {
		try {
			String ticket;
			Acesso acesso = acessoDao.buscarLogadoPermanentePorLogin(login);
			if (acesso == null) {
				acesso = new Acesso();
				acesso.setDataInicio(new Date());
				acesso.setIp("10.0.10.1");
				acesso.setStatus(AcessoStatusEnum.LOGADO);
				acesso.setPermanente(true);
				
				String preTicket = gerarTicket(login , acesso.getIp(), acesso.getDataInicio());
				ticket = Base64Utils.tob64(preTicket.getBytes("UTF-8"));
				
				acesso.setTicket(ticket);
				acesso.setUsuario(usuarioDao.buscarPorEmailAtivo((login)));
				
				acessoDao.insert(acesso);
			} else {
				ticket = acesso.getTicket();
			}

			return ticket;
		} catch (Exception e) {
			throw new SingleSignOnException("Erro ao criar/buscar ticket permamente para o login: " + login, e);
		}
	}
}