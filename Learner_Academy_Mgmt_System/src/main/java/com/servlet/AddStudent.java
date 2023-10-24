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
import com.model.Students;
import com.service.DbOperations;

/**
 * Servlet implementation class StudentInfo
 */
@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 DbOperations dbo = new DbOperations();
	 List<Classes> cll = new ArrayList();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudent() {
        super();
        this.cll = dbo.AllClasses();
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

		
		out.print("<form action='AddStudent' method='POST'");
		out.print(
				"style='text-align: center; border: 1px solid black; border-radius: 15px; padding:50px;background-color: lightcyan; margin:50px auto; width:800px;'>");
		out.print("<h1>Add Student</h1>");
		out.print("<br/><br/>");
		out.print("<br/>");
		out.print("Student name : <input type='text' placeholder='Enter student name' name='sname' required>");
		out.print("<br/><br/>");
		out.print("Assign Class : <select name='classId'>");
		for (Classes c : this.cll) {
			out.print("<option value='" + c.getCid() + "'>" + c.getCname() + "</option>");
		}
		out.print("</select>");
		out.print("<br/><br/>");
		out.print("<input type='submit' value='Submit'/>");
		out.print("<br/><br/>");
		out.print("</form>");

		String name = request.getParameter("sname");
		String classId = request.getParameter("classId");

		try {
			String res = dbo.AddStudent(name, Integer.parseInt(classId));

			if (res.equals("Success")) {
//				response.sendRedirect("Dashboard");
				out.print("Student added successfully!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		out.print("<h1>Students</h1>");
		out.print("<table width='100%' border='1'>");
		out.print("<tr><th>Student id </th><th>Student</th></tr>");
		List<Students> studentDataList = dbo.AllStudents();

		for (Students std : studentDataList) {
			out.print("<tr>");
			out.print("<td>" + std.getStdid() + "</td>");
			out.print("<td>" + std.getStdname() + "</td>");
			out.print("</tr>");
		}
		out.print("</table>");
		
	}

}
