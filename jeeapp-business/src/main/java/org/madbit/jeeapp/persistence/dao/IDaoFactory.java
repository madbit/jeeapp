package org.madbit.jeeapp.persistence.dao;

import org.madbit.jeeapp.persistence.dao.components.IActorDAO;
import org.madbit.jeeapp.persistence.dao.components.IDirectorDAO;
import org.madbit.jeeapp.persistence.dao.components.IFilmDAO;

public interface IDAOFactory {

	public IActorDAO createActorDAO();
	public IFilmDAO createFilmDAO();
	public IDirectorDAO createDirectorDAO();
}
