package com.model;

public class Classes {
	private int cid;
	private String cname;
	private int subid;
	
	public Classes() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Classes(int cid, String cname, int subid) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.subid = subid;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}
	
	public int getSubid() {
		return subid;
	}

	public void setSubid(int subid) {
		this.subid = subid;
	}

	@Override
	public String toString() {
		return "Classes [cid=" + cid + ", cname=" + cname + ", subid=" + subid + "]";
	}

	
}
