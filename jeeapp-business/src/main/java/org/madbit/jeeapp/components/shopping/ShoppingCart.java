package org.madbit.jeeapp.components.shopping;

import javax.ejb.Local;
import javax.ejb.Stateful;

import org.apache.log4j.Logger;

@Stateful(name="ShoppingCart")
@Local(ShoppingCartLocal.class)
public class ShoppingCart implements ShoppingCartLocal {

	private Logger logger = Logger.getLogger(this.getClass());
	
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
		count = 0;
		return count;
	}
}
