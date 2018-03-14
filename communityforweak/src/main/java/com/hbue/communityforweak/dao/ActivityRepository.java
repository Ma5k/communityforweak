package com.hbue.communityforweak.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hbue.communityforweak.entry.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Long>{
	Iterable<Activity> findByClassify(String classify);
	Activity findById(int id);
	Iterable<Activity> findByActivityname(String activityname);
	Iterable<Activity> findByActive(Byte active);
	
	//查找某用户参与的所有活动
	@Query(value="select * from activity where activity.id in \r\n" + 
			"(select activityid from activity_partake where userid = ?1)",nativeQuery=true)
	Iterable<Activity> findByUseid(String userid);
}
