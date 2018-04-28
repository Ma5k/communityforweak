package com.hbue.communityforweak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.hbue.communityforweak.Util.MyUtil;
import com.hbue.communityforweak.entry.Server;
import com.hbue.communityforweak.service.ServerInfoService;
import com.hbue.communityforweak.service.UserInfoService;

@Controller
public class PageController {
	
	@Autowired
	private UserInfoService userInfoService;
	
	@Autowired
	private ServerInfoService serverInfoService;
	

	@GetMapping("/partakeActivity")
	@ResponseBody
	public String partakeActivity(@RequestParam String userid, @RequestParam String activityid, @RequestParam String tel, ModelMap model) {
		JSONObject reObject = new JSONObject();
		try {
			userInfoService.partakeActive(userid, activityid, tel);
			reObject.put("data", "参加成功");
		} catch (Exception e) {
			reObject.put("error", "活动参加失败");
		}
		return reObject.toString();
	}
	
	@GetMapping("/partakeServer")
	@ResponseBody
	public String partakeServer(@RequestParam String userid, @RequestParam String serviceid, @RequestParam String tel, ModelMap model) {
		JSONObject reObject = new JSONObject();
		try {
			userInfoService.partakeServer(userid, serviceid, tel);
			reObject.put("data", "参加成功");
		}
		catch (Exception e) {
			reObject.put("error", "参加服务失败");
		}
		return reObject.toString();
	}
	
	@GetMapping("/appService")
	@ResponseBody
	public String appService(@RequestParam String userid, @RequestParam String servicename, @RequestParam String tel, 
			@RequestParam String ineed, @RequestParam String startime, @RequestParam String endtime, 
			@RequestParam String scoreadd, @RequestParam String classify) {
		JSONObject reObject = new JSONObject();
		try {
			Server server = new Server();
			server.setActive(0);
			server.setClassify(classify);
			server.setStartime(MyUtil.StringToDate(startime));
			server.setEndtime(MyUtil.StringToDate(endtime));
			server.setIneed(ineed);
			server.setScoreadd(Integer.parseInt(scoreadd));
			server.setServername(servicename);
			server.setTel(tel);
			server.setUserid(userid);
			boolean exist = serverInfoService.appServer(userid, server);
			if(exist) {
				reObject.put("error", "请勿重复申请");
			}
			else {
				reObject.put("data", "申请成功");
			}
		} catch (Exception e) {
			reObject.put("error", "申请服务失败");
		}
		return reObject.toString();
	}
	
}