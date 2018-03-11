package com.hbue.communityforweak.Impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.hbue.communityforweak.dao.ServingRepository;
import com.hbue.communityforweak.entry.Serving;
import org.springframework.stereotype.Service;

import com.hbue.communityforweak.service.ServingInfoService;

@Service
public class ServingInfoImpl implements ServingInfoService{
	@Autowired
	private ServingRepository serviceRepository;
	
	public Iterable<Serving> getAllServings(){
		return serviceRepository.findAll();
	}
	
	public Iterable<Serving> findByClassify(String classify){
		return serviceRepository.findByClassify(classify);
	}
}
