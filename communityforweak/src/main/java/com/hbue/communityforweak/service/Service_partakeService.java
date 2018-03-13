package com.hbue.communityforweak.service;

import com.hbue.communityforweak.entry.Service_partake;

public interface Service_partakeService {
	public Iterable<Service_partake> findByUserid(String userid);
	public Iterable<Service_partake> getAll();
}