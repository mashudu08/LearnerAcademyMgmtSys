package com.model;

public class AdminDetails {
	private int adminId;
	private String adminUser;
	private String adminPwd;
	
	public AdminDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminDetails(int adminId, String adminUser, String adminPwd) {
		super();
		this.adminId = adminId;
		this.adminUser = adminUser;
		this.adminPwd = adminPwd;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminUser() {
		return adminUser;
	}

	public void setAdminUser(String adminUser) {
		this.adminUser = adminUser;
	}

	public String getAdminPwd() {
		return adminPwd;
	}

	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}
	
	
}
