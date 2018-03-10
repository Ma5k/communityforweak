package com.hbue.communityforweak.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hbue.communityforweak.entry.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	Iterable<User> findByUsername(String username);
	
	User findByUserid(Integer userid);
}
