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
		
		
		out.print("<form action='AddClass' method='POST'");
		out.print("style='text-align: center; border: 1px solid black; border-radius: 15px; padding:50px;background-color: lightgrey; margin:200px auto; width:800px;'>");
		out.print("<h1 class=\"item\">Add Class</h1>");
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
				response.sendRedirect("Dashboard");
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
