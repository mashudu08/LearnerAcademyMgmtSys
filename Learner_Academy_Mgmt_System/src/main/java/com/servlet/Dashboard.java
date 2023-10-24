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
				"<p style='text-align:center; color:red; text-decoration:none;'> <a href='Dashboard'>Home</a> &nbsp;&nbsp;&nbsp; | &nbsp;&nbsp;&nbsp &nbsp; <a href='StudentInfo.html'>Add Student</a> &nbsp;&nbsp;&nbsp; | &nbsp;&nbsp;&nbsp <a href='AddTeacher'>Add Teacher</a>  &nbsp;&nbsp;&nbsp; | &nbsp;&nbsp;&nbsp <a href='AddSubject.html'>Add Subject</a> &nbsp;&nbsp;&nbsp; | &nbsp;&nbsp;&nbsp &nbsp; <a href='AddClass'>Add Class</a> &nbsp&nbsp;&nbsp; | &nbsp;&nbsp;&nbsp <a href='Login.html'>Logout</a> </p>");
		out.print("<hr/>");
		out.print("<br/><br/>");

		out.print("<table width='100%' border='1'>");

		out.print("<tr><th>Srudent id </th><th>Student</th></tr>");

		List<Students> studentDataList = dbo.AllStudents();

		for (Students std : studentDataList) {
			out.print("<tr>");
			out.print("<td>" + std.getStdid() + "</td>");
			out.print("<td>" + std.getStdname() + "</td>");
			out.print("</tr>");
		}
		out.print("</table");
		out.print("<br/><br/>");
		
		out.print("<table width='100%' border='1'>");

		out.print("<tr><th>Teacher if</th><th>Subject </th><th>Teacher name</th></tr>");

		List<Teachers> teacherDataList = dbo.AllTeachers();


		for (Teachers teach : teacherDataList) {
			out.print("<tr>");
			out.print("<td>" + teach.getTid() + "</td>");
			out.print("<td>" + teach.getTname()+ "</td>");
			out.print("</tr>");
		}
		out.print("</table");
		out.print("<br/><br/>");
		
		
		out.print("<table width='100%' border='1'>");

		out.print("<tr><th>Class id</th><th>Classes</th></tr>");

		List<Classes> classDataList = dbo.AllClasses();

		for (Classes cls : classDataList) {
			out.print("<tr>");
			out.print("<td>" + cls.getCid() + "</td>");
			out.print("<td>" + cls.getCname() + "</td>");
			out.print("</tr>");
		}
		out.print("</table");
		out.print("<br/><br/>");
	
		out.print("</table");
		
		out.print("<table width='100%' border='1'>");
	
		out.print("<tr><th>Subject id</th><th>Subject name</th></tr>");
	
	
		List<Subjects> subjectDataList = dbo.AllSubjects();
	
		for (Subjects sub : subjectDataList) {
			out.print("<td>" + sub.getSubid() + "</td>");
			out.print("<td>" + sub.getSubname()+ "</td>");
			out.print("</tr>");
		}
		out.print("</table");
	}

}
