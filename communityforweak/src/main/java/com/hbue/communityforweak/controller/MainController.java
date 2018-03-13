package com.hbue.communityforweak.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/spring")
public class MainController {
	
//    @GetMapping(path="/all")
//    public @ResponseBody Iterable<User> getAllUsers() {
//    	Iterable<User> iterables = userInfoService.getAllUsers();
//        return iterables;
//    }
//    
//    @RequestMapping("/byName")
//    public @ResponseBody Iterable<User> getUserByName(@RequestParam String name){
//    	Iterable<User> user = userInfoService.findByUsername(name);    	
//    	return user;
//    }
    
    @RequestMapping("/homepage")
    public String homepge() {
    	return "homepage";
    }

}