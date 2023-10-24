package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.DbOperations;

/**
 * Servlet implementation class Subjects
 */
@WebServlet("/Subjects")
public class Subjects extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Subjects() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("txtSubject");
		HttpSession session = request.getSession();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		DbOperations dbo = new DbOperations();
		
		try {
			String res = dbo.AddSubjects(name);
			
			if(res.equals("Success"))
			{
				response.sendRedirect("Dashboard");
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
