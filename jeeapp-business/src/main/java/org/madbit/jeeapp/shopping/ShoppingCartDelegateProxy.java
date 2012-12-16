package org.madbit.jeeapp.shopping;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.madbit.jeeapp.shopping.ejb.ShoppingCart;

public class ShoppingCartDelegateProxy {
	
//	private static EJBContainer ec; 
//	private static Context ctx;
	
	@Resource
	private static SessionContext sctx;
	
//	@EJB 
	private ShoppingCart shoppingCart;
	
	
	public ShoppingCartDelegateProxy() {
		shoppingCart = (ShoppingCart) sctx.lookup("java:global/jeeapp/jeeapp-business-1.0.0/ShoppingCart!org.madbit.jeeapp.shopping.ejb.ShoppingCart");			
	}
	
	public int increaseCount(){
		
		return shoppingCart.increaseCount();
	}
	
	public int checkout(){
		return shoppingCart.checkout();
	}

}
	