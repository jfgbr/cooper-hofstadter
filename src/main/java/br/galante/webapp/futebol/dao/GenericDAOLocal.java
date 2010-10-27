package br.galante.webapp.futebol.dao;

import java.util.List;

import javax.ejb.Local;

@Local
public interface GenericDAOLocal<T>{
	
	public void insert(T pojo) throws Exception;
	public List<T> findByExample(T filter) throws Exception;
	public List<T> findAll() throws Exception;
	public abstract String getClassPojoName();
}
