package com.leopard.mvc;

public class Member {
	private String uid;
	private String upw;
	private String uname;
	private String upic;
	
	@Override
	public String toString() {
		return "Member [uid=" + uid + ", upw=" + upw + ", uname=" + uname + ", upic=" + upic + "]";
	}
	
	// getters & setters
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUpw() {
		return upw;
	}
	public void setUpw(String upw) {
		this.upw = upw;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpic() {
		return upic;
	}
	public void setUpic(String upic) {
		this.upic = upic;
	}
}
