package com.hbue.communityforweak.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hbue.communityforweak.entry.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Long>{
	Iterable<Activity> findByClassify(String classify);
}
