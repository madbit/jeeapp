package org.madbit.jeeapp.shopping.ejb;

import javax.ejb.Local;

@Local
public interface ShoppingCartSlLocal {

	public int getCount();
	public void setCount(int count);
	public int increaseCount();
	public int checkout();
}
