package com.hbue.communityforweak.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.hbue.communityforweak.entry.User;

public interface Userdao extends JpaRepository<User, Long> {

	User findByUserid(String userid);

	Iterable<User> findByPermission(int permission);

	@Modifying
	@Transactional
	@Query(value = "update user set score = score + ?1 where permission = 2", nativeQuery = true)
	void updatefreeScorePreMonth(int addscore);

	// 查询某一活动下，处于某一状态的所有用户
	@Query(value = " select * from user where user.userid in (select userid from activity_partake where activityid = ?1 and flag = ?2)", nativeQuery = true)
	Iterable<User> getUserByActivityidAndFlag(int activityid, int flag);
	
	// 查询某一服务下，处于某一状态的所有用户
	@Query(value = " select * from user where user.userid in (select userid from server_partake where serverid = ?1 and flag = ?2)", nativeQuery = true)
	Iterable<User> getUserByServeridAndFlag(int serverid, int flag);
}
