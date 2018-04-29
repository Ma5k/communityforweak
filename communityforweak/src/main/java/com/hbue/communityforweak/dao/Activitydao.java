package com.hbue.communityforweak.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.hbue.communityforweak.entry.Activity;

public interface Activitydao extends JpaRepository<Activity, Long>,JpaSpecificationExecutor<Activity>{
	
	// 查找所有开启的活动 √
	Iterable<Activity> findByActive(int active);
	
	// 筛选所有开启的活动 √
	Iterable<Activity> findByClassifyAndActive(String classify, int active);
	
	// 查找某用户参与的所有活动 √
	@Query(value="select * from activity where activity.id in (select activityid from activity_partake where userid = ?1 and flag = 1)",nativeQuery=true)
	Iterable<Activity> getUserActivitylist(String userid);

	//查找某个活动
	Activity findById(int id);
}
	