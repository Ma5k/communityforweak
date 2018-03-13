package com.hbue.communityforweak.service;

import com.hbue.communityforweak.entry.Service_partake;
import com.hbue.communityforweak.entry.Serving;

public interface Service_partakeService {
	public Iterable<Service_partake> findByUserid(String userid);
	public Iterable<Service_partake> getAll();
	public Service_partake findById(int id);
	public Iterable<Service_partake> findByServiceid(int serviceid);
	public Iterable<Service_partake> findByFlag(Byte flag);
}