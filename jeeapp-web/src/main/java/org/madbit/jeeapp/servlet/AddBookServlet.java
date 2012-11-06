package org.madbit.jeeapp.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.madbit.ejb.controller.BookEJBLocal;
import org.madbit.jeeapp.domain.Book;

public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 4223489592960466469L;
	
	@EJB
	private BookEJBLocal bookEJB;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String title = req.getParameter("title");		
		float price = Float.parseFloat(req.getParameter("price"));
		String description = req.getParameter("description");		
		String isbn = req.getParameter("isbn");		
		int nbOfPage = Integer.parseInt(req.getParameter("nbOfPage"));		
		boolean illustrations = Boolean.parseBoolean(req.getParameter("illustrations"));
		
		Book book = new Book();
		book.setTitle(title);
		book.setPrice(price);
		book.setDescription(description);
		book.setIsbn(isbn);
		book.setNbOfPage(nbOfPage);
		book.setIllustrations(illustrations);
		
		bookEJB.addBook(book);
	}
}
