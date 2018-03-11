package com.hbue.communityforweak.service;

import com.hbue.communityforweak.entry.Serving;

public interface ServingInfoService {
	public Iterable<Serving> getAllServings();
	public Iterable<Serving> findByClassify(String classify);
}
