package org.madbit.jeeapp.servlet.shopping;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.madbit.jeeapp.components.shopping.ShoppingCartLocal;

public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1887779485906918947L;
	
	@EJB 
	private ShoppingCartLocal shoppingCartLocal;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter out = res.getWriter();
		out.println("<html><head><title>J2EE app</title></head>");
	    out.println("<body>");
	    
	    int count = shoppingCartLocal.getCount();
	    
	    out.println("Initial count: " + count);
	    
		count = shoppingCartLocal.checkout();		
		
	    out.println("<br />After checkout: " + count);
	    out.println("<br /><a href='index.jsp'>Index</a>");
	    out.println("</body>");
	    out.println("</html>");
	}
}
