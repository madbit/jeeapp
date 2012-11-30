package org.madbit.jeeapp.servlet.shopping;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.madbit.jeeapp.shopping.ejb.ShoppingCartLocal;

public class ShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 2789580260930727133L;
	
	@EJB private ShoppingCartLocal shoppingCartLocal;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op=request.getParameter("op");
		
		if(op.equals("add"))
			add(request, response);
		else if (op.equals("checkout")) {
			checkout(request, response);
		}
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int count = shoppingCartLocal.increaseCount();
		
		session.setAttribute("count", count);
		
		String nextJSP = "/shoppingCart.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);		
	}
	
	private void checkout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int count = shoppingCartLocal.checkout();
		
		HttpSession session = request.getSession();		
		session.setAttribute("count", count);
		
		String nextJSP = "/shoppingCart.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);		
	}	
}
