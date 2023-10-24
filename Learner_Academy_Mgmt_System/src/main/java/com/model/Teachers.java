package com.model;

public class Teachers {
	private int tid;
	private String tname;
	private int cid;
	
	public Teachers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Teachers(int tid, String tname, int cid) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.cid = cid;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	@Override
	public String toString() {
		return "Teachers [tid=" + tid + ", tname=" + tname + ", cid=" + cid + "]";
	}

	

	

}
