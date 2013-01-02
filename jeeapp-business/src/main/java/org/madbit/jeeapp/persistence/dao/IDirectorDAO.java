package org.madbit.jeeapp.persistence.dao;

import java.util.List;

import org.madbit.jeeapp.persistence.domain.Director;
import org.madbit.jeeapp.persistence.domain.Film;

public interface IDirectorDAO {

	public Director addDirector(Director director);
	public void updateDirector(Director director);
	public void deleteDirector(Director director);
	public List<Film> getFilmsByDirectorID(long id);
}
