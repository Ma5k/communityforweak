package com.hbue.communityforweak.service;

import java.util.ArrayList;

import org.springframework.data.domain.Page;

import com.hbue.communityforweak.entry.Activity;
import com.hbue.communityforweak.entry.Server;
import com.hbue.communityforweak.entry.User;
import com.hbue.communityforweak.entry.pvo.ServerUser;

public interface ServerInfoService {
	
	public void save(Server serving);
	
	/**
	 *	服务列表 √
	 */
	public Iterable<Server> getServerList(int active);
	
	/**
	 * 	筛选的服务列表 √
	 */
	public Iterable<Server> findServerList(String classify);
	
	/**
	 *  申请服务√
	 */
	public boolean appServer(String userid, Server server);
	
	/**
	 * 	某用户参加过的服务
	 */
	public Iterable<Server> userServerList(String userid);
	
	/**
	 * 	用户发起过的服务√
	 */
	public Iterable<Server> getUserServer(String userid);
	
	/**
	 * 	审批服务√
	 */
	public Boolean approval(String id, String select);
	
	/**
	 * 	查看某服务所有参与用户
	 */
	public ArrayList<ServerUser> getServerUserList(String serverid);

	
	/**
	 * 分页
	 */
	public Page<Server> findBypage(final int active, int page, int size);
	
	/**
	 * 带条件分页查询
	 */
	public Page<Server> findPageByClassify(final int active, final String classify, int page, int size);
	
	/**
	 * 获取用户发起的进行中的服务
	 */
	public Iterable<Server> findUserRunningServer(String userid);
	
	/**
	 * 获取某一个服务
	 */
	public Server getOne(String serverid);
	
	/**
	 * 判断用户是否已报名该服务
	 */
	public Boolean alreadyPartakeSer(String userid, int serverid);
	
	
	/**
	 * 查询某服务下处于某转状态的所有用户
	 */
	public Iterable<User> getUserByServeridAndFlag(int serverid, int flag);
}
