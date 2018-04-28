package com.hbue.communityforweak.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.hbue.communityforweak.entry.User;
import com.hbue.communityforweak.entry.pvo.ActivityUser;
import com.hbue.communityforweak.service.ActivityInfoService;
import com.hbue.communityforweak.service.ServerInfoService;
import com.hbue.communityforweak.service.UserInfoService;

@Controller
@RequestMapping(path = "/manager")
public class ManagerController {
	
	@Autowired
	private UserInfoService userInfoService;
	
	@Autowired
	private ActivityInfoService activityInfoService;
	
	@Autowired
	private ServerInfoService serverInfoService;
	
	@GetMapping("/findAppUser")
	@ResponseBody
	public String findAppUser() {
		JSONObject reObject = new JSONObject();
		try {
			Iterable<User> datas = userInfoService.getTypeUser("3");
			reObject.put("data", datas);
		} catch (Exception e) {
			reObject.put("error", "获取未审批用户列表失败");
		}
		return reObject.toString();
	}
	
	@GetMapping("/AppUser")
	@ResponseBody
	public String AppUser(@RequestParam String userid, @RequestParam String select) {
		JSONObject reObject = new JSONObject();
		try {
			Boolean result = userInfoService.updateUserPermission(userid, select);
			if (result == true) {
				reObject.put("data", "审批用户类型通过");
			}
			else {
				reObject.put("data", "拒绝审批");
			}
		} catch (Exception e) {
			reObject.put("error", "审批失败");
		}
		return reObject.toString();
	}
	
	@GetMapping("/freescore")
	@ResponseBody
	public String freescore() {
		JSONObject reObject = new JSONObject();
		try {
			Boolean result = userInfoService.freeScorePreMonth("20");
			if (result == true) {
				reObject.put("data", "积分发放成功");
			}
			else {
				reObject.put("error", "本月已发放");
			}
		} catch (Exception e) {
			reObject.put("error", "积分发放失败");
		}
		return reObject.toString();
	}
	
	@GetMapping("/activityAllUser")
	@ResponseBody
	public String activityAllUser(@RequestParam String id) {
		JSONObject reObject = new JSONObject();
		try {
			List<ActivityUser> datas = activityInfoService.getAllUser(id);
			reObject.put("data", datas);
		} catch (Exception e) {
			reObject.put("error", "获取参与者名单失败");
		}
		return reObject.toString();
	}
	
	@GetMapping("/attendance")
	@ResponseBody
	public String attendance(@RequestParam String userid, @RequestParam String activityid, @RequestParam String score) {
		JSONObject reObject = new JSONObject();
		try {
			userInfoService.updateUserFlag(userid, activityid, score);
			reObject.put("data", "签到成功");
		} catch (Exception e) {
			reObject.put("error", "签到失败");
		}
		return reObject.toString();
	}
	
	@GetMapping("/approval")
	@ResponseBody
	public String approval(@RequestParam String id, @RequestParam String select) {
		JSONObject reObject = new JSONObject();
		try {
			Boolean result = serverInfoService.approval(id, select);
			if (result == true) {
				reObject.put("data", "审批服务成功");
			}
			else {
				reObject.put("error", "审批不通过");
			}
		} catch (Exception e) {
			reObject.put("error", "审批服务失败");
		}
		return reObject.toString();
	}
}