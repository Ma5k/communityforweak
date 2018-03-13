package com.hbue.communityforweak.entry;

import java.io.Serializable;

public class Service_partake implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String userid;
	
	private int servicename;
	
	private byte flag;
	
	private String tel;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public int getServicename() {
		return servicename;
	}

	public void setServicename(int servicename) {
		this.servicename = servicename;
	}

	public byte getFlag() {
		return flag;
	}

	public void setFlag(byte flag) {
		this.flag = flag;
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
