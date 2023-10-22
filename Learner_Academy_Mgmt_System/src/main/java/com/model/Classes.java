package com.model;

public class Classes {
	private int classId;
	private String classname;
	
	public Classes() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Classes(int classId, String classname) {
		super();
		this.classId = classId;
		this.classname = classname;
	}
	
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	
	@Override
	public String toString() {
		return "Classes [classId=" + classId + ", classname=" + classname + "]";
	}
	
	
}
