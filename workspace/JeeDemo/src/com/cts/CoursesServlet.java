package com.cts;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CoursesServlet")
public class CoursesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	CoursesRepo repo
		 = new CoursesRepo();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Course> courses = repo.findAllCourses();
		RequestDispatcher rd = request.getRequestDispatcher("courses.jsp");
		request.setAttribute("courses", courses);
		rd.forward(request, response);
		
	}

	
}
