package com.hbue.communityforweak.service;

import org.springframework.data.domain.Page;

import com.hbue.communityforweak.entry.Activity;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

public interface ActivityInfoService {
	public Iterable<Activity> getAllActivitys();
	public Iterable<Activity> findByClassify(String classify);
	public Activity findById(int id);
	public Iterable<Activity> findByActivityname(String activityname);
	public Iterable<Activity> findByActive(Byte active);
	
	public Iterable<Activity> findByUseid(String userid);
	
	public Page<Activity> findBypage(int page, int size);
}
