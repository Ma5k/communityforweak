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

import com.alibaba.fastjson.JSONObject;
import com.hbue.communityforweak.entry.User;
import com.hbue.communityforweak.service.UserInfoService;

@Controller
@RequestMapping(path = "/user")
public class UserController {
	
	@Autowired
	private UserInfoService userInfoService;

	@GetMapping(path = "/login")
	public String login(Map<String, Object> map) {
		map.put("msg", "用户名为数字");
		return "login";
	}

	@PostMapping("/loginVerify")
	public String loginVerify(@RequestParam String userid, @RequestParam String password, HttpSession session,
			Map<String, Object> map) {
		User user = userInfoService.getUser(userid);
		if (user == null) {
			map.put("msg", "用户名不存在!");
			return "login";
		} else if (user.getPassword().equals(password)) {
			map.put("msg", "登录成功!");
			session.setAttribute("user", user);
			map.put("all",userInfoService.getTypeUser(1+""));
			return "redirect:/activity/byPageAndClassify0";
		} else {
			map.put("msg", "密码错误!");
			return "login";
		}
	}

	@GetMapping("/regist")
	public String register(Map<String, Object> map) {
		map.put("msg", "");
		return "regist";
	}

	@PostMapping("/registVerify")
	public String registerVerify(HttpServletRequest request, Map<String, Object> map) {
		String userid = request.getParameter("userid");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String passwordRe = request.getParameter("passwordRe");
		String address = request.getParameter("address");
		String tel = request.getParameter("tel");
		System.out.println(userid+username+password+passwordRe+address+tel);
		if (userid.equals("") || username.equals("") || password.equals("") || passwordRe.equals("") || address.equals("") || tel.equals("")) {
			map.put("msg", "请填写完整信息！");
			return "regist";
		} else if (userInfoService.getUser(userid) != null) {
			map.put("msg", "用户id已被注册！");
			return "regist";
		} else if (password.equals(passwordRe)) {
			User nuser = new User();
			nuser.setUserid(userid);
			nuser.setUsername(username);
			nuser.setPassword(password);
			nuser.setScore(0);
			nuser.setPermission((byte) 1);
			nuser.setTel(tel);
			nuser.setAddress(address);
			userInfoService.save(nuser);
			map.put("msg", "注册成功请登录！");
			return "login";
		} else {
			map.put("msg", "两次输入密码不同！");
			return "regist";
		}
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		JSONObject reObject = new JSONObject();
		try {
			session.removeAttribute("user");
			reObject.put("data", "注销成功");
		}
		catch (Exception e) {
			reObject.put("error", "注销失败！请检查网络");
		}
		return "login";
	}
	
	@GetMapping("/updateUserInfo")
	@ResponseBody
	public String updateUserInfo(@RequestParam String userid,@RequestParam String username,@RequestParam String address,@RequestParam String tel, HttpSession session) {
		JSONObject reObject = new JSONObject();
		try {
			userInfoService.update(userid, username, address, tel);
			User user = userInfoService.getUser(userid);
			session.setAttribute("user", user);
			reObject.put("data", null);
		}
		catch (Exception e) {
			reObject.put("error", "修改信息失败");
		}
		return reObject.toString();
	}
	
	@GetMapping("/appUserInfo")
	@ResponseBody
	public String appUserInfo(@RequestParam String userid, @RequestParam String idcard) {
		JSONObject reObject = new JSONObject();
		try {
			userInfoService.appPermission(userid, idcard);
			reObject.put("data", null);
		}
		catch (Exception e) {
			reObject.put("error", "优待申请失败");
		}
		return reObject.toString();
	}
	
	@GetMapping("/addScore")
	@ResponseBody
	public String addScore(@RequestParam String sessionUserid, @RequestParam String serverid, @RequestParam String userid, @RequestParam String score) {
		JSONObject reObject = new JSONObject();
		try {
			userInfoService.addScore(sessionUserid, serverid, userid, score);
			reObject.put("data", "发放成功");
		}
		catch (Exception e) {
			reObject.put("error", "积分发放失败");
		}
		return reObject.toString();
	}
	
	@GetMapping("/personInfo")
	public String personInfo(Map<String, Object> map) {
		map.put("msg", "");
		return "personInfo";
	}
	
	//管理员页面
	@GetMapping("/admin")
	public String admin(){
		return "admin";
	}
	
	//用户信息
	@GetMapping("/user_center")
	public String user_center(Map<String, Object> map) {
		map.put("msg", "");
		return "user_center";
	}
	
	
	@GetMapping("/user_service")
	public String user_service(Map<String, Object> map) {
		map.put("msg", "");
		return "user_service";
	}
	
	//申请优待
	@GetMapping("/user_pre")
	public String user_pre() {
		return "user_pre";
	}
}
