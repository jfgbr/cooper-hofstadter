package br.galante.webapp.futebol.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ConversationScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import br.galante.webapp.futebol.dao.TimeDAO;
import br.galante.webapp.futebol.model.Time;

@Named("timeMB")
@ConversationScoped
public class TimeMB implements Serializable {

	private static final long serialVersionUID = -5580627558164281958L;

	@Inject
	private TimeDAO timeDAO;
	
	private List<Time> lstTimes;
	
	private Time time = new Time();
	
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
	
}
