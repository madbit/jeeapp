package org.madbit.jeeapp.persistence.dao;

import org.madbit.jeeapp.persistence.domain.Actor;

public interface IActorDAO {
	
	public Actor addActor(Actor actor);
	public void updateActor(Actor actor);
	public void deleteActor(Actor actor);
}