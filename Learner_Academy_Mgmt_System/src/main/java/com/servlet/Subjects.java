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
		
		HttpSession session = request.getSession();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.print("<h1 style='text-align:center; width: 100%; padding: 10px;'>Administrator Dashboard</h1>");
		out.print("<br />");
		out.print("<p style=\"text-align:center;\"><a href='Dashboard'>Home</a> &nbsp;&nbsp;&nbsp; | &nbsp;&nbsp;&nbsp; <a href='Login.html'>Logout</a></p>");
		out.print("<hr />");
		out.print("<form name='formSubject' action='Subjects' method='POST'");
		out.print("style='text-align: center; border: 1px solid black; border-radius: 15px; padding:50px; background-color: lightcyan; margin:50px auto; width:800px;'>");
		out.print("<h1>Add Subject</h1>");
		out.print("<br/><br/>");
		out.print("<br/>");
		out.print("Subject name : <input type='text' placeholder='Enter subject' name='txtSubject' required>");
		out.print("<br /><br />");
		out.print("<input type='submit' value='Submit'/>");
		out.print("</form>");
		
		String name = request.getParameter("txtSubject");
		DbOperations dbo = new DbOperations();
		
		try {
			String res = dbo.AddSubjects(name);
			
			if(res.equals("Success"))
			{
				out.print("Subject added!");
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
