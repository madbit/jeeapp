package org.madbit.jeeapp.persistence.dao.components;

import org.madbit.jeeapp.persistence.domain.Director;

public interface IDirectorDAO {

	public void addDirector(Director director);
	public void updateDirector(Director director);
	public void deleteDirector(Director director);
}
