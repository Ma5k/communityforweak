package com.hbue.communityforweak.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.hbue.communityforweak.entry.Server;
import com.hbue.communityforweak.entry.pvo.ServerUser;
import com.hbue.communityforweak.service.ServerInfoService;

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
	@ResponseBody
	public String userServerList(@RequestParam String userid) {
		JSONObject reObject = new JSONObject();
		try {
			Iterable<Server> dataNodes = serverInfoService.userServerList(userid);
			reObject.put("data", dataNodes);
		}
		catch (Exception e) {
			reObject.put("error", "获取用户参加服务列表失败");
		}
		return reObject.toString();
	}
	
	@GetMapping("/userAppServerList")
	@ResponseBody
	public String userAppServerList(@RequestParam String userid) {
		JSONObject reObject = new JSONObject();
		try {
			Iterable<Server> dataNodes = serverInfoService.getUserServer(userid);
			reObject.put("data", dataNodes);
		}
		catch (Exception e) {
			reObject.put("error", "获取用户发起服务列表失败");
		}
		return reObject.toString();
	}
	
	@GetMapping("/getServerUserList")
	@ResponseBody
	public String getServerUserList(@RequestParam String serverid) {
		JSONObject reObject = new JSONObject();
		try {
			List<ServerUser> dataNodes = serverInfoService.getServerUserList(serverid);
			reObject.put("data", dataNodes);
		}
		catch (Exception e) {
			reObject.put("error", "获取参与用户失败");
		}
		return reObject.toString();
	}
}
