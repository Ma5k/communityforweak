package com.hbue.communityforweak.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hbue.communityforweak.entry.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Long>{
	Iterable<Activity> findByClassify(String classify);
	Activity findById(int id);
	Iterable<Activity> findByActivityname(String activityname);
	Iterable<Activity> findByActive(Byte active);
}
