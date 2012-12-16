package org.madbit.jeeapp.shopping.ejb;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;

import org.jboss.logging.Logger;

@Stateful
@LocalBean
public class ShoppingCart {

	private Logger logger = Logger.getLogger(this.getClass());
	
	@EJB
	private CheckoutBean checkoutBean;
	
	private int count;
	
	@PostConstruct
	public void init() {
		System.out.println("Stateful EJB created");
		logger.debug("Stateful EJB created");
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
		System.out.println("Stateful count: " + count);
		logger.debug("Stateful count: " + count);
		return count;
	}

	public int checkout() {
		System.out.println("Stateful final count: " + count);
		logger.debug("Stateful final count: " + count);
		checkoutBean.checkout(count);		
		count = 0;
		return count;
	}
}
