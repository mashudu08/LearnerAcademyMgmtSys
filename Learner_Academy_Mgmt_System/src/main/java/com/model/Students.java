package com.model;

public class Students {
	
	private int stdId;
	private String stdname;
	
	public Students() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Students(int stdId, String stdname) {
		super();
		this.stdId = stdId;
		this.stdname = stdname;
	}

	public int getStdId() {
		return stdId;
	}

	public void setStdId(int stdId) {
		this.stdId = stdId;
	}

	public String getStdname() {
		return stdname;
	}

	public void setStdname(String stdname) {
		this.stdname = stdname;
	}

	@Override
	public String toString() {
		return "Students [stdId=" + stdId + ", stdname=" + stdname + "]";
	}
	
	
}
