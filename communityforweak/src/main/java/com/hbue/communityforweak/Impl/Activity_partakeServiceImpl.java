package com.hbue.communityforweak.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hbue.communityforweak.dao.Activity_partakeRepository;
import com.hbue.communityforweak.entry.Activity;
import com.hbue.communityforweak.entry.Activity_partake;
import com.hbue.communityforweak.entry.User;
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

	public void Save(Activity_partake act_par) {
		activity_partakeRepository.save(act_par);
	}

	public Activity_partake findById(int id) {
		return activity_partakeRepository.findById(id);
	}

	//报名参与活动
	public void participateActvity(User user, Activity activity) {
		Activity_partake activity_partake = new Activity_partake();
		activity_partake.setUserid(user.getUserid());
		activity_partake.setActivityid(activity.getId());
		activity_partakeRepository.save(activity_partake);
	}

	//活动签到
	public void signIn(User user, Activity activity) {
		Activity_partake activity_partake = activity_partakeRepository.findByUseridAndActivityid(user.getUserid(), activity.getId());
		activity_partake.setFlage((byte) 1);
		activity_partakeRepository.save(activity_partake);
	}
}
