package com.hbue.communityforweak.service;

import java.util.List;

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
	public void comment(String userid, String activityid, String comment);
}
