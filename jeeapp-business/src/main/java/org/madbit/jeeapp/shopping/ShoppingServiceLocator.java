package org.madbit.jeeapp.shopping;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.madbit.jeeapp.shopping.ejb.ShoppingCart;

@Singleton
public class ShoppingServiceLocator {

	private Context ctx;
	
	@PostConstruct
	private void initialize() throws NamingException {
		this.ctx = new InitialContext();
	}	
	
	public ShoppingCart getShoppingCartBean() throws NamingException {
		ShoppingCart shoppingCart = (ShoppingCart) ctx.lookup("java:global/jeeapp/jeeapp-business/ShoppingCart!org.madbit.jeeapp.shopping.ejb.ShoppingCart");
		return shoppingCart;
	}
	
}
