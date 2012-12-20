package org.madbit.jeeapp.persistence.dao;

import javax.ejb.Singleton;

import org.madbit.jeeapp.persistence.dao.components.ActorDAO;
import org.madbit.jeeapp.persistence.dao.components.DirectorDAO;
import org.madbit.jeeapp.persistence.dao.components.FilmDAO;
import org.madbit.jeeapp.persistence.dao.components.IActorDAO;
import org.madbit.jeeapp.persistence.dao.components.IDirectorDAO;
import org.madbit.jeeapp.persistence.dao.components.IFilmDAO;

@Singleton
public class DAOFactory implements IDAOFactory {

	public IActorDAO createActorDAO() {
		return new ActorDAO();
	}

	public IFilmDAO createFilmDAO() {
		return new FilmDAO();
	}

	public IDirectorDAO createDirectorDAO() {
		return new DirectorDAO();
	}
}
