package com.model;

import java.util.List;

public class Students {
	
	private int stdid;
	private String stdname;
	private int cid;
	
	public Students() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Students(int stdid, String stdname, int cid) {
		super();
		this.stdid = stdid;
		this.stdname = stdname;
		this.cid = cid;
	}

	public int getStdid() {
		return stdid;
	}

	public void setStdid(int stdid) {
		this.stdid = stdid;
	}

	public String getStdname() {
		return stdname;
	}

	public void setStdname(String stdname) {
		this.stdname = stdname;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	@Override
	public String toString() {
		return "Students [stdid=" + stdid + ", stdname=" + stdname + ", cid=" + cid + "]";
	}

	
}
