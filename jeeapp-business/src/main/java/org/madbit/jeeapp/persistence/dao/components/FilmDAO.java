package org.madbit.jeeapp.persistence.dao.components;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.madbit.jeeapp.persistence.dao.IFilmDAO;
import org.madbit.jeeapp.persistence.domain.Film;

@Stateless
@LocalBean
public class FilmDAO implements IFilmDAO {
	
	@PersistenceContext(unitName = "VLibPU") 
	private EntityManager em;

	public Film addFilm(Film film) {
		em.persist(film);
		return film;
	}

	public void updateFilm(Film film) {
		// TODO Auto-generated method stub
		
	}

	public void deleteFilm(Film film) {
		// TODO Auto-generated method stub
		
	}

}
