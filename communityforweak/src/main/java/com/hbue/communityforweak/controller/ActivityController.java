package com.hbue.communityforweak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hbue.communityforweak.entry.Activity;
import com.hbue.communityforweak.service.ActivityInfoService;

@Controller
@RequestMapping(path="/activity")
public class ActivityController {
	
	@Autowired
	private ActivityInfoService activityInfoService;
	
	@GetMapping(path="/byClassify")
	public @ResponseBody Iterable<Activity> getActivitiesByClassify(@RequestParam String classify){
		System.out.println("byClassify" + classify);
		Iterable<Activity> activities = activityInfoService.findByClassify(classify);
		return activities;
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Activity> getAllActivitys(){
		Iterable<Activity> activities = activityInfoService.getAllActivitys();
		return activities;
	}
}
