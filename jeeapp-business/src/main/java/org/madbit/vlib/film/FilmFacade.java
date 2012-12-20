package org.madbit.vlib.film;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.madbit.jeeapp.persistence.dao.DAOFactory;
import org.madbit.jeeapp.persistence.dao.components.IActorDAO;
import org.madbit.jeeapp.persistence.dao.components.IDirectorDAO;
import org.madbit.jeeapp.persistence.dao.components.IFilmDAO;
import org.madbit.jeeapp.persistence.domain.Actor;
import org.madbit.jeeapp.persistence.domain.Director;
import org.madbit.jeeapp.persistence.domain.Film;

@Stateless
@LocalBean
public class FilmFacade {
	
	@EJB
	private DAOFactory daoFactory;
	
	public void addFilm(Film film) {
		IFilmDAO filmDAO = daoFactory.createFilmDAO();
		filmDAO.addFilm(film);
	}
	
	public void addActor(Actor actor) {
		IActorDAO actorDAO = daoFactory.createActorDAO();
		actorDAO.addActor(actor);
	}
	
	public void addDirector(Director director) {
		IDirectorDAO directorDAO = daoFactory.createDirectorDAO();
		directorDAO.addDirector(director);
	}
}
