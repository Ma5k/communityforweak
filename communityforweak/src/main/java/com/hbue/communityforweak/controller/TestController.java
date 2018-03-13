package com.hbue.communityforweak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hbue.communityforweak.entry.Activity;
import com.hbue.communityforweak.entry.Activity_partake;
import com.hbue.communityforweak.entry.Service_partake;
import com.hbue.communityforweak.entry.Serving;
import com.hbue.communityforweak.service.ActivityInfoService;
import com.hbue.communityforweak.service.Activity_partakeService;
import com.hbue.communityforweak.service.Service_partakeService;
import com.hbue.communityforweak.service.ServingInfoService;

@Controller
@RequestMapping(path="/test")
public class TestController {
	@Autowired 
	private ActivityInfoService activityInfoService;
	
	@Autowired 
	private ServingInfoService servingInfoService;
	
	@Autowired
	private Activity_partakeService activity_partakeService;
	
	@Autowired Service_partakeService service_partakeService;
	
	
	@GetMapping(path="/act")
	public @ResponseBody Iterable<Activity> getactAll(){
		return activityInfoService.getAllActivitys();
	}
	
	@GetMapping(path="/ser")
	public @ResponseBody Iterable<Serving> getserAll(){
		return servingInfoService.getAllServings();
	}
	
	@GetMapping(path="/actpar")
	public @ResponseBody Iterable<Activity_partake> getap(){
		return activity_partakeService.findByUserid("14150058");
	}
	
	@GetMapping(path="/serpar")
	public @ResponseBody Iterable<Service_partake> getspAll(){
		return service_partakeService.getAll();
	}
}
