package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dbconn.DbConnection;
import com.model.Admin;
import com.model.Students;

public class DbOperations {
	
	private Connection conObj = null;
	
	public DbOperations() {
		conObj = DbConnection.getConnection();
	}
	
	public Admin AdminLogin(String adminUser, String adminPwd)
	{
		Admin admin = null;
		
		try {
			PreparedStatement ps = conObj.prepareStatement("SELECT * FROM Admin_Details WHERE adminUser = ? AND adminPwd = ?");
			
			ps.setString(1, adminUser);
			ps.setString(2, adminPwd);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				admin = new Admin();
				admin.setAdminId(rs.getInt("adminId"));
				admin.setAdminUser(rs.getString("adminUser"));
				admin.setAdminPwd(rs.getString("adminPwd"));
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return admin;
	}
	
	public String AddNewStudent(Students std){
		String res = "Error";
		try {
			String incmd = "INSERT INTO Students";
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return res;
		
		
	}
	
}
