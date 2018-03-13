package com.hbue.communityforweak.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hbue.communityforweak.dao.Service_partakeRepository;
import com.hbue.communityforweak.entry.Service_partake;
import com.hbue.communityforweak.service.Service_partakeService;

@Service
public class Service_partakeServiceImpl implements Service_partakeService{
	@Autowired
	private Service_partakeRepository s_pRepository;
	
	public Iterable<Service_partake> getAll(){
		return s_pRepository.findAll();
	}
	
	public Iterable<Service_partake> findByUserid(String userid){
		return s_pRepository.findByUserid(userid);
	}
}
