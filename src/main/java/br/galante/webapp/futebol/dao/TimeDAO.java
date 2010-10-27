package br.galante.webapp.futebol.dao;

import javax.ejb.Stateless;

import br.galante.webapp.futebol.model.Time;

@Stateless
public class TimeDAO extends GenericDAO<Time> {

	private static final long serialVersionUID = -2064246940739291687L;

//	public String getClassPojoName() {
//		return Times.class.getName();
//	}

	@Override
	public Class<Time> getClassPojo() {
		return Time.class;
	}

}
