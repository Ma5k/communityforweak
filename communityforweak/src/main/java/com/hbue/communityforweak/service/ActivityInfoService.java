package com.hbue.communityforweak.service;

import com.hbue.communityforweak.entry.Activity;

public interface ActivityInfoService {
	public Iterable<Activity> getAllActivitys();
	public Iterable<Activity> findByClassify(String classify);
	public Activity findById(int id);
	public Iterable<Activity> findByActivityname(String activityname);
	public Iterable<Activity> findByActive(Byte active);
}
