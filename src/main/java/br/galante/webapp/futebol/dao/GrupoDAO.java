package br.galante.webapp.futebol.dao;

import br.galante.webapp.futebol.model.Grupo;

public class GrupoDAO extends GenericDAO<Grupo>{

	private static final long serialVersionUID = 1L;

	@Override
	public Class<Grupo> getClassPojo() {
		return Grupo.class;
	}

	
}
