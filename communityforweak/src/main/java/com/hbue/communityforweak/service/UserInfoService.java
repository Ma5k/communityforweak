package com.hbue.communityforweak.service;

import com.hbue.communityforweak.entry.User;


public interface UserInfoService {
	public Iterable<User> getAllUsers();
	public Iterable<User> findByUsername(String username);
	public User findByUserid(String userid);
}
