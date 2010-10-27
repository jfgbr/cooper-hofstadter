package br.galante.webapp.futebol.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.galante.webapp.futebol.model.Partida;

@Stateless
public class PartidaDAO extends GenericDAO<Partida> {

	private static final long serialVersionUID = 1889339217449944032L;

//	public String getClassPojoName() {
//		return Partidas.class.getName();
//	}

	@SuppressWarnings("unchecked")
	public List<Partida> findComplete() {
		Session session = (Session) getEntityManager().getDelegate();
		Criteria consulta = session.createCriteria(getClassPojo());  
		consulta.setFetchMode("usuarioByIdUsuarioCasa", FetchMode.JOIN);
		consulta.setFetchMode("timesByIdTimeCasa", FetchMode.JOIN);
		consulta.setFetchMode("usuarioByIdUsuarioVisitante", FetchMode.JOIN);
		consulta.setFetchMode("timesByIdTimeVisitante", FetchMode.JOIN);
		return consulta.list();
	}

	public Partida load(Serializable id){
		Session session = (Session) getEntityManager().getDelegate();
		Criteria consulta = session.createCriteria(getClassPojo());
		consulta.add(Restrictions.eq("idPartidas", id));
		consulta.setFetchMode("usuarioByIdUsuarioCasa", FetchMode.JOIN);
		consulta.setFetchMode("timesByIdTimeCasa", FetchMode.JOIN);
		consulta.setFetchMode("usuarioByIdUsuarioVisitante", FetchMode.JOIN);
		consulta.setFetchMode("timesByIdTimeVisitante", FetchMode.JOIN);
		
		return (Partida)consulta.uniqueResult();
	}
	
	@Override
	public Class<Partida> getClassPojo() {
		// TODO Auto-generated method stub
		return Partida.class;
	}
}
