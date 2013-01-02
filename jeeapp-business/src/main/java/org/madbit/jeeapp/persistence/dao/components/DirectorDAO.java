package org.madbit.jeeapp.persistence.dao.components;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.madbit.jeeapp.persistence.dao.IDirectorDAO;
import org.madbit.jeeapp.persistence.domain.Director;
import org.madbit.jeeapp.persistence.domain.Film;

@Stateless
@LocalBean
public class DirectorDAO implements IDirectorDAO {
	
	@PersistenceContext(unitName = "VLibPU") 
	private EntityManager em;

	public Director addDirector(Director director) {
		em.persist(director);
		return director;
	}

	public void updateDirector(Director director) {
		// TODO Auto-generated method stub
		
	}

	public void deleteDirector(Director director) {
		// TODO Auto-generated method stub
		
	}

	public List<Film> getFilmsByDirectorID(long id) {
		Director d = em.find(Director.class, id);
		return d.getFilms();
	}
}
