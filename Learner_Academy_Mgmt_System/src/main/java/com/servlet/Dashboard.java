package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbconn.DbConnection;
import com.model.Classes;
import com.model.Students;
import com.model.Teachers;
import com.model.Subjects;
import com.service.DbOperations;

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
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		DbOperations dbo = new DbOperations();

		out.print("<h1 style='text-align:center; width: 100%; padding: 10px;'>Administrator Dashboard</h1>");
		out.print("<br/>");
		out.print(
				"<p style='text-align:center;'> <a href='Dashboard'>Home</a> &nbsp;&nbsp;&nbsp; | &nbsp;&nbsp;&nbsp &nbsp; <a href='AddStudent'>Students</a> &nbsp;&nbsp;&nbsp; | &nbsp;&nbsp;&nbsp <a href='AddTeacher'>Teachers</a>  &nbsp;&nbsp;&nbsp; | &nbsp;&nbsp;&nbsp <a href='Subjects'>Subjects</a> &nbsp;&nbsp;&nbsp; | &nbsp;&nbsp;&nbsp &nbsp; <a href='AddClass'>Classes</a> &nbsp&nbsp;&nbsp; | &nbsp;&nbsp;&nbsp <a href='Login.html'>Logout</a> </p>");
		out.print("<hr/>");
		out.print("<br/>");
		
		out.print("<h3>Students</h3>");
		out.print("<table style='width:800px;' border='1'>");
		out.print("<tr><th>Student id </th><th>Student</th></tr>");
		List<Students> studentDataList = dbo.AllStudents();

		for (Students std : studentDataList) {
			out.print("<tr>");
			out.print("<td>" + std.getStdid() + "</td>");
			out.print("<td>" + std.getStdname() + "</td>");
			out.print("</tr>");
		}
		out.print("</table>");
		out.print("<br/>");

		out.print("<h3>Teachers</h3>");
		out.print("<table style='width:800px;' border='1'>");
		out.print("<tr><th>Teacher id</th><th>Teacher name</th></tr>");
		List<Teachers> teacherDataList = dbo.AllTeachers();

		for (Teachers teach : teacherDataList) {
			out.print("<tr>");
			out.print("<td>" + teach.getTid() + "</td>");
			out.print("<td>" + teach.getTname() + "</td>");
//			out.print("<td>" + teach.getCname() + "</td>");
			out.print("</tr>");
		}
		out.print("</table>");
		out.print("<br/>");

		out.print("<h3>Classes</h3>");
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
		out.print("<br/>");

		out.print("<h3>Subjects</h3>");
		out.print("<table style='width:800px;' border='1'>");
		out.print("<tr><th>Subject id</th><th>Subject name</th></tr>");
		List<Subjects> subjectDataList = dbo.AllSubjects();

		for (Subjects sub : subjectDataList) {
			out.print("<tr>");
			out.print("<td>" + sub.getSubid() + "</td>");
			out.print("<td>" + sub.getSubname() + "</td>");
			out.print("</tr>");
		}
		out.print("</table>");
	}

}
