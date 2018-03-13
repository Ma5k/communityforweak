package com.hbue.communityforweak.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hbue.communityforweak.dao.Activity_partakeRepository;
import com.hbue.communityforweak.entry.Activity_partake;
import com.hbue.communityforweak.service.Activity_partakeService;

@Service
public class Activity_partakeServiceImpl implements Activity_partakeService {
	@Autowired
	private Activity_partakeRepository a_pRepository;
	
	public Iterable<Activity_partake> getAll(){
		return a_pRepository.findAll();
	}
	
	public Iterable<Activity_partake> findByUserid(String userid){
		return a_pRepository.findByUserid(userid);
	}
}
