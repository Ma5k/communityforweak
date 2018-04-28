package com.hbue.communityforweak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.hbue.communityforweak.entry.Activity;
import com.hbue.communityforweak.service.ActivityInfoService;

@Controller
@RequestMapping(path="/activity")
public class ActivityController {
	
	@Autowired
	private ActivityInfoService activityInfoService;
	
	/**
	 * data 是进行中的活动(置顶)
	 * data2 是策划中的活动
	 * @return
	 */
	@GetMapping("/getActivityList")
	@ResponseBody
	public String getActivityList() {
		JSONObject reObject = new JSONObject();
		try {
			Iterable<Activity> dataNodes = activityInfoService.getActiveList(1);
			Iterable<Activity> dataNodes2 = activityInfoService.getActiveList(0); 
			reObject.put("data", dataNodes);
			reObject.put("data2", dataNodes2);
		}
		catch (Exception e) {
			reObject.put("error", "获取活动列表失败");
		}
		return reObject.toString();
	}
	
	@GetMapping("/findActivityList")
	@ResponseBody
	public String findActivityList(@RequestParam String classify) {
		JSONObject reObject = new JSONObject();
		try {
			Iterable<Activity> dataNodes = activityInfoService.findActiveList(classify);
			reObject.put("data", dataNodes);
		} catch (Exception e) {
			reObject.put("error", "筛选活动列表失败");
		}
		return reObject.toString();
	}
	
	@GetMapping("/getActivingList")
	@ResponseBody
	public String getActivingList() {
		JSONObject reObject = new JSONObject();
		try {
			Iterable<Activity> dataNodes = activityInfoService.getActiveList(1);
			reObject.put("data", dataNodes);
		}
		catch (Exception e) {
			reObject.put("error", "获取进行中的活动列表失败");
		}
		return reObject.toString();
	}
	

	@GetMapping("/userActivityList")
	@ResponseBody
	public String userActivityList(@RequestParam String userid) {
		JSONObject reObject = new JSONObject();
		try {
			Iterable<Activity> dataNodes = activityInfoService.userActivityList(userid);
			reObject.put("data", dataNodes);
		}
		catch (Exception e) {
			reObject.put("error", "获取参加活动列表失败");
		}
		return reObject.toString();
	}
	
	@GetMapping("/activityComment")
	@ResponseBody
	public String activityComment(@RequestParam String userid, @RequestParam String activityid, @RequestParam String comment) {
		JSONObject reObject = new JSONObject();
		try {
			activityInfoService.comment(userid, activityid, comment);
			reObject.put("data", "评论成功");
		}
		catch (Exception e) {
			reObject.put("error", "获取参加活动列表失败");
		}
		return reObject.toString();
	}
}
