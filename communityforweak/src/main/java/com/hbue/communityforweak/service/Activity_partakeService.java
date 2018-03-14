package com.hbue.communityforweak.service;

import com.hbue.communityforweak.entry.Activity_partake;

public interface Activity_partakeService {
	public Iterable<Activity_partake> getAll();
	
	public Iterable<Activity_partake> findByUserid(String userid);
	
	public Iterable<Activity_partake> findByActivityid(int activityid);
	
	public Iterable<Activity_partake> findByFlage(Byte flage);
	
	public void Save(Activity_partake act_par);
	
	public Activity_partake findById(int id);
}
