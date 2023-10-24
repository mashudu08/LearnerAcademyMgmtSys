package com.dbconn;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
public static Connection getConnection() {
		
		Connection con = null;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/learners_academy";
			String uname = "root";
			String pwd= "Jason1997";
			con = DriverManager.getConnection(url,uname,pwd);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return con;
	}
}
