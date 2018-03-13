package com.hbue.communityforweak.entry;

import java.io.Serializable;

public class Activity_partake implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int userid;
	
	private int activityname;
	
	private byte flage;
	
	private String comment;
	
	private int num;
	
	private String tel;

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getActivityname() {
		return activityname;
	}

	public void setActivityname(int activityname) {
		this.activityname = activityname;
	}

	public byte getFlage() {
		return flage;
	}

	public void setFlage(byte flage) {
		this.flage = flage;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
