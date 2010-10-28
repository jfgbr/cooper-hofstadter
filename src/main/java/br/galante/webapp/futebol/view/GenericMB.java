package br.galante.webapp.futebol.view;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.galante.webapp.futebol.dao.GenericDAO;

public abstract class GenericMB<T> implements Serializable {

	private static final long serialVersionUID = 3806171648447970303L;
	
	private GenericDAO<T> dao;
	private T pojo;
	
	public void setPojo(T pojo){
		this.pojo = pojo;
	}
	
	public void save(ActionEvent actionEvent){
		try {
			dao.insert(pojo);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Os dados foram gravados com sucesso!"));
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ocorreu um erro ao gravar os dados!"));
		}
	}
	
	public void remove(){
		try {
			dao.remove(pojo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
