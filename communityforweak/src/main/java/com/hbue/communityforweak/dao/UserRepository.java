package com.hbue.communityforweak.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hbue.communityforweak.entry.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	Iterable<User> findByUsername(String username);
	
	User findByUserid(String userid);
	
	Iterable<User> findByAddress(String address);
	
	Iterable<User> findByPermission(Byte permission);
}
