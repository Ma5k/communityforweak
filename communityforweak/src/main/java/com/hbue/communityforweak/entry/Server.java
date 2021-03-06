package com.hbue.communityforweak.entry;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Server implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	//服务发起者id
	private String userid;
	
	private String tel;
	
	private String servername;
	
	private String ineed;
	
	private Date startime;
	
	private Date endtime;
	
	private Integer active;
	
	private Integer scoreadd;
	
	private String classify;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getServname() {
		return servername;
	}

	public void setServername(String servername) {
		this.servername = servername;
	}

	public String getIneed() {
		return ineed;
	}

	public void setIneed(String ineed) {
		this.ineed = ineed;
	}

	public Date getStartime() {
		return startime;
	}

	public void setStartime(Date startime) {
		this.startime = startime;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public Integer getScoreadd() {
		return scoreadd;
	}

	public void setScoreadd(Integer scoreadd) {
		this.scoreadd = scoreadd;
	}

	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
