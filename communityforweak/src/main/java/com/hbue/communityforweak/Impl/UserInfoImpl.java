package com.hbue.communityforweak.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hbue.communityforweak.dao.UserRepository;
import com.hbue.communityforweak.entry.User;
import com.hbue.communityforweak.service.UserInfoService;

@Service
public class UserInfoImpl implements UserInfoService {
	@Autowired
    private UserRepository userRepository;
	
	public Iterable<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public Iterable<User> findByUsername(String username) {
		System.out.println(username);
		return userRepository.findByUsername(username);
	}
	
	public User findByUserid(String userid) {
		return userRepository.findByUserid(userid);
	}
}
