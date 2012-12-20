package org.madbit.jeeapp.persistence.dao.components;

import org.madbit.jeeapp.persistence.domain.Film;

public interface IFilmDAO {
	
	public void addFilm(Film film);
	public void updateFilm(Film film);
	public void deleteFilm(Film film);

}
