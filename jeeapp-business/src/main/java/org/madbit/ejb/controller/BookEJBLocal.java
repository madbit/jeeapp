package org.madbit.ejb.controller;

import javax.ejb.Local;

import org.madbit.jeeapp.domain.Book;

@Local
public interface BookEJBLocal {
	public String getBook();
	public Book findBookById(long id);
	public Book addBook(Book book);
}
