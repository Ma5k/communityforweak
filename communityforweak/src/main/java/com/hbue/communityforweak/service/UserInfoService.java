package com.hbue.communityforweak.service;

import com.hbue.communityforweak.entry.User;


public interface UserInfoService {
	
	public void save(User user);
	
	/**
	 * 密码验证 √
	 */
	public User getUser(String userid);
	
	/**
	 * 根据用户权限查找用户 √
	 */
	public Iterable<User> getTypeUser(String permission);
	
	/**
	 * 修改个人信息 √
	 */
	public void update(String userid, String username, String address, String tel);
	
	/**
	 * 申请更改用户类型 √
	 */
	public void appPermission(String userid, String idcard);
	
	/**
	 * 审批优待用户 √
	 */
	public Boolean updateUserPermission(String userid, String select);
	
	/**
	 * 每月免费积分发放 √
	 */
	public Boolean freeScorePreMonth(int addscore);
	
	/**
	 * 	用户参与活动 √
	 */
	public void partakeActive(String userid, String id, String tel);
	
	/**
	 * 	用户参与服务 √
	 */
	public void partakeServer(String userid, String id, String tel);
	
	/**
	 * 	活动签到
	 */
	public void updateUserFlag(String userid, int activityid, int score);
	
	/**
	 * 	发放积分
	 */
	public void addScore(String sessionUserid, String serverid, String userid, String score);
	
	/*
	 * 获取参与某活动的指定状态的用户
	 */
	public Iterable<User> getUserByActivityidAndFlag(int activityid, int flag);
}
