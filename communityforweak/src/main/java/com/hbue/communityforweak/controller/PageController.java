package com.hbue.communityforweak.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.hbue.communityforweak.Util.MyUtil;
import com.hbue.communityforweak.entry.Activity;
import com.hbue.communityforweak.entry.Server;
import com.hbue.communityforweak.service.ActivityInfoService;
import com.hbue.communityforweak.service.ServerInfoService;
import com.hbue.communityforweak.service.UserInfoService;

@Controller
public class PageController {

	@Autowired
	private UserInfoService userInfoService;

	@Autowired
	private ServerInfoService serverInfoService;

	@Autowired
	private ActivityInfoService activityInfoService;

	@GetMapping("/partakeActivity")
	public String partakeActivity(@RequestParam String userid, @RequestParam String activityid,
			@RequestParam String tel, ModelMap modelMap) {
		try {
			if (activityInfoService.alreadyPartakeAct(userid, Integer.parseInt(activityid))) {
				modelMap.addAttribute("msg", "您已参加该活动请勿重复报名");
			} else {
				userInfoService.partakeActive(userid, activityid, tel);
				modelMap.addAttribute("msg", "参加成功");
			}
		} catch (Exception e) {
			modelMap.addAttribute("msg", "活动参加失败");
		}
		modelMap.addAttribute("pageResult", activityInfoService.findBypage(0, 0, 4));
		modelMap.addAttribute("classify", "0");
		return "activity";
	}

	@GetMapping("/partakeServer")
	public String partakeServer(@RequestParam String userid, @RequestParam String serviceid, @RequestParam String tel,
			ModelMap modelMap) {
		try {
			if(serverInfoService.alreadyPartakeSer(userid, Integer.parseInt(serviceid))) {
				modelMap.addAttribute("msg", "您已参与该服务请勿重复参加");
			}else {
				userInfoService.partakeServer(userid, serviceid, tel);
				modelMap.addAttribute("msg", "参加成功");
			}
		} catch (Exception e) {
			modelMap.addAttribute("msg", "参加服务失败");
		}
		modelMap.addAttribute("pageResult", serverInfoService.findBypage(0, 0, 4));
		modelMap.addAttribute("classify", "0");
		return "server";
	}

	@GetMapping("/appService")
	public String appService(@RequestParam String userid, @RequestParam String servicename, @RequestParam String tel,
			@RequestParam String ineed, @RequestParam String startime, @RequestParam String endtime,
			@RequestParam String scoreadd, @RequestParam String classify, ModelMap modelMap) {
		try {
			Server server = new Server();
			server.setActive(0);
			server.setClassify(classify);
			server.setStartime(MyUtil.StringToDate(startime));
			server.setEndtime(MyUtil.StringToDate(endtime));
			server.setIneed(ineed);
			server.setScoreadd(Integer.parseInt(scoreadd));
			server.setServername(servicename);
			server.setTel(tel);
			server.setUserid(userid);

			//boolean exist = serverInfoService.appServer(userid, server);
//			if (exist) {
//				modelMap.addAttribute("msg", "请勿重复申请");
//			} else {
				serverInfoService.save(server);
				modelMap.addAttribute("msg", "申请成功");
			//}
		} catch (Exception e) {
			System.out.println(e);
			modelMap.addAttribute("msg", "申请服务失败");
		}
		return "addService";
	}

	@PostMapping("/addActivity")
	public String addActivity(ModelMap modelMap, HttpServletRequest request) {
		try {
			Activity activity = new Activity();
			activity.setActive(0);
			activity.setActivityname(request.getParameter("activityname"));
			activity.setClassify(Integer.parseInt(request.getParameter("classify")));
			activity.setStartime(MyUtil.StringToDate(request.getParameter("startime")));
			activity.setEndtime(MyUtil.StringToDate(request.getParameter("endtime")));
			activity.setDocument(request.getParameter("document"));
			activity.setScoreadd(Integer.parseInt(request.getParameter("scoreadd")));
			// 图片

			activityInfoService.save(activity);
			modelMap.addAttribute("msg", "添加成功");

		} catch (Exception e) {
			modelMap.addAttribute("msg", "添加活动失败");
		}
		return "addActivity";
	}

}