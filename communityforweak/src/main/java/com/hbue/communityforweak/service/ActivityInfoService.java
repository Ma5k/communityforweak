package com.hbue.communityforweak.service;

import com.hbue.communityforweak.entry.Activity;

public interface ActivityInfoService {
	public Iterable<Activity> getAllActivitys();
	public Iterable<Activity> findByClassify(String classify);
}
