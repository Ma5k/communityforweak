package com.hbue.communityforweak.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
    @RequestMapping("/index")
    public String homepge() {
    	return "index";
    }
}