package com.hbue.communityforweak.controller;

import org.apache.el.parser.AstMapData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.hbue.communityforweak.dao.ActivityPartakedao;
import com.hbue.communityforweak.dao.Activitydao;
import com.hbue.communityforweak.entry.Activity;
import com.hbue.communityforweak.entry.Activitypartake;

@Controller
@RequestMapping(path="/test")
public class testController {
	@Autowired
	private ActivityPartakedao act;
	
	@Autowired
	private Activitydao actDao;
	
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
}
