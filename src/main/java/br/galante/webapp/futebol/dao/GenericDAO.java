package br.galante.webapp.futebol.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;

import br.galante.webapp.futebol.qualifier.DataRepository;

@Stateless
public abstract class GenericDAO<T> implements Serializable {

	private static final long serialVersionUID = 8439364110131219122L;
	
	@Inject
	@DataRepository
	private EntityManager entityManager;
		
	public EntityManager getEntityManager(){
		return entityManager;
	}

	public EntityTransaction getTransaction() {
		return entityManager.getTransaction();
	}
	
	public T insert(T pojo) throws Exception {
		try {
			start();
			entityManager.persist(pojo);
			stop(true);
			entityManager.detach(pojo);			
			return pojo;
		} catch (Exception e) {
			stop(false);
			throw new Exception(e);
		}		
	}
	
	public void remove(T pojo) throws Exception {
		try {
			start();
			entityManager.remove(pojo);
			stop(true);
		} catch (Exception e) {
			stop(false);
			throw new Exception(e);
		}		
	}
	
	public abstract Class<T> getClassPojo();
	
//	public abstract String getClassPojoName();
	
	public void start() {  
        getTransaction().begin();  
    }  
  
    public void stop(boolean commitChanges) {  
        if (commitChanges) {  
            getTransaction().commit();  
        } else {  
            getTransaction().rollback();  
        }  
//        getEntityManager().close();  
    }  
	
    @SuppressWarnings("unchecked")
    public List<T> findByExample(T filter) throws Exception {  
        Session session = (Session) getEntityManager().getDelegate();  
        Example example = Example.create(filter).excludeZeroes();  
        Criteria criteria = session.createCriteria(filter.getClass()).add(example);  
        return criteria.list();
    } 
	
	@SuppressWarnings("unchecked")
	public List<T> findAll(){  
        List<T> results = null;  
        Query query = getEntityManager().createQuery("SELECT object(o) FROM " + getClassPojo().getName() + " AS o");  
        results = query.getResultList();  
      
        return results;  
    } 
	
	/**
	 * Finds an entity by its identity (i.e. primary key).
	 * 
	 * @param id	identity
	 * @return	the object instance
	 */
	public T findById(Serializable id) {
		return (T) getEntityManager().find(getClassPojo(), id);
	}
}
