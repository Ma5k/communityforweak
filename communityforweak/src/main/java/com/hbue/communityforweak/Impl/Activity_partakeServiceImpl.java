package com.hbue.communityforweak.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hbue.communityforweak.dao.Activity_partakeRepository;
import com.hbue.communityforweak.entry.Activity_partake;
import com.hbue.communityforweak.service.Activity_partakeService;

@Service
public class Activity_partakeServiceImpl implements Activity_partakeService {
	@Autowired
	private Activity_partakeRepository activity_partakeRepository;
	
	public Iterable<Activity_partake> getAll(){
		return activity_partakeRepository.findAll();
	}
	
	public Iterable<Activity_partake> findByUserid(String userid){
		return activity_partakeRepository.findByUserid(userid);
	}
	
	public Iterable<Activity_partake> findByActivityid(int activityid){
		return activity_partakeRepository.findByActivityid(activityid);
	}

	public Iterable<Activity_partake> findByFlage(Byte flage) {
		return activity_partakeRepository.findByFlage(flage);
	}
}
