package com.hbue.communityforweak.service;

import org.apache.coyote.http11.filters.VoidInputFilter;

import com.hbue.communityforweak.entry.Activity;
import com.hbue.communityforweak.entry.Activity_partake;
import com.hbue.communityforweak.entry.User;

public interface Activity_partakeService {
	public Iterable<Activity_partake> getAll();
	
	public Iterable<Activity_partake> findByUserid(String userid);
	
	public Iterable<Activity_partake> findByActivityid(int activityid);
	
	public Iterable<Activity_partake> findByFlage(Byte flage);
	
	public void Save(Activity_partake act_par);
	
	public Activity_partake findById(int id);
	
	//参与活动
	public void participateActvity(User user, Activity activity);
	
	//活动签到
	public void signIn(User user, Activity activity);
}
