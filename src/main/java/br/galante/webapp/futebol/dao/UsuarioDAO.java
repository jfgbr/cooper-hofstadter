package br.galante.webapp.futebol.dao;

import javax.ejb.Stateless;

import br.galante.webapp.futebol.model.Usuario;

/**
 * Simple UsuarioDao bean that handles persisting a person entity and returning a
 * list of people in the database. Implemented as an EJB for the transaction
 * facilities. Implements the {@link UsuarioDaoLocal} interface but shouldn't be
 * needed with EJB 3.1 except Weld has issues looking up no-interface EJBs.
 * 
 */
@Stateless
public class UsuarioDAO extends GenericDAO<Usuario> {

	private static final long serialVersionUID = -3540627797280862661L;

//	public String getClassPojoName() {
//		return Usuario.class.getName();
//	}

	@Override
	public Class<Usuario> getClassPojo() {
		return Usuario.class;
	}

}
