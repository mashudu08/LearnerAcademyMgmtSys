package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.DbOperations;
import com.model.Classes;
import com.model.Subjects;

/**
 * Servlet implementation class AddClass
 */
@WebServlet("/AddClass")
public class AddClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 DbOperations dbo = new DbOperations();
	 List<Subjects> asub = new ArrayList();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddClass() {
        super();
       this.asub = dbo.AllSubjects();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.print("<h1 style='text-align:center; width: 100%; padding: 10px;'>Administrator Dashboard</h1>");
		out.print("<br/>");
		out.print("<p style='text-align:center; color:red; text-decoration:none;'> <a href='Dashboard'>Home</a> &nbsp;&nbsp;&nbsp; | &nbsp;&nbsp;&nbsp <a href='Login.html'>Logout</a> </p>");
		out.print("<hr/>");
		
		out.print("<form action='AddClass' method='POST'");
		out.print("style='text-align: center; border: 1px solid black; border-radius: 15px; padding:50px;background-color: lightcyan; margin:50px auto; width:800px;'>");
		out.print("<h1>Add Class</h1>");
		out.print("<br/><br/>");
		out.print("<br/>");
		out.print("Class name : <input type='text' placeholder='Enter class name' name='cname' required>");
		out.print("<br/><br/>");
		out.print("Assign Subject : <select name='subjectId'>");
		for(Subjects sub : this.asub) {
			out.print("<option value='"+sub.getSubid()+"'>"+sub.getSubname()+"</option>");
		}
		out.print("</select>");
		out.print("<br/><br/>");
		out.print("<input type='submit' value='Submit' class='btn'  />");
		out.print("<br/><br/>");
		out.print("</form>");

		String name = request.getParameter("cname");
		String subjectId = request.getParameter("subjectId");
		
		try {
			String res = dbo.AddClasses(name, Integer.parseInt(subjectId));
			
			if(res.equals("Success"))
			{
//				response.sendRedirect("Dashboard");
				out.print("Class added successfully!");
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		out.print("<table style='width:800px;' border='1'>");
		out.print("<tr><th>Class id</th><th>Classes</th></tr>");
		List<Classes> classDataList = dbo.AllClasses();

		for (Classes cls : classDataList) {
			out.print("<tr>");
			out.print("<td>" + cls.getCid() + "</td>");
			out.print("<td>" + cls.getCname() + "</td>");
			out.print("</tr>");
		}
		out.print("</table>");

	}

}
