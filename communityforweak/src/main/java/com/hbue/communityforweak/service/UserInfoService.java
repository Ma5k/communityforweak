package com.hbue.communityforweak.service;

import com.hbue.communityforweak.entry.User;


public interface UserInfoService {
	public void save(User user);
	public Iterable<User> getAllUsers();
	public Iterable<User> findByUsername(String username);
	public User findByUserid(String userid);
	public Iterable<User> findByAddress(String address);
	public void deleteByUserid(String userid);
	public Iterable<User> findByPermission(Byte permission);
	public User findByIdcard(String idcard);
}
