package com.hbue.communityforweak.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hbue.communityforweak.entry.User;
import com.hbue.communityforweak.service.UserInfoService;

@Controller
@RequestMapping(path = "/user")
public class UserController {
	
	@Autowired
	private UserInfoService userInfoService;

	@GetMapping(path = "/login")
	public String login(Map<String, Object> map) {
		map.put("msg", "");
		return "login";
	}

	@PostMapping("/loginVerify")
	public String loginVerify(@RequestParam String userid, @RequestParam String password, HttpSession session,
			Map<String, Object> map) {
		User user = userInfoService.findByUserid(userid);
		if (user == null) {
			map.put("msg", "用户名不存在!");
			return "redirect:/user/login";
		} else if (user.getPassword().equals(password)) {
			map.put("msg", "登录成功!");
			session.setAttribute("user", user);
			return "redirect:/index";
		} else {
			map.put("msg", "密码错误!");
			return "redirect:/user/login";
		}
	}

	@GetMapping("/register")
	public String register(Map<String, Object> map) {
		map.put("msg", "");
		return "register";
	}

	@PostMapping("/registerVerify")
	public String registerVerify(HttpServletRequest request, Map<String, Object> map) {
		String userid = request.getParameter("userid");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String passwordRe = request.getParameter("passwordRe");
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");
		if (userid.equals("") || username.equals("") || password.equals("") || passwordRe.equals("") || address.equals("") || tel.equals("")) {
			map.put("msg", "请填写完整信息！");
			return "redirect:/user/register";
		} else if (userInfoService.findByUserid(userid) != null) {
			map.put("msg", "用户id已被注册！");
			return "redirect:/user/register";
		} else if (password.equals(passwordRe)) {
			User nuser = new User();
			nuser.setUserid(userid);
			nuser.setUsername(username);
			nuser.setPassword(password);
			nuser.setScore(0);
			nuser.setTel(tel);
			nuser.setAddress(address);
			userInfoService.save(nuser);
			map.put("msg", "注册成功请登录！");
			return "redirect:/user/login";
		} else {
			map.put("msg", "两次输入密码不同！");
			return "redirect:/user/register";
		}
	}

	@GetMapping("/logout")
	public String logout(HttpSession session, Map<String, Object> map) {
		session.removeAttribute("user");
		map.put("msg", "您已注销，请重新登录！");
		return "redirect:/user/login";
	}
	
	@GetMapping("/all")
	public @ResponseBody Iterable<User> getAll(){
		return userInfoService.getAllUsers();
	}
	
	@GetMapping("/byUserid")
	public @ResponseBody User byUserid(@RequestParam String userid) {
		return userInfoService.findByUserid(userid);
	}
	
	@GetMapping("/byUsername")
	public @ResponseBody Iterable<User> byUsername(@RequestParam String username) {
		return userInfoService.findByUsername(username);
	}
	
	@GetMapping("/byIdcard")
	public @ResponseBody User byIdcard(@RequestParam String idcard) {
		return userInfoService.findByIdcard(idcard);
	}
	
	@GetMapping("/byAddress")
	public @ResponseBody Iterable<User> byAddress(@RequestParam String address){
		return userInfoService.findByAddress(address);
	}
	
	@GetMapping("/byPermission")
	public @ResponseBody Iterable<User> byPermission(@RequestParam Byte permission){
		return userInfoService.findByPermission(permission);
	}
	
	@GetMapping("/byServiceid")
	public @ResponseBody Iterable<User> byServiceid(@RequestParam int serid){
		return userInfoService.findByServiceid(serid);
	}
}
