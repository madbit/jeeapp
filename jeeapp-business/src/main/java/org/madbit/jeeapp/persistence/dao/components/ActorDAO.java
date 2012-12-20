package org.madbit.jeeapp.persistence.dao.components;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.madbit.jeeapp.persistence.domain.Actor;

@Stateless
@LocalBean
public class ActorDAO implements IActorDAO {
	
	@PersistenceContext(unitName = "VLibPU") 
	private EntityManager em;

	public void addActor(Actor actor) {
		em.persist(actor);
	}

	public void updateActor(Actor actor) {
		// TODO Auto-generated method stub
		
	}

	public void deleteActor(Actor actor) {
		// TODO Auto-generated method stub
		
	}

}
