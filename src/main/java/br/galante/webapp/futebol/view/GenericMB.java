package br.galante.webapp.futebol.view;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import br.galante.webapp.futebol.dao.GenericDAO;

public abstract class GenericMB<T> implements Serializable {

	private static final long serialVersionUID = 3806171648447970303L;
	
	private GenericDAO<T> dao;
	
	public abstract T getPojo();
	
	public void save(ActionEvent actionEvent){
		try {
//			partida.setDataOperacao(GregorianCalendar.getInstance().getTime());
			dao.insert(getPojo());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Partida registrada com sucesso!"));
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ocorreu um erro ao gravar a partida!"));
		}
//		return "partidas";
	}
	
	public void remove(){
		try {
//			dao.remove(dao.findById(getPojo().getId()));
		} catch (Exception e) {
			e.printStackTrace();
		}
//		return "partidas";
	}

}
