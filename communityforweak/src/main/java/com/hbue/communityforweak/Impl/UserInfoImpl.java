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
	
	public void save(User user) {
		userRepository.save(user);
	}
	
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

	public Iterable<User> findByAddress(String address){
		return userRepository.findByAddress(address);
	}
	
	public void deleteByUserid(String userid) {
		User user = userRepository.findByUserid(userid);
		userRepository.delete(user);
	}

	public Iterable<User> findByPermission(Byte permission) {
		return userRepository.findByPermission(permission);
	}
	
	public User findByIdcard(String idcard) {
		return userRepository.findByIdcard(idcard);
	}

}
