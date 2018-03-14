package com.hbue.communityforweak.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

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

	public Iterable<Serving> findByServicename(String servicename) {
		return serviceRepository.findByServicename(servicename);
	}

	public Serving findById(int id) {
		return serviceRepository.findById(id);
	}

	public Iterable<Serving> findByUserid(String userid) {
		return serviceRepository.findByUserid(userid);
	}

	public Iterable<Serving> findByActive(int active) {
		return serviceRepository.findByActive(active);
	}

	public Iterable<Serving> findBypage(int page, int size) {
		Order order1 = new Order(Direction.DESC, "startime");  
		Order order2 = new Order(Direction.ASC, "scoreadd");  
		Sort sort = new Sort(order1, order2);
		
		PageRequest pageable = new PageRequest(page, size, sort);
		Page<Serving> pageSer = serviceRepository.findAll(pageable);
		Iterable<Serving> servings = pageSer.getContent();
		return servings;
	}
}
