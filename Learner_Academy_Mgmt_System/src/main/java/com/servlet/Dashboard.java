package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Dashboard
 */
@WebServlet("/Dashboard")
public class Dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dashboard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<h1 style='text-align:center; width: 100%; padding: 10px;'>Administrator Dashboard</h1>");
		out.print("<br/>");
		out.print("<p style='text-align:center; color:red; text-decoration:none;'> <a href='Dashboard'>Home</a> &nbsp;&nbsp;&nbsp; | &nbsp;&nbsp;&nbsp &nbsp; <a href='#'>Add Student</a> &nbsp;&nbsp;&nbsp; | &nbsp;&nbsp;&nbsp <a href='#'>Add Teacher</a>  &nbsp;&nbsp;&nbsp; | &nbsp;&nbsp;&nbsp <a href='#'>Add Subject</a> &nbsp;&nbsp;&nbsp; | &nbsp;&nbsp;&nbsp &nbsp; <a href='#'>Add Class</a> &nbsp&nbsp;&nbsp; | &nbsp;&nbsp;&nbsp <a href='Login.html'>Logout</a> </p>");
		out.print("<hr/>");
		out.print("<br/><br/>");
		
		out.print("<table width='100%' border='1'>");
		
		out.print("<tr><th>Student name</th><th>Subject </th><th>Class</th><th>Teacher</th></tr>");
		
//		out.print("<tr>");
//		out.print("<td>"+std.getRollno()+"</td>");
//		out.print("<td>"+std.getStdname()+"</td>");
//		out.print("<td>"+std.getCourse()+"</td>");
//		out.print("<td>"+std.getFees()+"</td>");
//		out.print("<td>"+std.getEmail()+"</td>");
//		out.print("<td>"+std.getPwd()+"</td>");
//		out.print("<tr/>");
		
		out.print("</table");
	}

}
