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

import com.model.Classes;
import com.service.DbOperations;

/**
 * Servlet implementation class TeacherInfo
 */
@WebServlet("/AddTeacher")
public class AddTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 DbOperations dbo = new DbOperations();
	 List<Classes> cll = new ArrayList();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddTeacher() {
		super();
		this.cll = dbo.AllClasses();
		}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.print("<form action='AddTeacher' method='POST'");
		out.print(
				"style='text-align: center; border: 1px solid black; border-radius: 15px; padding:50px;background-color: lightgrey; margin:200px auto; width:800px;'>");
		out.print("<h1 class=\"item\">Add Teacher</h1>");
		out.print("Teacher name : <input type='text' placeholder='Enter teacher name' name='tname' required>");
		out.print("<br/><br/>");
		out.print("Assign Class : <select name='classId'>");
		for (Classes c : this.cll) {
			out.print("<option value='" + c.getCid() + "'>" + c.getCname() + "</option>");
		}
		out.print("</select>");
		out.print("<br/><br/>");
		out.print("<input type='submit' value='Submit' class='btn'  />");
		out.print("<br/><br/>");
		out.print("</form>");

		String name = request.getParameter("tname");
		String classId = request.getParameter("classId");

		try {
			out.print(name + classId);
			String res = dbo.AddTeacher(name, Integer.parseInt(classId));

			if (res.equals("Success")) {
				response.sendRedirect("Dashboard");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
