package com.hbue.communityforweak.Impl;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

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

	public void comment(String userid, int activityid, String comment) {
		Activitypartake ac = activityPartakedao.findByUseridAndActivityid(userid, activityid);
		ac.setComment(comment);
		activityPartakedao.save(ac);
	}
	
	//分页查找
	public Page<Activity> findBypage(final int active, int page, int size) {
		Specification<Activity> specification = new Specification<Activity>() {

			@Override
			public Predicate toPredicate(Root<Activity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Path<Integer> $active = root.get("active");
				Predicate _active = cb.equal($active, active);
				return _active;
			}
		};
		Pageable pageable = new PageRequest(page, size);
		return activitydao.findAll(specification, pageable);
	}

	//查找某一个活动
	public Activity findOne(int activityid) {
		return activitydao.findById(activityid);
	}
	
	//带条件分页查找
	public Page<Activity> findPageByClassify(final int active, final String classify, int page, int size) {
		Specification<Activity> specification = new Specification<Activity>() {

			@Override
			public Predicate toPredicate(Root<Activity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Path<String> $classify = root.get("classify");
				Path<Integer> $active = root.get("active");
				Predicate _classify = cb.equal($classify, classify);
				Predicate _active = cb.equal($active, active);
				
				Predicate p = cb.and(_classify, _active);
				return p;
			}
		};
		Pageable pageable = new PageRequest(page, size);
		return activitydao.findAll(specification, pageable);
	}
	
	//判断用户是否已参加活动
	public Boolean alreadyPartakeAct(String userid, int activityid) {
		Activitypartake ac = activityPartakedao.findByUseridAndActivityid(userid, activityid);
		if(ac != null) {
			return true;
		}else {
			return false;
		}
	}
	
}
