package org.madbit.jeeapp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 4223489592960466469L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String title = req.getParameter("title");		
		float price = Float.parseFloat(req.getParameter("price"));
		String description = req.getParameter("description");		
		String isbn = req.getParameter("isbn");		
		int nbOfPage = Integer.parseInt(req.getParameter("nbOfPage"));		
		boolean illustrations = Boolean.parseBoolean(req.getParameter("illustrations")); 
	}

	
}
