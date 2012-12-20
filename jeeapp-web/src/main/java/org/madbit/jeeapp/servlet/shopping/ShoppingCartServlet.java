package org.madbit.jeeapp.servlet.shopping;

import java.io.IOException;

import javax.ejb.EJB;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.madbit.jeeapp.shopping.ShoppingServiceLocator;
import org.madbit.jeeapp.shopping.ejb.ShoppingCart;

public class ShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 2789580260930727133L;
	
	@EJB
	ShoppingServiceLocator shoppingServiceLocator;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op=request.getParameter("op");
		System.out.println(Thread.currentThread().getName());
		if(op.equals("add"))
			add(request, response);
		else if (op.equals("checkout")) {
			checkout(request, response);
		}
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {			
			HttpSession session = request.getSession();
			ShoppingCart  shoppingCart = null;
			
			if(session.getAttribute("shoppingCartBean") != null)
				shoppingCart = (ShoppingCart) session.getAttribute("shoppingCartBean");
			else
				shoppingCart = shoppingServiceLocator.getShoppingCartBean();
			
			int count = shoppingCart.increaseCount();
			session.setAttribute("shoppingCartBean", shoppingCart);				
			session.setAttribute("count", count);
			
			String nextJSP = "/shoppingCart.jsp";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);		
			dispatcher.forward(request, response);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void checkout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {			
			HttpSession session = request.getSession();
			ShoppingCart shoppingCart = null;
			
			if(session.getAttribute("shoppingCartBean") != null)
				shoppingCart = (ShoppingCart) session.getAttribute("shoppingCartBean");
			else
				shoppingCart = shoppingServiceLocator.getShoppingCartBean();
			
			int count = shoppingCart.checkout();
			session.removeAttribute("shoppingCartBean");
			session.setAttribute("count", count);
			
			String nextJSP = "/shoppingCart.jsp";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
			dispatcher.forward(request, response);	
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	}	
}
