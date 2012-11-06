package org.madbit.ejb.controller;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.madbit.jeeapp.domain.Book;

@Stateless
public class BookEJB implements BookEJBLocal {

	@PersistenceContext(unitName = "bookPU") 
	private EntityManager em;

	public String getBook() {
		return "Ciao";
	}

	public Book findBookById(long id) { 
		return em.find(Book.class, id); 
	}

	public Book addBook(Book book) {
		em.persist(book);
		return book;
	}
}
