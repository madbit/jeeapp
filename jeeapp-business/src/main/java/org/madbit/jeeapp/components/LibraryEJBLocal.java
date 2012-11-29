package org.madbit.jeeapp.components;

import javax.ejb.Local;

import org.madbit.jeeapp.domain.Actor;
import org.madbit.jeeapp.domain.Director;
import org.madbit.jeeapp.domain.Film;

@Local
public interface LibraryEJBLocal {
	public Film addFilm(Film film);
	public Actor addActor(Actor actor);
	public Director addDirector(Director director);
}
