package com.hbue.communityforweak.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.hbue.communityforweak.entry.Server;
import com.hbue.communityforweak.entry.User;
import com.hbue.communityforweak.service.ServerInfoService;
import com.hbue.communityforweak.service.UserInfoService;

@Controller
@RequestMapping(path = "/user")
public class UserController {
	
	@Autowired
	private UserInfoService userInfoService;
	
	@Autowired ServerInfoService serverInfoService;

	@GetMapping(path = "/login")
	public String login(Map<String, Object> map) {
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
			return "index";
		} else {
			map.put("msg", "密码错误!");
			return "login";
		}
	}

	@GetMapping("/regist")
	public String register(Map<String, Object> map) {
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
	public String logout(ModelMap modelMap, HttpSession session) {
		try {
			session.removeAttribute("user");
			modelMap.addAttribute("msg", "注销成功");
		}
		catch (Exception e) {
			modelMap.addAttribute("msg", "注销失败！请检查网络");
		}
		return "login";
	}
	
	@GetMapping("/updateUserInfo")
	public String updateUserInfo(ModelMap modelMap, @RequestParam String userid,@RequestParam String username,@RequestParam String address,@RequestParam String tel, HttpSession session) {
		try {
			userInfoService.update(userid, username, address, tel);
			User user = userInfoService.getUser(userid);
			session.setAttribute("user", user);
			modelMap.addAttribute("msg", "修改成功");
		}
		catch (Exception e) {
			modelMap.addAttribute("msg", "修改信息失败");
		}
		return "user_center";
	}
	
	@GetMapping("/appUserInfo")
	public String appUserInfo(ModelMap modelMap, @RequestParam String userid, @RequestParam String idcard) {
		try {
			userInfoService.appPermission(userid, idcard);
			modelMap.addAttribute("msg", "申请成功");
		}
		catch (Exception e) {
			modelMap.addAttribute("msg", "优待申请失败");
		}
		return "user_pre";
	}
	
	@GetMapping("/addScore")
	public String addScore(ModelMap modelMap, @RequestParam String sessionUserid, @RequestParam String serverid, @RequestParam String userid, @RequestParam String score) {
		try {
			userInfoService.addScore(sessionUserid, serverid, userid, score);
			modelMap.addAttribute("msg", "发放成功");
		}
		catch (Exception e) {
			modelMap.addAttribute("msg", "积分发放失败");
		}
		Iterable<User> dataNodes = serverInfoService.getUserByServeridAndFlag(Integer.parseInt(serverid), 0);
		Server server = serverInfoService.getOne(serverid);
		modelMap.addAttribute("server", server);
		modelMap.addAttribute("data", dataNodes);
		return "giveScore";
	}
	
	@GetMapping("/personInfo")
	public String personInfo(Map<String, Object> map) {
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
		return "user_center";
	}
	
	
	@GetMapping("/user_service")
	public String user_service(Map<String, Object> map) {
		return "user_service";
	}
	
	//申请优待
	@GetMapping("/user_pre")
	public String user_pre() {
		return "user_pre";
	}
	
	//发放积分页面
	@GetMapping("/giveScore")
	public String giveScore() {
		return "giveScore";
	}
	
	//修改密码页面
	@GetMapping("/modifyPwdPage")
	public String modifyPwdPage() {
		return "modifyPwd";
	}
	
	//修改密码
	@PostMapping("modifyPwd")
	public String modifyPwd(HttpServletRequest request, HttpSession session, ModelMap modelMap) {
		String oldPwd = request.getParameter("oldPwd");
		String newPwd = request.getParameter("newPwd");
		String rePwd = request.getParameter("rePwd");
		User curUser = (User) session.getAttribute("user");
		User user = userInfoService.getUser(curUser.getUserid());
		if(!oldPwd.equals(curUser.getPassword())) {
			modelMap.addAttribute("msg", "密码错误");
		}else if(!newPwd.equals(rePwd)){
			modelMap.addAttribute("msg", "两次输入密码不一致");
		}else if(oldPwd.equals(curUser.getPassword()) && newPwd.equals(rePwd)) {
			user.setPassword(newPwd);
			userInfoService.save(user);
			session.setAttribute("user", user);
			modelMap.addAttribute("msg", "修改成功");
		}
		return "modifyPwd";
	}
}
