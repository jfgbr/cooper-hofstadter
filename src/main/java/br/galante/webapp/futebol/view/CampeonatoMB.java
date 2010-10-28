package br.galante.webapp.futebol.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.DualListModel;

import br.galante.webapp.futebol.dao.CampeonatoDAO;
import br.galante.webapp.futebol.dao.TimeDAO;
import br.galante.webapp.futebol.dao.UsuarioDAO;
import br.galante.webapp.futebol.model.Campeonato;
import br.galante.webapp.futebol.model.Time;
import br.galante.webapp.futebol.model.Usuario;

@Named("campeonatoMB")
@RequestScoped
public class CampeonatoMB implements Serializable {

	private static final long serialVersionUID = 773641593763101252L;

	@Inject
	private CampeonatoDAO campeonatoDAO;
	@Inject
	private UsuarioDAO usuarioDAO;
	@Inject
	private TimeDAO timeDAO;
	
	private Campeonato campeonato = new Campeonato();
	private Campeonato campeonatoExcluido;
	private Campeonato campeonatoSelecionado;
	private DualListModel<Usuario> usuarios;
	private DualListModel<Time> times;
	
	private DualListModel<String> teste;
	
	public void save(ActionEvent actionEvent){
		try {
			campeonatoDAO.insert(campeonato);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Partida registrada com sucesso!"));
			campeonato = new Campeonato();
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ocorreu um erro ao gravar a partida!"));
		}
	}
	
	public void remove(){
		try {
			campeonatoDAO.remove(campeonatoDAO.findById(campeonatoExcluido.getIdCampeonato()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void sorteia(ActionEvent actionEvent){
		///
	}
	
	public List<Campeonato> getCampeonatos() {
		return campeonatoDAO.findAll();
	}

	public Campeonato getCampeonato() {
		return campeonato;
	}

	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}

	public Campeonato getCampeonatoExcluido() {
		return campeonatoExcluido;
	}

	public void setCampeonatoExcluido(Campeonato campeonatoExcluido) {
		this.campeonatoExcluido = campeonatoExcluido;
	}

	public Campeonato getCampeonatoSelecionado() {
		return campeonatoSelecionado;
	}

	public void setCampeonatoSelecionado(Campeonato campeonatoSelecionado) {
		this.campeonatoSelecionado = campeonatoSelecionado;
	}

	public DualListModel<Usuario> getUsuarios() {
		if (usuarios == null){
			List<Usuario> source = new ArrayList<Usuario>();
			List<Usuario> target = new ArrayList<Usuario>();
			source = usuarioDAO.findAll();
			usuarios = new DualListModel<Usuario>(source, target);
		}
		return usuarios;
	}

	public void setUsuarios(DualListModel<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public DualListModel<Time> getTimes() {
		if (times == null){
			List<Time> source = new ArrayList<Time>();
			List<Time> target = new ArrayList<Time>();
			source = timeDAO.findAll();
			times = new DualListModel<Time>(source, target);
		}
		return times;
	}

	public void setTimes(DualListModel<Time> times) {
		this.times = times;
	}

	public DualListModel<String> getTeste() {
		if (teste==null){
			List<String> source = new ArrayList<String>();
			List<String> target = new ArrayList<String>();
			source.add("Istanbul");
			source.add("Ankara");
			source.add("Izmir");
			source.add("Antalya");
			source.add("Bursa");
			teste = new DualListModel<String>(source, target);
		}
		return teste;
	}

	public void setTeste(DualListModel<String> teste) {
		this.teste = teste;
	}
}
