package br.galante.webapp.futebol.dao;


import javax.enterprise.context.ConversationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.galante.webapp.futebol.qualifier.DataRepository;

/**
 * This bean is used to hold the entity manager factory and to produce the
 * conversation scoped entity manager for injection
 */
@Singleton
public class DataRepositoryProducer {

	private static EntityManagerFactory emf;

	@Produces
	public EntityManagerFactory getEntityManagerFactory() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("futebol");
		}
		return emf;
	}

	@Produces
	@DataRepository
	@ConversationScoped
	public EntityManager produceEntityManager() {
		return getEntityManagerFactory().createEntityManager();
	}

}

