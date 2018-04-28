package com.hbue.communityforweak.dao;

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
	@Query(value="update user set score = score + ?1 where permission = 2", nativeQuery=true)
	void updatefreeScorePreMonth(int addscore);
}
