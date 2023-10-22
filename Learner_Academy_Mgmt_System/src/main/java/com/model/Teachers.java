package com.model;

public class Teachers {
	private int teacherId;
	private String teachername;
	
	public Teachers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Teachers(int teacherId, String teachername) {
		super();
		this.teacherId = teacherId;
		this.teachername = teachername;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeachername() {
		return teachername;
	}

	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}

	@Override
	public String toString() {
		return "Teachers [teacherId=" + teacherId + ", teachername=" + teachername + "]";
	}
	
}
