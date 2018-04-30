package com.hbue.communityforweak.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.hbue.communityforweak.entry.Server;
import com.hbue.communityforweak.entry.pvo.ServerUser;
import com.hbue.communityforweak.service.ServerInfoService;
import com.mysql.fabric.xmlrpc.base.Data;

@Controller
@RequestMapping(path="/server")
public class ServerController {
	
	@Autowired
	private ServerInfoService serverInfoService;
	
	@GetMapping("/getServerList")
	@ResponseBody
	public String getServerList() {
		JSONObject reObject = new JSONObject();
		try {
			Iterable<Server> dataNodes = serverInfoService.getServerList(1);
			reObject.put("data", dataNodes);
		}
		catch (Exception e) {
			reObject.put("error", "获取服务列表失败");
		}
		return reObject.toString();
	}
	
	@GetMapping("/findServerList")
	@ResponseBody
	public String findServerList(@RequestParam String classify) {
		JSONObject reObject = new JSONObject();
		try {
			Iterable<Server> dataNodes = serverInfoService.findServerList(classify);
			reObject.put("data", dataNodes);
		}
		catch (Exception e) {
			reObject.put("error", "筛选服务列表失败");
		}
		return reObject.toString();
	}
	
	@GetMapping("/findappServerList")
	@ResponseBody
	public String findappServerList() {
		JSONObject reObject = new JSONObject();
		try {
			Iterable<Server> dataNodes = serverInfoService.getServerList(0);
			reObject.put("data", dataNodes);
		}
		catch (Exception e) {
			reObject.put("error", "获取申请中的服务列表失败");
		}
		return reObject.toString();
	}
	
	@GetMapping("/userServerList")
	public String userServerList(ModelMap modelMap, @RequestParam String userid) {
		try {
			Iterable<Server> dataNodes = serverInfoService.userServerList(userid);
			modelMap.addAttribute("data", dataNodes);
		}
		catch (Exception e) {
			modelMap.addAttribute("error", "获取用户参加服务列表失败");
		}
		return "userServerList";
	}
	
	@GetMapping("/userAppServerList")
	public String userAppServerList(ModelMap modelMap,@RequestParam String userid) {
		try {
			Iterable<Server> dataNodes = serverInfoService.getUserServer(userid);
			modelMap.addAttribute("data", dataNodes);
		}
		catch (Exception e) {
			modelMap.addAttribute("error", "获取用户发起服务列表失败");
		}
		return "userAppServerList";
	}
	
	//获取用户发起的进行中的服务
	@GetMapping("/runningSerList")
	public String runningSerList(ModelMap modelMap, @RequestParam String userid) {
		try {
			Iterable<Server> data = serverInfoService.findUserRunningServer(userid);
			modelMap.addAttribute("data", data);
		}
		catch (Exception e) {
			modelMap.addAttribute("error", "获取进行中的用户服务失败");
		}
		return "runningSerList";
	}
	
	@GetMapping("/getServerUserList")
	public String getServerUserList(ModelMap modelMap, @RequestParam String serverid) {
		try {
			List<ServerUser> dataNodes = serverInfoService.getServerUserList(serverid);
			Server server = serverInfoService.getOne(serverid);
			modelMap.addAttribute("server", server);
			modelMap.addAttribute("data", dataNodes);
		}
		catch (Exception e) {
			modelMap.addAttribute("error", "获取参与用户失败");
		}
		return "giveScore";
	}
	
	@GetMapping(path="/addService")
	public String appService() {
		return "addService";
	}
	
	@GetMapping(path="/byPageAndClassify0")
	public String byPageAndClassify0(ModelMap modelMap,
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "size", required = false, defaultValue = "4") int size) {
		modelMap.addAttribute("pageResult", serverInfoService.findBypage(0, page, size));
		modelMap.addAttribute("classify", "0");
		return "server";
	}
	
	@GetMapping(path="/byPageAndClassify1")
	public String byPageAndClassify1(ModelMap modelMap,
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "size", required = false, defaultValue = "4") int size) {
		modelMap.addAttribute("pageResult", serverInfoService.findPageByClassify(0, "1", page, size));
		modelMap.addAttribute("classify", "1");
		return "server";
	}
	
	@GetMapping(path="/byPageAndClassify2")
	public String byPageAndClassify2(ModelMap modelMap,
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "size", required = false, defaultValue = "4") int size) {
		modelMap.addAttribute("pageResult", serverInfoService.findPageByClassify(0, "2", page, size));
		modelMap.addAttribute("classify", "2");
		return "server";
	}
	
	@GetMapping(path="/byPageAndClassify3")
	public String byPageAndClassify3(ModelMap modelMap,
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "size", required = false, defaultValue = "4") int size) {
		modelMap.addAttribute("pageResult", serverInfoService.findPageByClassify(0, "3", page, size));
		modelMap.addAttribute("classify", "3");
		return "server";
	}
	
	@GetMapping(path="/byPageAndClassify4")
	public String byPageAndClassify4(ModelMap modelMap,
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "size", required = false, defaultValue = "4") int size) {
		modelMap.addAttribute("pageResult", serverInfoService.findPageByClassify(0, "4", page, size));
		modelMap.addAttribute("classify", "4");
		return "server";
	}
	
	@GetMapping(path="/byPageAndClassify5")
	public String byPageAndClassify5(ModelMap modelMap,
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "size", required = false, defaultValue = "4") int size) {
		modelMap.addAttribute("pageResult", serverInfoService.findPageByClassify(0, "5", page, size));
		modelMap.addAttribute("classify", "5");
		return "server";
	}
}
