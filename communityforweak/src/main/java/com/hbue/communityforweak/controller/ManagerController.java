package com.hbue.communityforweak.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
	
	//获取待审批用户
	@GetMapping("/findAppUser")
	public String findAppUser(ModelMap modelMap) {
		try {
			Iterable<User> datas = userInfoService.getTypeUser("3");
			modelMap.addAttribute("data", datas);
		} catch (Exception e) {
			modelMap.addAttribute("msg", "获取未审批用户列表失败");
		}
		return "approvalUser";
	}
	
	//审批用户
	@GetMapping("/AppUser")
	public String AppUser(ModelMap modelMap, @RequestParam String userid, @RequestParam String select) {
		try {
			Boolean result = userInfoService.updateUserPermission(userid, select);
			if (result == true) {
				modelMap.addAttribute("msg", "审批用户类型通过");
			}
			else {
				modelMap.addAttribute("msg", "拒绝审批");
			}
		} catch (Exception e) {
			modelMap.addAttribute("msg", "审批失败");
		}
		Iterable<User> datas = userInfoService.getTypeUser("3");
		modelMap.addAttribute("data", datas);
		return "approvalUser";
	}
	
	@GetMapping("/freescore")
	public String freescore(ModelMap modelMap, @RequestParam int score) {
		try {
			Boolean result = userInfoService.freeScorePreMonth(score);
			if (result == true) {
				modelMap.addAttribute("msg", "积分发放成功");
			}
			else {
				modelMap.addAttribute("msg", "本月已发放");
			}
		} catch (Exception e) {
			System.out.println("===========" + e);
			modelMap.addAttribute("msg", "积分发放失败");
		}
		return "freeScore";
	}
	
	//============
	@GetMapping("/activityAllUser")
	public String activityAllUser(ModelMap modelMap, @RequestParam String id) {
		try {
			Iterable<User> datas = userInfoService.getUserByActivityidAndFlag(Integer.parseInt(id), 0);
			modelMap.addAttribute("actId", id);
			modelMap.addAttribute("data", datas);
		} catch (Exception e) {
			modelMap.addAttribute("msg", "获取参与者名单失败");
		}
		return "actSign";
	}
	
	@GetMapping("/attendance")
	public String attendance(ModelMap modelMap, HttpSession session, @RequestParam String userid, @RequestParam int activityid) {
		try {
			int score = activityInfoService.findOne(activityid).getScoreadd();
			userInfoService.updateUserFlag(userid, activityid, score);
			User user = userInfoService.getUser(userid);
			session.setAttribute("user", user);
			modelMap.addAttribute("msg", "签到成功");
		} catch (Exception e) {
			System.out.println("================" + e);
			modelMap.addAttribute("msg", "签到失败");
		}
		Iterable<User> datas = userInfoService.getUserByActivityidAndFlag(activityid, 0);
		modelMap.addAttribute("actId", activityid);
		modelMap.addAttribute("data", datas);

		return "actSign";
	}
	
//	@GetMapping("/approval")
//	public String approval(ModelMap modelMap, @RequestParam String id, @RequestParam String select) {
//		try {
//			Boolean result = serverInfoService.approval(id, select);
//			if (result == true) {
//				modelMap.addAttribute("msg", "审批服务成功");
//			}
//			else {
//				modelMap.addAttribute("msg", "审批不通过");
//			}
//		} catch (Exception e) {
//			modelMap.addAttribute("msg", "审批服务失败");
//		}
//		return modelMap.addAttribute;
//	}
	
	@GetMapping("/actSign")
	public String actSign() {
		return "actSign";
	}
	
	@GetMapping("/freeScorePage")
	public String freeScorePage() {
		return "freeScore";
	}
}