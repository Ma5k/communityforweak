package com.hbue.communityforweak.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;

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
		public Page<Server> findBypage(final int active, int page, int size) {
			Specification<Server> specification = new Specification<Server>() {

				@Override
				public Predicate toPredicate(Root<Server> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
					Path<Integer> $active = root.get("active");
					Predicate _active = cb.equal($active, active);
					return _active;
				}
			};
			Pageable pageable = new PageRequest(page, size);
			return serverdao.findAll(specification, pageable);
		}
	
	//带条件分页查找
		public Page<Server> findPageByClassify(final int active, final String classify, int page, int size) {
			Specification<Server> specification = new Specification<Server>() {

				@Override
				public Predicate toPredicate(Root<Server> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
					Path<String> $classify = root.get("classify");
					Path<Integer> $active = root.get("active");
					Predicate _classify = cb.equal($classify, classify);
					Predicate _active = cb.equal($active, active);
					
					Predicate p = cb.and(_classify, _active);
					return p;
				}
			};
			Pageable pageable = new PageRequest(page, size);
			return serverdao.findAll(specification, pageable);
		}
}
