package com.hbue.communityforweak.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.hbue.communityforweak.dao.ActivityPartakedao;
import com.hbue.communityforweak.dao.Activitydao;
import com.hbue.communityforweak.dao.Serverdao;
import com.hbue.communityforweak.dao.Userdao;
import com.hbue.communityforweak.entry.Activity;
import com.hbue.communityforweak.entry.Activitypartake;
import com.hbue.communityforweak.entry.Server;
import com.hbue.communityforweak.entry.User;
import com.hbue.communityforweak.service.ActivityInfoService;
import com.hbue.communityforweak.service.UserInfoService;

@Controller
@RequestMapping(path="/test")
public class testController {
	@Autowired
	private ActivityPartakedao act;
	
	@Autowired
	private Activitydao actDao;
	
	@Autowired
	private ActivityInfoService actInfoser;
	
	@Autowired
	private UserInfoService userinfo;
	
	@Autowired
	private Serverdao serdao;
	
	@Autowired
	private Userdao userdao;
	
	@GetMapping("/t")
	@ResponseBody
	public String t() {
		JSONObject reObject = new JSONObject();
		String userid = "14150292";
		int activityid = 5;
		Activitypartake ac = act.findByUseridAndActivityid(userid, activityid);
		reObject.put("data", ac);
		return reObject.toString();
	}
	
	@GetMapping("/t1")
	@ResponseBody
	public String t1() {
		JSONObject reObject = new JSONObject();
		String userid = "14150292";
		int activityid = 5;
		Activity ac = actDao.findById(activityid);
		reObject.put("data", ac);
		return reObject.toString();
	}
	
	@GetMapping("/t2")
	@ResponseBody
	public String t2() {
		JSONObject reObject = new JSONObject();
		String userid = "14150292";
		int activityid = 5;
		Iterable<User> ac = userinfo.getTypeUser("1");
		reObject.put("data", ac);
		return reObject.toString();
	}
	
	@GetMapping("/t3")
	@ResponseBody
	public String t3() {
		JSONObject reObject = new JSONObject();
		String userid = "14150292";
		int activityid = 5;
		Iterable<User> ac = userdao.getUserByActivityidAndFlag(0, 0);
		//List<User> ac = act.test();
		//Iterable<Server> ac = serdao.getUserServerlist("14150292");
		reObject.put("data", ac);
		return reObject.toString();
	}
	
}
