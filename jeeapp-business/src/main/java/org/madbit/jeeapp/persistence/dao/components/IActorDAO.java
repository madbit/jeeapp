package org.madbit.jeeapp.persistence.dao.components;

import org.madbit.jeeapp.persistence.domain.Actor;

public interface IActorDAO {
	
	public void addActor(Actor actor);
	public void updateActor(Actor actor);
	public void deleteActor(Actor actor);
}
