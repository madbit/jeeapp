package org.madbit.jeeapp.persistence.dao;


public interface IDAOFactory {

	public IActorDAO createActorDAO();
	public IFilmDAO createFilmDAO();
	public IDirectorDAO createDirectorDAO();
}
