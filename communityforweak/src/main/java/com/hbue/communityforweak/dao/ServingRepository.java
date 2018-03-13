package com.hbue.communityforweak.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hbue.communityforweak.entry.Serving;

public interface ServingRepository extends JpaRepository<Serving, Long> {
	Iterable<Serving> findByClassify(String classify);
	
	Iterable<Serving> findByServicename(String servicename);
	
	Serving findById(int id);
	
	Iterable<Serving> findByUserid(String userid);
	
	Iterable<Serving> findByActive(int active);
}
