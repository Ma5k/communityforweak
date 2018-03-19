package com.hbue.communityforweak.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
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

	public Activity findById(int id) {
		return activityRepository.findById(id);
	}

	public Iterable<Activity> findByActivityname(String activityname) {
		return activityRepository.findByActivityname(activityname);
	}

	public Iterable<Activity> findByActive(Byte active) {
		return activityRepository.findByActive(active);
	}

	public Iterable<Activity> findByUseid(String userid) {
		return activityRepository.findByUseid(userid);
	}

	public Page<Activity> findBypage(int page, int size) {
		Order order1 = new Order(Direction.DESC, "startime");  
		Order order2 = new Order(Direction.DESC, "scoreadd");  
		Sort sort = new Sort(order1, order2);
		
		PageRequest pageable = new PageRequest(page, size, sort);
		Page<Activity> pageAct = activityRepository.findAll(pageable);
		return pageAct;
	}

	//发起活动
	public void startActivity(Activity activity) {
		activityRepository.save(activity);
	}
}
