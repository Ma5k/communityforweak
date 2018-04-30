package com.hbue.communityforweak.service;

import java.util.List;

import org.codehaus.groovy.util.Finalizable;
import org.springframework.data.domain.Page;

import com.hbue.communityforweak.entry.Activity;
import com.hbue.communityforweak.entry.pvo.ActivityUser;

public interface ActivityInfoService {
	
	public void save(Activity activity);

	/**
	 *	活动列表 √
	 */
	public Iterable<Activity> getActiveList(int active);
	
	/**
	 * 	筛选的活动列表 √
	 */
	public Iterable<Activity> findActiveList(String classify);

	/**
	 *  某活动所有参加人员 √
	 */
	public List<ActivityUser> getAllUser(String id);

	/**
	 * 	某用户参加的活动
	 */
	public Iterable<Activity> userActivityList(String userid);

	/**
	 *  活动评论
	 */
	public void comment(String userid, int activityid, String comment);
	
	/**
	 * 分页
	 */
	public Page<Activity> findBypage(final int active, int page, int size) ;
	
	/**
	 * 查找某个活动
	 */
	public Activity findOne(int activityid);
	
	/**
	 * 带条件的分页查询
	 */
	public Page<Activity> findPageByClassify(final int active, final String classify, int page, int size);
	
	/**
	 * 判断用户是否已参加活动
	 */
	public Boolean alreadyPartakeAct(String userid, int activityid);
	
}
