package org.madbit.jeeapp.persistence.dao.components;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class ActorDAO {
	
	@PersistenceContext(unitName = "VLibPU") 
	private EntityManager em;

}
