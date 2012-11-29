package org.madbit.jeeapp.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.madbit.jeeapp.components.LibraryEJBLocal;

public class HelloServlet extends HttpServlet {

	private static final long serialVersionUID = 2474077708065777739L;
		
	@EJB
	private LibraryEJBLocal bookEJB;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletOutputStream sos = resp.getOutputStream();
		
	}
}
