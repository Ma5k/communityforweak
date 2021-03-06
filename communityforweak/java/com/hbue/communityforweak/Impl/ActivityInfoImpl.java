package com.hbue.communityforweak.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hbue.communityforweak.dao.ActivityPartakedao;
import com.hbue.communityforweak.dao.Activitydao;
import com.hbue.communityforweak.entry.Activity;
import com.hbue.communityforweak.entry.Activitypartake;
import com.hbue.communityforweak.entry.pvo.ActivityUser;
import com.hbue.communityforweak.service.ActivityInfoService;

@Service
public class ActivityInfoImpl implements ActivityInfoService {
	
	@Autowired
	private Activitydao activitydao;
	
	@Autowired
	private ActivityPartakedao activityPartakedao;
	
	public void save(Activity activity) {
		activitydao.save(activity);
	}

	public Iterable<Activity> getActiveList(int active) {
		return activitydao.findByActive(active);
	}

	public Iterable<Activity> findActiveList(String classify) {
		return activitydao.findByClassifyAndActive(classify, 1);
	}

	public List<ActivityUser> getAllUser(String id) {
		List<Object[]> ndata = activityPartakedao.getAllUser(id);
		ArrayList<ActivityUser> ldata = new ArrayList<ActivityUser>();
		for(int i=0; i < ndata.size(); i++)
		{
			ActivityUser data = new ActivityUser();
			data.setUserid(ndata.get(i)[0] + "");
			data.setUsername(ndata.get(i)[1] + "");
			data.setActivityid(Integer.parseInt(ndata.get(i)[2] + ""));
			data.setFlag(Integer.parseInt(ndata.get(i)[3] + ""));
			ldata.add(data);
		}
		return ldata;
	}

	public Iterable<Activity> userActivityList(String userid) {
		return activitydao.getUserActivitylist(userid);
	}

	public void comment(String userid, String activityid, String comment) {
		Activitypartake ac = activityPartakedao.findByUseridAndActivityid(userid, activityid);
		ac.setComment(comment);
		activityPartakedao.save(ac);
	}
}
