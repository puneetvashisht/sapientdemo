package com.cts;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		User user = new User(name, password);
		
		System.out.println(name + " : " + password);
		if(name.equals(password)){
			
			RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
//			response.getWriter().println("<div class=\"card\" style=\"width: 18rem;\">");
			request.setAttribute("user", user);
			rd.forward(request, response);

		}
		else{
			response.getWriter().println("Error Loggin In");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
