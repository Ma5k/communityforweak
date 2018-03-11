package com.hbue.communityforweak.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hbue.communityforweak.dao.ActivityRepository;
import com.hbue.communityforweak.entry.Activity;
import com.hbue.communityforweak.service.ActivityInfoService;

@Service
public class ActivityInfoImpl implements ActivityInfoService {
	@Autowired
	private ActivityRepository activityRepository;
	
	public Iterable<Activity> getAllActivitys() {
		return activityRepository.findAll();
	}
	
	public Iterable<Activity> findByClassify(String classify){
		return activityRepository.findByClassify(classify);
	}
}
