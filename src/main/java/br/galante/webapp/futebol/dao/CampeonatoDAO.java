package br.galante.webapp.futebol.dao;

import javax.ejb.Stateless;

import br.galante.webapp.futebol.model.Campeonato;

@Stateless
public class CampeonatoDAO extends GenericDAO<Campeonato>{

	private static final long serialVersionUID = 7454023689186462194L;

	@Override
	public Class<Campeonato> getClassPojo() {
		return Campeonato.class;
	}

}
