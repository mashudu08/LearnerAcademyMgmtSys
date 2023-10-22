package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Admin;
import com.service.DbOperations;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name= request.getParameter("txtAname");
		String pwd = request.getParameter("txtPwd");
		HttpSession session = request.getSession();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		DbOperations dbo = new DbOperations();
		Admin ad = dbo.AdminLogin(name, pwd);
		
		if(name.equalsIgnoreCase(ad.getAdminUser()) && pwd.equals(ad.getAdminPwd())) {
			session.setAttribute("user", "Administrator");
			response.sendRedirect("Dashboard");
		}
		else {
			out.println("<p style='text-align:center;'>Error, please check your username/password</p>");
			RequestDispatcher rd = request.getRequestDispatcher("Login.html");
			rd.include(request, response);
			
		}
	}

}
