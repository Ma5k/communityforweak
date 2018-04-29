package com.hbue.communityforweak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.hbue.communityforweak.entry.Activity;
import com.hbue.communityforweak.service.ActivityInfoService;

@Controller
@RequestMapping(path="/activity")
public class ActivityController {
	
	@Autowired
	private ActivityInfoService activityInfoService;
	
	/**
	 * data 是进行中的活动(置顶)
	 * data2 是策划中的活动
	 * @return
	 */
	@GetMapping("/getActivityList")
	@ResponseBody
	public String getActivityList() {
		JSONObject reObject = new JSONObject();
		try {
			Iterable<Activity> dataNodes = activityInfoService.getActiveList(1);
			Iterable<Activity> dataNodes2 = activityInfoService.getActiveList(0); 
			reObject.put("data", dataNodes);
			reObject.put("data2", dataNodes2);
		}
		catch (Exception e) {
			reObject.put("error", "获取活动列表失败");
		}
		return reObject.toString();
	}
	
	@GetMapping("/findActivityList")
	@ResponseBody
	public String findActivityList(@RequestParam String classify) {
		JSONObject reObject = new JSONObject();
		try {
			Iterable<Activity> dataNodes = activityInfoService.findActiveList(classify);
			reObject.put("data", dataNodes);
		} catch (Exception e) {
			reObject.put("error", "筛选活动列表失败");
		}
		return reObject.toString();
	}
	
	@GetMapping("/getActivingList")
	public String getActivingList(ModelMap modelMap) {
		try {
			Iterable<Activity> dataNodes = activityInfoService.getActiveList(1);
			modelMap.addAttribute("data", dataNodes);
		}
		catch (Exception e) {
			modelMap.addAttribute("error", "获取进行中的活动列表失败");
		}
		return "getActivingList";
	}
	

	@GetMapping("/userActivityList")
	public String userActivityList(ModelMap modelMap, @RequestParam String userid) {
		try {
			Iterable<Activity> dataNodes = activityInfoService.userActivityList(userid);
			modelMap.addAttribute("data", dataNodes);
		}
		catch (Exception e) {
			modelMap.addAttribute("error", "获取参加活动列表失败");
		}
		return "userActivityList";
	}
	
	@GetMapping("/activityComment")
	@ResponseBody
	public String activityComment(@RequestParam String userid, @RequestParam int activityid, @RequestParam String comment) {
		JSONObject reObject = new JSONObject();
		try {
			activityInfoService.comment(userid, activityid, comment);
			reObject.put("data", "评论成功");
		}
		catch (Exception e) {
			reObject.put("error", "获取参加活动列表失败");
		}
		return reObject.toString();
	}
	
	@GetMapping(path="/addActivity")
	public String addActivity() {
		return "addActivity";
	}
	
	@GetMapping(path="/byPageAndClassify0")
	public String byPageAndClassify0(ModelMap modelMap,
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "size", required = false, defaultValue = "4") int size) {
		modelMap.addAttribute("pageResult", activityInfoService.findBypage(0, page, size));
		modelMap.addAttribute("classify", "0");
		return "activity";
	}
	
	@GetMapping(path="/byPageAndClassify1")
	public String byPageAndClassify1(ModelMap modelMap,
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "size", required = false, defaultValue = "4") int size) {
		modelMap.addAttribute("pageResult", activityInfoService.findPageByClassify(0, "1", page, size));
		modelMap.addAttribute("classify", "1");
		return "activity";
	}
	
	@GetMapping(path="/byPageAndClassify2")
	public String byPageAndClassify2(ModelMap modelMap,
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "size", required = false, defaultValue = "4") int size) {
		modelMap.addAttribute("pageResult", activityInfoService.findPageByClassify(0, "2", page, size));
		modelMap.addAttribute("classify", "2");
		return "activity";
	}
	
	@GetMapping(path="/byPageAndClassify3")
	public String byPageAndClassify3(ModelMap modelMap,
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "size", required = false, defaultValue = "4") int size) {
		modelMap.addAttribute("pageResult", activityInfoService.findPageByClassify(0, "3", page, size));
		modelMap.addAttribute("classify", "3");
		return "activity";
	}
	
	@GetMapping(path="/byPageAndClassify4")
	public String byPageAndClassify4(ModelMap modelMap,
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "size", required = false, defaultValue = "4") int size) {
		modelMap.addAttribute("pageResult", activityInfoService.findPageByClassify(0, "4", page, size));
		modelMap.addAttribute("classify", "4");
		return "activity";
	}
	
	@GetMapping(path="/byPageAndClassify5")
	public String byPageAndClassify5(ModelMap modelMap,
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "size", required = false, defaultValue = "4") int size) {
		modelMap.addAttribute("pageResult", activityInfoService.findPageByClassify(0, "5", page, size));
		modelMap.addAttribute("classify", "5");
		return "activity";
	}
}


