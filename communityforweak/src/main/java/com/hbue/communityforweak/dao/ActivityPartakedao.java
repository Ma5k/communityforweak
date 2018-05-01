package com.hbue.communityforweak.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hbue.communityforweak.entry.Activitypartake;

public interface ActivityPartakedao extends JpaRepository<Activitypartake, Long>{
	
	@Query(value="select user.userid, user.username, activity_partake.activityid, activity_partake.flag "
			+ "from user JOIN activity_partake on user.userid = activity_partake.userid "
			+ "where activity_partake.activityid = ?1",nativeQuery=true)
	List<Object[]> getAllUser(String activityid);

	Activitypartake findByUseridAndActivityid(String userid, int activityid);

	
}
