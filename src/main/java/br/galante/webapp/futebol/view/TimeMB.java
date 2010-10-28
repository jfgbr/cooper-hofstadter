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

import br.galante.webapp.futebol.dao.TimeDAO;
import br.galante.webapp.futebol.model.Time;

@Named("timeMB")
@ConversationScoped
public class TimeMB extends GenericMB<Time> implements Serializable {

	private static final long serialVersionUID = -5580627558164281958L;

	@Inject
	private TimeDAO timeDAO;
	
	private List<Time> lstTimes;
	
	private Time time = new Time();
	
	private Time timeExcluido;
	

	public void save(ActionEvent actionEvent){
		try {
			timeDAO.insert(time);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Os dados foram gravados com sucesso!"));
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ocorreu um erro ao gravar os dados!"));
		}
	}
	
	public void remove(){
		try {
			timeDAO.remove(timeDAO.findById(timeExcluido.getIdTime()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Time> getTimes() {
		lstTimes = timeDAO.findAll();
		return lstTimes;
	}
	
	public List<SelectItem> getComboTimes(){
		
		List<SelectItem> cmbTimes = new ArrayList<SelectItem>();
		
		if (lstTimes == null)
			getTimes();
		
		for (Time time : lstTimes) {
			cmbTimes.add(new SelectItem(time.getIdTime(), time.getAbreviacao()));
		}
		
		return cmbTimes;		
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public Time getTimeExcluido() {
		return timeExcluido;
	}

	public void setTimeExcluido(Time timeExcluido) {
		this.timeExcluido = timeExcluido;
	}

}
