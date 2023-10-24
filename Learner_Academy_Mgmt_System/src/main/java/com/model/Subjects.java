package com.model;

public class Subjects {
	private int subid;
	private String subname;
	
	public Subjects() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Subjects(int subid, String subname) {
		super();
		this.subid = subid;
		this.subname = subname;
	}

	public int getSubid() {
		return subid;
	}

	public void setSubid(int subid) {
		this.subid = subid;
	}

	public String getSubname() {
		return subname;
	}

	public void setSubname(String subname) {
		this.subname = subname;
	}

	@Override
	public String toString() {
		return "Subjects [subid=" + subid + ", subname=" + subname + "]";
	}

	
}
