package org.madbit.jeeapp.persistence.dao;

import org.madbit.jeeapp.persistence.domain.Film;

public interface IFilmDAO {
	
	public Film addFilm(Film film);
	public void updateFilm(Film film);
	public void deleteFilm(Film film);

}
