package org.madbit.jeeapp.components;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.madbit.jeeapp.domain.Actor;
import org.madbit.jeeapp.domain.Director;
import org.madbit.jeeapp.domain.Film;

@Stateless
public class LibraryEJB implements LibraryEJBLocal {

	@PersistenceContext(unitName = "bookPU") 
	private EntityManager em;

	public Film addFilm(Film film) {
		em.persist(film);
		return film;
	}
	
	public Actor addActor(Actor actor) {
		em.persist(actor);
		return actor;
	}

	public Director addDirector(Director director) {
		em.persist(director);
		return director;
	}
}
