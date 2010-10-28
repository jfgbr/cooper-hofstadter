package br.galante.webapp.futebol.dao;

import javax.ejb.Stateless;

import br.galante.webapp.futebol.model.Participante;

@Stateless
public class ParticipanteDAO extends GenericDAO<Participante> {

	private static final long serialVersionUID = 7454023689186462194L;

	@Override
	public Class<Participante> getClassPojo() {
		return Participante.class;
	}
	
}
