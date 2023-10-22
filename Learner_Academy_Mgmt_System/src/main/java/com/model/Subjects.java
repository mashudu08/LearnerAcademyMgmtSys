package com.model;

public class Subjects {
	private int subjectId;
	private String subjectname;
	
	public Subjects() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Subjects(int subjectId, String subjectname) {
		super();
		this.subjectId = subjectId;
		this.subjectname = subjectname;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectname() {
		return subjectname;
	}

	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}

	@Override
	public String toString() {
		return "Subjects [subjectId=" + subjectId + ", subjectname=" + subjectname + "]";
	}
	
}
