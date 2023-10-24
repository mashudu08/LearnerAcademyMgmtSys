package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dbconn.DbConnection;
import com.model.AdminDetails;
import com.model.Classes;
import com.model.Students;
import com.model.Subjects;
import com.model.Teachers;

public class DbOperations {

	private Connection conObj;

	public DbOperations() {
		conObj = DbConnection.getConnection();
	}

	public AdminDetails AdminLogin(String adminUser, String adminPwd) {
		AdminDetails admin = null;

		try {
			PreparedStatement ps = conObj
					.prepareStatement("SELECT * FROM Admin_Details WHERE adminUser = ? AND adminPwd = ?");

			ps.setString(1, adminUser);
			ps.setString(2, adminPwd);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				admin = new AdminDetails();
				admin.setAdminId(rs.getInt("adminId"));
				admin.setAdminUser(rs.getString("adminUser"));
				admin.setAdminPwd(rs.getString("adminPwd"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return admin;
	}

	// Add Teacher
	public String AddTeacher(String tname, int cid) {

		String res = "Error";
		try {
			String inscmd = ("INSERT INTO Teacher (tname, cid) VALUE (?,?)");
			PreparedStatement ps = conObj.prepareStatement(inscmd);
			ps.setString(1, tname);
			ps.setInt(2, cid);

			int r = ps.executeUpdate();

			if (r >= 1) {
				res = "success";
			}
		} catch (Exception ex) {
			res = ex.getMessage();
			ex.printStackTrace();
		}
		return res;
	}

	// All Teachers
	public List<Teachers> AllTeachers() {

		List<Teachers> ateach = new ArrayList();

		Teachers t = null;

		try {
			PreparedStatement ps = conObj.prepareStatement("SELECT * FROM teachers");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				t = new Teachers();
				t.setTid(rs.getInt("tid"));
				t.setTname(rs.getString("tname"));
				t.setCid(rs.getInt("cid"));

				ateach.add(t);

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return ateach;

	}

	// Add Subject
	public String AddSubjects(String subName) {

		String res = "Error";
		try {
			String inscmd = ("INSERT INTO Subjects (subname) VALUE (?)");
			PreparedStatement ps = conObj.prepareStatement(inscmd);
			ps.setString(1, subName);

			int r = ps.executeUpdate();

			if (r >= 1) {
				res = "success";
			}
		} catch (Exception ex) {
			res = ex.getMessage();
			ex.printStackTrace();
		}
		return res;
	}

	// Get Subject
	public List<Subjects> AllSubjects() {

		List<Subjects> asub = new ArrayList();

		Subjects sub = null;

		try {
			PreparedStatement ps = conObj.prepareStatement("SELECT * FROM subjects");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				sub = new Subjects();
				sub.setSubid(rs.getInt("subid"));
				sub.setSubname(rs.getString("subname"));

				asub.add(sub);

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return asub;

	}

	// Add Class
	public String AddClasses(String cname, int subid) {

		String res = "Error";
		try {
			String inscmd = ("INSERT INTO Classes(cname, subid) VALUE (?,?)");
			PreparedStatement ps = conObj.prepareStatement(inscmd);
			ps.setString(1, cname);
			ps.setInt(2, subid);

			int r = ps.executeUpdate();

			if (r >= 1) {
				res = "success";
			}
		} catch (Exception ex) {
			res = ex.getMessage();
			ex.printStackTrace();
		}
		return res;
	}

	// Get Classes
	public List<Classes> AllClasses() {

		List<Classes> cll = new ArrayList();

		Classes c = null;

		try {
			PreparedStatement ps = conObj.prepareStatement("SELECT * FROM classes");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				c = new Classes();
				c.setCid(rs.getInt("cid"));
				c.setCname(rs.getString("cname"));

				cll.add(c);

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return cll;

	}

	public String AddStudent(String stdname, int cid) {

		String res = "Error";
		try {
			String inscmd = ("INSERT INTO Students (stdname, cid) VALUE (?, ?)");
			PreparedStatement ps = conObj.prepareStatement(inscmd);
			ps.setString(1, stdname);
			ps.setInt(2, cid);

			int r = ps.executeUpdate();

			if (r >= 1) {
				res = "success";
			}
		} catch (Exception ex) {
			res = ex.getMessage();
			ex.printStackTrace();
		}
		return res;
	}

	public List<Students> AllStudents() {
		
		List<Students> astd = new ArrayList();

		Students std = null;

		try {
			PreparedStatement ps = conObj.prepareStatement("SELECT * FROM students");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				std = new Students();
				std.setStdid(rs.getInt("stdid"));
				std.setStdname(rs.getString("stdname"));
				std.setCid(rs.getInt("cid"));

				astd.add(std);

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return astd;


	}

}
