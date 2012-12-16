package org.madbit.jeeapp.shopping.ejb;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

@Stateless(name="ShoppingCartSl")
@LocalBean
public class ShoppingCartSl {

	private Logger logger = Logger.getLogger(this.getClass());
	
	@EJB
	private CheckoutBean checkoutBean;
	
	private int count;
	
	@PostConstruct
	public void init() {
		System.out.println("Stateless EJB created");
		logger.debug("Stateless EJB created");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("EJB destroyed");
		logger.debug("EJB destroyed");
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public int increaseCount() {
		count++;
		System.out.println("Stateless count: " + count);
		logger.debug("Stateless count: " + count);
		return count;
	}

	public int checkout() {
		System.out.println("Stateless final count: " + count);
		logger.debug("Stateless final count: " + count);
		checkoutBean.checkout(count);		
		count = 0;
		return count;
	}
}
