package org.madbit.vlib.film;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.madbit.jeeapp.persistence.dao.components.ActorDAO;
import org.madbit.jeeapp.persistence.dao.components.DirectorDAO;
import org.madbit.jeeapp.persistence.dao.components.FilmDAO;
import org.madbit.jeeapp.persistence.domain.Actor;
import org.madbit.jeeapp.persistence.domain.Director;
import org.madbit.jeeapp.persistence.domain.Film;

@Stateless
@LocalBean
public class FilmFacade {
	
//	@EJB private DAOFactory daoFactory;
	
	@EJB private ActorDAO actorDAO;	
	@EJB private FilmDAO filmDAO;	
	@EJB private DirectorDAO directorDAO;
	
	public Film addFilm(Film film) {
		return filmDAO.addFilm(film);
	}
	
	public Actor addActor(Actor actor) {
//		IActorDAO actorDAO = daoFactory.createActorDAO();
		return actorDAO.addActor(actor);
	}
	
	public Director addDirector(Director director) {
//		IDirectorDAO directorDAO = daoFactory.createDirectorDAO();
		return directorDAO.addDirector(director);
	}
	
	public void getFilmsByDirectorID(long id) {
		directorDAO.getFilmsByDirectorID(id);
	}
}
