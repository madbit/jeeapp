package org.madbit.jeeapp.persistence.dao.components;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.madbit.jeeapp.persistence.dao.IActorDAO;
import org.madbit.jeeapp.persistence.domain.Actor;

@Stateless
@LocalBean
public class ActorDAO implements IActorDAO {
	
	@PersistenceContext(unitName = "VLibPU") 
	private EntityManager em;

	public Actor addActor(Actor actor) {
		em.persist(actor);
		return actor;
	}

	public void updateActor(Actor actor) {
		em.merge(actor);
	}

	public void deleteActor(Actor actor) {
		em.remove(actor);
	}
}
