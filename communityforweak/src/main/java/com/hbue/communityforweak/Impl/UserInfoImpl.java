package com.hbue.communityforweak.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hbue.communityforweak.dao.ActivityPartakedao;
import com.hbue.communityforweak.dao.ServerPartakedao;
import com.hbue.communityforweak.dao.Userdao;
import com.hbue.communityforweak.entry.Activitypartake;
import com.hbue.communityforweak.entry.Serverpartake;
import com.hbue.communityforweak.entry.User;
import com.hbue.communityforweak.service.UserInfoService;

@Service
public class UserInfoImpl implements UserInfoService {
	
	@Autowired
    private Userdao userdao;
	
	@Autowired
	private ActivityPartakedao activityPartakedao;
	
	@Autowired
	private ServerPartakedao serverPartakedao;
	
	public void save(User user) {
		userdao.save(user);
	}

	public User getUser(String userid) {
		return userdao.findByUserid(userid);
	}
	
	public Iterable<User> getTypeUser(String permission) {
		return userdao.findByPermission(Integer.parseInt(permission));
	}

	public void update(String userid, String username, String address, String tel){
		User user = userdao.findByUserid(userid);
		user.setUsername(username);
		user.setAddress(address);
		user.setTel(tel);
		userdao.save(user);
	}
	
	public void appPermission(String userid, String idcard) {
		User user = userdao.findByUserid(userid);
		user.setIdcard(idcard);
		user.setPermission(3);
		userdao.save(user);
	}
	
	public Boolean updateUserPermission(String userid, String select) {
		User user = userdao.findByUserid(userid);
		if(select.equals("yes")) {
			user.setPermission(2);
			userdao.save(user);
			return true;
		}
		else if (select.equals("no")){
			user.setPermission(1);
			user.setIdcard(null);
			userdao.save(user);
			return false;
		}
		return false;
	}
	
	public Boolean freeScorePreMonth(int addscore) {
		userdao.updatefreeScorePreMonth(addscore);
		return true;
	}
	
	public void partakeActive(String userid, String id, String tel) {
		Activitypartake partake = new Activitypartake();
		partake.setUserid(userid);
		partake.setActivityid(Integer.parseInt(id));
		partake.setComment("");
		partake.setFlag(1);
		partake.setTel(tel);
		activityPartakedao.save(partake);
	}

	public void partakeServer(String userid, String id, String tel) {
		Serverpartake partake = new Serverpartake();
		partake.setUserid(userid);
		partake.setServerid(Integer.parseInt(id));
		partake.setFlag(0);
		partake.setTel(tel);
		serverPartakedao.save(partake);
	}
	
	public void updateUserFlag(String userid, int activityid, int score) {
		// ???????????
		Activitypartake ac = activityPartakedao.findByUseridAndActivityid(userid, activityid);
		ac.setFlag(1);
		activityPartakedao.save(ac);
		// 积分发放
		User user = userdao.findByUserid(userid);
		user.setScore(user.getScore() + score);
		userdao.save(user);
	}

	public void addScore(String sessionUserid, String serverid, String userid, String score) {
		// 此处应该用事务处理
		User user = userdao.findByUserid(sessionUserid);
		user.setScore(user.getScore() - Integer.parseInt(score));
		userdao.save(user);
		User user2 = userdao.findByUserid(userid);
		user.setScore(user2.getScore() + Integer.parseInt(score));
		userdao.save(user2);
	}
}
