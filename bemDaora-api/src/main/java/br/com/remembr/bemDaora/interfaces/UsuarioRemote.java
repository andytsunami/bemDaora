package br.com.remembr.bemDaora.interfaces;

import java.util.List;

import javax.ejb.Remote;

import br.com.remembr.bemDaora.dao.generio.DAOException;
import br.com.remembr.bemDaora.model.Usuario;

@Remote
public interface UsuarioRemote {

	public Usuario buscaPorId(Long id) throws DAOException;

	public Usuario buscarPorLogin(String login) throws DAOException, NoResultException;

	public List<Usuario> buscarPorIds(Long... ids) throws DAOException;

	public String buscarNomePorId(Long id) throws DAOException;

	public List<ChaveValorVO> buscarDadosEmailUsuario(String email) throws DAOException;

	public List<UsuarioVO> buscarNomeUsuario(String nome) throws DAOException;

	public Usuario insert(Usuario usuario) throws DAOException;

	public Usuario buscarPorCPF(String cpf) throws DAOException;

	public Usuario update(Usuario usuario) throws DAOException;
}
