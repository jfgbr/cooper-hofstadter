package br.galante.webapp.futebol.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import br.galante.webapp.futebol.dao.PaisDAO;
import br.galante.webapp.futebol.model.Pais;

@Named("paisMB")
@ConversationScoped
public class PaisMB implements Serializable {

	private static final long serialVersionUID = 91051215500087084L;

	@Inject
	private PaisDAO paisDAO;

	private Pais pais = new Pais();
	private Pais paisExcluido;

	public void save(ActionEvent actionEvent){
		try {
			paisDAO.insert(pais);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("País registrado com sucesso!"));
			pais = new Pais();
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ocorreu um erro ao gravar o país!"));
		}
//		return "pais";
	}
	
	public void remove(){
		try {
			paisDAO.remove(paisDAO.findById(paisExcluido.getIdPais()));
		} catch (Exception e) {
			e.printStackTrace();
		}
//		return "pais";
	}
	
	public List<SelectItem> getComboPaises(){
		
		List<SelectItem> cmbPaises = new ArrayList<SelectItem>();
		
		List<Pais> lstPaises = getPaises();
		
		for (Pais pais : lstPaises) {
			cmbPaises.add(new SelectItem(pais.getIdPais(), pais.getNome()));
		}
		
		return cmbPaises;		
	}
	
	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public List<Pais> getPaises() {
		return paisDAO.findAll();
	}

	public Pais getPaisExcluido() {
		return paisExcluido;
	}

	public void setPaisExcluido(Pais paisExcluido) {
		this.paisExcluido = paisExcluido;
	}
}
