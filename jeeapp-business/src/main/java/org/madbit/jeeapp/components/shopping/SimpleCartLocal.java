package org.madbit.jeeapp.components.shopping;

import javax.ejb.Local;

@Local
public interface SimpleCartLocal {
	public int getCount();
	public void setCount(int count);
	public int increaseCount();
}
