package com.hbue.communityforweak.service;

import com.hbue.communityforweak.entry.Activity_partake;

public interface Activity_partakeService {
	public Iterable<Activity_partake> getAll();
	
	public Iterable<Activity_partake> findByUserid(String userid);
}
