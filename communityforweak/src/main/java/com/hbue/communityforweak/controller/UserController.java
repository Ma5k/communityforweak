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

import com.hbue.communityforweak.dao.UserRepository;
import com.hbue.communityforweak.entry.User;
import com.hbue.communityforweak.service.UserInfoService;

@Controller
@RequestMapping(path = "/user")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserInfoService userInfoService;

	@GetMapping(path = "/byUsername")
	public @ResponseBody Iterable<User> getUserByUsername(@RequestParam String username) {
		System.out.println("byName" + username);
		Iterable<User> user = userInfoService.findByUsername(username);
		return user;
	}

	@GetMapping(path = "/byUserid")
	public @ResponseBody User getUserByUserid(@RequestParam String userid) {
		System.out.println("byId" + userid);
		User user = userInfoService.findByUserid(userid);
		return user;
	}

	@GetMapping(path = "/login")
	public String login(Map<String, Object> map) {
		map.put("msg", "用户名为数字");
		return "login";
	}

	@PostMapping("/loginVerify")
	public String loginVerify(@RequestParam String userid, @RequestParam String password, HttpSession session,
			Map<String, Object> map) {
		User user = userInfoService.findByUserid(userid);

		if (user == null) {
			map.put("msg", "用户名不存在!");
			return "/login";
		} else if (user.getPassword().equals(password)) {
			map.put("msg", "登录成功!");
			session.setAttribute("user", user);
			return "/homepage";
		} else {
			map.put("msg", "密码错误!");
			return "/login";
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
			return "/register";
		} else if (userInfoService.findByUserid(userid) != null) {
			map.put("msg", "用户id已被注册！");
			return "/register";
		} else if (password.equals(passwordRe)) {
			User nuser = new User();
			nuser.setUserid(userid);
			nuser.setUsername(username);
			nuser.setPassword(password);
			nuser.setScore(0);
			nuser.setTel(tel);
			nuser.setAddress(address);
			userRepository.save(nuser);
			map.put("msg", "注册成功请登录！");
			return "/login";
		} else {
			map.put("msg", "两次输入密码不同！");
			return "/register";
		}
	}

	@GetMapping("/logout")
	public String logout(HttpSession session, Map<String, Object> map) {
		session.removeAttribute("user");
		map.put("msg", "您已注销，请重新登录！");
		return "/login";
	}

}
