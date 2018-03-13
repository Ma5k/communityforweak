package com.hbue.communityforweak.entry;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Activity_partake implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private int userid;
	
	private int activityid;
	
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getActivityid() {
		return activityid;
	}

	public void setActivityid(int activityid) {
		this.activityid = activityid;
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
