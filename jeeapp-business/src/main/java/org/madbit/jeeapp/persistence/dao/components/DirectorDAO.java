package org.madbit.jeeapp.persistence.dao.components;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.madbit.jeeapp.persistence.domain.Director;

@Stateless
@LocalBean
public class DirectorDAO implements IDirectorDAO {
	
	@PersistenceContext(unitName = "VLibPU") 
	private EntityManager em;

	public void addDirector(Director director) {
		em.persist(director);
	}

	public void updateDirector(Director director) {
		// TODO Auto-generated method stub
		
	}

	public void deleteDirector(Director director) {
		// TODO Auto-generated method stub
		
	}

}
