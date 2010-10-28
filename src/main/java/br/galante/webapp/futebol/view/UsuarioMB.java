package br.galante.webapp.futebol.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import br.galante.webapp.futebol.dao.UsuarioDAO;
import br.galante.webapp.futebol.model.Usuario;

@Named("usuarioMB")
@SessionScoped
public class UsuarioMB extends GenericMB<Usuario> implements Serializable {

	private static final long serialVersionUID = 8243985854752413897L;

	@Inject
	private UsuarioDAO usuarioDAO;

	private List<Usuario> lstUsuario;

	private Usuario usuario = new Usuario();
	private Usuario usuarioExcluido;

	public void save(ActionEvent actionEvent){
		try {
			usuarioDAO.insert(usuario);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Os dados foram gravados com sucesso!"));
			usuario = new Usuario();
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ocorreu um erro ao gravar os dados!"));
		}
	}
	
	public void remove(){
		try {
			usuarioDAO.remove(usuarioExcluido);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Usuario> getUsuarios() {
		lstUsuario = usuarioDAO.findAll();
		return lstUsuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<SelectItem> getComboUsuarios() {

		List<SelectItem> cmbUsuarios = new ArrayList<SelectItem>();

		if (lstUsuario == null)
			getUsuarios();

		for (Usuario usuario : lstUsuario) {
			cmbUsuarios.add(new SelectItem(usuario.getIdUsuario(), usuario
					.getNome()));
		}

		return cmbUsuarios;
	}

	public Usuario getUsuarioExcluido() {
		return usuarioExcluido;
	}

	public void setUsuarioExcluido(Usuario usuarioExcluido) {
		this.usuarioExcluido = usuarioExcluido;
//		setPojo(usuarioExcluido);
	}
}
