package br.galante.webapp.futebol.dao;

import javax.ejb.Stateless;

import br.galante.webapp.futebol.model.Pais;

@Stateless
public class PaisDAO extends GenericDAO<Pais> {

	private static final long serialVersionUID = 9156125756988536594L;

//	public String getClassPojoName() {
//		return Pais.class.getName();
//	}

	@Override
	public Class<Pais> getClassPojo() {
		return Pais.class;
	}

}
