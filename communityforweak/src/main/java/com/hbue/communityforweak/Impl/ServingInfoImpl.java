package com.hbue.communityforweak.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

import com.hbue.communityforweak.dao.Service_partakeRepository;
import com.hbue.communityforweak.dao.ServingRepository;
import com.hbue.communityforweak.dao.UserRepository;
import com.hbue.communityforweak.entry.Service_partake;
import com.hbue.communityforweak.entry.Serving;
import com.hbue.communityforweak.entry.User;

import org.springframework.stereotype.Service;

import com.hbue.communityforweak.service.Service_partakeService;
import com.hbue.communityforweak.service.ServingInfoService;

@Service
public class ServingInfoImpl implements ServingInfoService{
	@Autowired
	private ServingRepository serviceRepository;
	
	@Autowired 
	private UserRepository userRepository;
	
	@Autowired
	private Service_partakeRepository ser_par;
	
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

	public Page<Serving> findBypage(int page, int size) {
		Order order1 = new Order(Direction.DESC, "startime");  
		Order order2 = new Order(Direction.DESC, "scoreadd");  
		Sort sort = new Sort(order1, order2);
		
		PageRequest pageable = new PageRequest(page, size, sort);
		Page<Serving> pageSer = serviceRepository.findAll(pageable);
		return pageSer;
	}

	public Iterable<Serving> findByParticipantid(String parid) {
		return serviceRepository.findByParticipantid(parid);
	}

	//服务结束后结算
	public void settlement(int score, Serving serving) {
		serving.setActive(2);
		Iterable<User> users = userRepository.findByServiceid(serving.getId());
		for (User user : users) {
			user.setScore(score + user.getScore());
		}
		Iterable<Service_partake> s_partake = ser_par.findByServiceid(serving.getId());
		for(Service_partake service_partake:s_partake) {
			service_partake.setFlag((byte) 1);
		}
		userRepository.save(users);
		ser_par.save(s_partake);
		serviceRepository.save(serving);
	}

	//发起服务请求
	public void startServing(Serving serving) {
		serviceRepository.save(serving);
	}
}
