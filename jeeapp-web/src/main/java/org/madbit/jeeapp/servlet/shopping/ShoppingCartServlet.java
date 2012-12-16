package org.madbit.jeeapp.servlet.shopping;

import java.io.IOException;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.madbit.jeeapp.shopping.ShoppingCartDelegateProxy;
import org.madbit.jeeapp.shopping.ejb.ShoppingCart;

public class ShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 2789580260930727133L;
	
//	@EJB 
//	private ShoppingCart shoppingCartLocal;
//	
//	@EJB
//	private ShoppingCartSl shoppingCartSlLocal;	
		
	@Resource
	private static SessionContext sctx;

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
//		ShoppingCartDelegateProxy proxy = new ShoppingCartDelegateProxy();
//		int count = proxy.increaseCount();
		
		ShoppingCart shoppingCart = (ShoppingCart) sctx.lookup("java:global/jeeapp/jeeapp-business-1.0.0/ShoppingCart!org.madbit.jeeapp.shopping.ejb.ShoppingCart");
//		try {
//			EJBContainer ec = EJBContainer.createEJBContainer(); 
//			Context ctx = ec.getContext();
////			Context ctx = new InitialContext();			
//			shoppingCartLocal = (ShoppingCart) ctx.lookup("java:global/jeeapp/jeeapp-business-1.0.0/ShoppingCart!org.madbit.jeeapp.shopping.ejb.ShoppingCart");
		
			int count = shoppingCart.increaseCount();
	//		int simpleCount = shoppingCartSlLocal.increaseCount();
			
			HttpSession session = request.getSession();		
			session.setAttribute("count", count);
	//		session.setAttribute("simpleCount", simpleCount);
			
			String nextJSP = "/shoppingCart.jsp";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);		
			dispatcher.forward(request, response);
//		} catch (NamingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	private void checkout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShoppingCartDelegateProxy proxy = new ShoppingCartDelegateProxy();
		int count = proxy.checkout();
		
//		int count = shoppingCartLocal.checkout();
//		int simpleCount = shoppingCartSlLocal.checkout();
		
		HttpSession session = request.getSession();		
		session.setAttribute("count", count);
//		session.setAttribute("simpleCount", simpleCount);
		
		String nextJSP = "/shoppingCart.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);		
	}	
}
