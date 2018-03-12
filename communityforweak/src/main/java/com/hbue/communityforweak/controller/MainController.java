package com.hbue.communityforweak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hbue.communityforweak.dao.UserRepository;
import com.hbue.communityforweak.entry.User;
import com.hbue.communityforweak.service.UserInfoService;

@Controller
@RequestMapping(path="/spring")
public class MainController {
	
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private UserInfoService userInfoService;

    @GetMapping(path="/add")
    public @ResponseBody String addNewUser (@RequestParam String username
            , @RequestParam String password) {
        // @ResponseBody 表示返回的string是一个回应（response），不是一个视图
        // @RequestParam 表示接收的参数可以是get或post

        User n = new User();
        n.setUsername(username);
        n.setPassword(password);
        userRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
    	Iterable<User> iterables = userInfoService.getAllUsers();
        return iterables;
    }
    
    @RequestMapping("/byName")
    public @ResponseBody Iterable<User> getUserByName(@RequestParam String name){
    	Iterable<User> user = userInfoService.findByUsername(name);    	
    	return user;
    }
    
    @RequestMapping("/homepage")
    public String homepge() {
    	return "homepage";
    }

}