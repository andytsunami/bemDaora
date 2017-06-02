package br.com.remembr.bemDaora.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.NoResultException;

import com.google.common.base.Strings;

import br.com.remembr.bemDaora.dao.UsuarioDAO;
import br.com.remembr.bemDaora.dao.generio.DAOException;
import br.com.remembr.bemDaora.interfaces.UsuarioRemote;
import br.com.remembr.bemDaora.model.Usuario;
import br.com.remembr.bemDaora.vo.ChaveValorVO;
import br.com.remembr.bemDaora.vo.UsuarioVO;

@Stateless
public class UsuarioBean implements UsuarioRemote {
	
	@Inject
	private UsuarioDAO usuarioDAO;

	@Override
	public Usuario buscaPorId(Long id) throws DAOException {
		return usuarioDAO.find(id);
	}

	@Override
	public Usuario buscarPorEmail(String email) throws DAOException, NoResultException {
		return usuarioDAO.buscarPorEmail(email);
	}

	@Override
	public List<Usuario> buscarPorIds(Long... ids) throws DAOException {
		return usuarioDAO.find(ids);
	}

	@Override
	public String buscarNomePorId(Long id) throws DAOException {
		return usuarioDAO.buscarNomePorId(id);
	}

	@Override
	public List<ChaveValorVO> buscarDadosEmailUsuario(String email) throws DAOException {
		return usuarioDAO.buscarDadosEmailUsuario(email);
	}

	@Override
	public List<UsuarioVO> buscarNomeUsuario(String nome) throws DAOException {
		return usuarioDAO.buscarNomeUsuario(nome);
	}

	@Override
	public Usuario insert(Usuario usuario) throws DAOException {
		usuarioDAO.insert(usuario);
		if (!Strings.isNullOrEmpty(usuario.getSenha())){
			//usuarioDAO.alterarSenha(usuario.getId(), usuario.getSenha());
		}
		return usuario;
	}

	@Override
	public Usuario buscarPorCPF(String cpf) throws DAOException {
		return usuarioDAO.buscarPorCpf(cpf);
	}

	@Override
	public Usuario update(Usuario usuario) throws DAOException {
		usuarioDAO.update(usuario);
		if (!Strings.isNullOrEmpty(usuario.getSenha())){
			//usuarioDAO.alterarSenha(usuario.getId(), usuario.getSenha());
		}
		return usuario;
	}
}
