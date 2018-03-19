package com.hbue.communityforweak.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hbue.communityforweak.dao.Service_partakeRepository;
import com.hbue.communityforweak.entry.Service_partake;
import com.hbue.communityforweak.entry.Serving;
import com.hbue.communityforweak.entry.User;
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

	public Service_partake findById(int id) {
		return s_pRepository.findById(id);
	}

	public Iterable<Service_partake> findByServiceid(int serviceid) {
		return s_pRepository.findByServiceid(serviceid);
	}

	public Iterable<Service_partake> findByFlag(Byte flag) {
		return s_pRepository.findByFlag(flag);
	}

	public void Save(Service_partake ser_par) {
		s_pRepository.save(ser_par);
	}

	//接受服务请求
	public void acceptServing(User user, Serving serving) {
		Service_partake service_partake = new Service_partake();
		service_partake.setServiceid(serving.getId());
		service_partake.setUserid(user.getUserid());
		service_partake.setTel(user.getTel());
		s_pRepository.save(service_partake);
	}
}
