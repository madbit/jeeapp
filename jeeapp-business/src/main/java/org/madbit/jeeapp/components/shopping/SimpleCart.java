package org.madbit.jeeapp.components.shopping;

import javax.ejb.Stateless;

@Stateless
public class SimpleCart implements SimpleCartLocal {

	private int count;
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count=count;
	}
	
	public int increaseCount() {
		count++;
		return count;
	}
}
