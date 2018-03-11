package com.hbue.communityforweak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hbue.communityforweak.dao.ServingRepository;
import com.hbue.communityforweak.entry.Serving;
import com.hbue.communityforweak.service.ServingInfoService;

@Controller
@RequestMapping(path="/serving")
public class ServingController {
	@Autowired
	private ServingRepository servingRepository;
	
	@Autowired
	private ServingInfoService servingInfoService;
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Serving> getAllServings(){
		Iterable<Serving> servings = servingInfoService.getAllServings();
		return servings;
	}
	
	@GetMapping(path="/byClassify")
	public @ResponseBody Iterable<Serving> getServingsByClassigy(@RequestParam String classify){
		Iterable<Serving> servings = servingInfoService.findByClassify(classify);
		return servings;
	}
}
