package com.hbue.communityforweak.service;

import com.hbue.communityforweak.entry.Serving;

public interface ServingInfoService {
	public Serving findById(int id);
	public Iterable<Serving> getAllServings();
	public Iterable<Serving> findByClassify(String classify);
	public Iterable<Serving> findByServicename(String servicename);
	public Iterable<Serving> findByUserid(String userid);
	public Iterable<Serving> findByActive(int active);
	
	public Iterable<Serving> findBypage(int page, int size);
}
