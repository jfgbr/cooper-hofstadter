package br.galante.webapp.futebol.view;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import br.galante.webapp.futebol.dao.PartidaDAO;
import br.galante.webapp.futebol.model.Partida;

@Named("partidaMB")
@RequestScoped
public class PartidaMB implements Serializable {

	private static final long serialVersionUID = -5580627558164281958L;

	@Inject
	private PartidaDAO partidaDAO;

	private Partida partida = new Partida();
	private Partida partidaExcluida;
		
	public void save(ActionEvent actionEvent){
		try {
//			partida.setDataOperacao(GregorianCalendar.getInstance().getTime());
			partidaDAO.insert(partida);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Partida registrada com sucesso!"));
			partida = new Partida();
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ocorreu um erro ao gravar a partida!"));
		}
//		return "partidas";
	}
	
	public void remove(){
		try {
			partidaDAO.remove(partidaDAO.findById(partidaExcluida.getIdPartida()));
		} catch (Exception e) {
			e.printStackTrace();
		}
//		return "partidas";
	}
	
	public List<Partida> getPartidas() {
		return partidaDAO.findAll();
	}

	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}

	public Partida getPartidaExcluida() {
		return partidaExcluida;
	}

	public void setPartidaExcluida(Partida partidaExcluida) {
		this.partidaExcluida = partidaExcluida;
	}

	
}
