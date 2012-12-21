package org.madbit.jeeapp.shopping;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.madbit.jeeapp.persistence.dao.IDAOFactory;
import org.madbit.jeeapp.persistence.dao.components.IActorDAO;
import org.madbit.jeeapp.shopping.ejb.ShoppingCart;

@Singleton
public class ShoppingServiceLocator {

	private Context ctx;
	
	private String jndiName = "java:global/jeeapp/jeeapp-business/";
	
	@PostConstruct
	private void initialize() throws NamingException {
		this.ctx = new InitialContext();
	}	
	
	public ShoppingCart getShoppingCartBean() throws NamingException {
		ShoppingCart shoppingCart = (ShoppingCart) ctx.lookup(jndiName + "ShoppingCart");
		return shoppingCart;
	}
	
	public IDAOFactory getDAOFactory() throws NamingException {
		IDAOFactory daoFactory = (IDAOFactory) ctx.lookup(jndiName + "DAOFactory");
		return daoFactory;
	}
	
	public IActorDAO getActorDAO() throws NamingException {
		IActorDAO actorDAO = (IActorDAO) ctx.lookup(jndiName + "ActorDAO");
		return actorDAO;
	}
	
}
