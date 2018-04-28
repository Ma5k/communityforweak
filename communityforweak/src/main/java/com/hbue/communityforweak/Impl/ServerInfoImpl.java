package com.hbue.communityforweak.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

import com.hbue.communityforweak.dao.ServerPartakedao;
import com.hbue.communityforweak.dao.Serverdao;
import com.hbue.communityforweak.entry.Activity;
import com.hbue.communityforweak.entry.Server;
import com.hbue.communityforweak.entry.pvo.ServerUser;
import com.hbue.communityforweak.service.ServerInfoService;

@Service
public class ServerInfoImpl implements ServerInfoService{
	
	@Autowired
	private Serverdao serverdao;
	
	@Autowired
	private ServerPartakedao serverPartakedao;
	
	public void save(Server server) {
		serverdao.save(server);
	}

	public Iterable<Server> getServerList(int active) {
		return serverdao.findByActive(active);
	}

	public Iterable<Server> findServerList(String classify) {
		return serverdao.findByClassifyAndActive(classify, 1);
	}
	
	public Iterable<Server> userServerList(String userid) {
		Iterable<Server> list = serverdao.getUserServerlist(userid);
		return list;
	}
	
	public boolean appServer(String userid, Server server) {
		int exsit = serverdao.existServer(userid);
		if(exsit > 0) {
			return false;
		}
		else {
			serverdao.save(server);
			return true;
		}
		
	}
	
	public Iterable<Server> getUserServer(String userid) {
		return serverdao.findByUserid(userid);
	}

	public Boolean approval(String id, String select) {
		Server server = serverdao.findOne(Long.parseLong(id));
		if(select == "yes") {
			server.setActive(1);
			serverdao.save(server);
			return true;
		}
		else {
			serverdao.delete(server);
			return false;
		}
		
	}

	public ArrayList<ServerUser> getServerUserList(String serverid) {
		List<Object[]> ndata = serverPartakedao.getAllUser(serverid);
		ArrayList<ServerUser> ldata = new ArrayList<ServerUser>();
		for(int i=0; i < ndata.size(); i++)
		{
			ServerUser data = new ServerUser();
			data.setUserid(ndata.get(i)[0] + "");
			data.setUsername(ndata.get(i)[1] + "");
			data.setFlag(Integer.parseInt(ndata.get(i)[2] + ""));
			ldata.add(data);
		}
		return ldata;
	}
	
	//分页查找
	public Page<Server> findBypage(int page, int size) {
		Order order1 = new Order(Direction.DESC, "startime");  
		Order order2 = new Order(Direction.DESC, "scoreadd");  
		Sort sort = new Sort(order1, order2);
		
		PageRequest pageable = new PageRequest(page, size, sort);
		Page<Server> pageSer = serverdao.findAll(pageable);
		return pageSer;
	}
}
