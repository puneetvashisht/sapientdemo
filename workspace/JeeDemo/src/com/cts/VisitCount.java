package com.cts;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/VisitCount")
public class VisitCount extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Integer userVisits;
	
	public void init(){
		userVisits = 0;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Visit count: ").append(""+(userVisits++));
	}

	

}
