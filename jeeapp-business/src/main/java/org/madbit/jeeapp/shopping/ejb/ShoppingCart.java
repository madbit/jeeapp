package org.madbit.jeeapp.shopping.ejb;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateful;

@Stateful(name="ShoppingCart")
@Local(ShoppingCartLocal.class)
public class ShoppingCart implements ShoppingCartLocal {

//	private Logger logger = Logger.getLogger(this.getClass());
	
	@EJB
	private CheckoutBean checkoutBean;
	
	private int count;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public int increaseCount() {
		System.out.println("Count initial: " + count);
		count++;
		System.out.println("Count final: " + count);
		return count;
	}

	public int checkout() {
		System.out.println("Final count: " + count);
		checkoutBean.checkout(count);		
		count = 0;
		return count;
	}
}
