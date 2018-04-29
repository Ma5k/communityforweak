package com.hbue.communityforweak.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.hbue.communityforweak.entry.Activity;
import com.hbue.communityforweak.entry.Server;

public interface Serverdao extends JpaRepository<Server, Long>,JpaSpecificationExecutor<Server> {
	
	// 服务列表 √
	Iterable<Server> findByActive(int active);
	
	// 查找筛选后的服务  √
	Iterable<Server> findByClassifyAndActive(String classify, int active);

	// 查找用户参加过的服务 √
	@Query(value="select * from server where server.id in (select serverid from server_partake where userid = ?1)",nativeQuery=true)
	Iterable<Server> getUserServerlist(String userid);
	
	// 用户正在申请或未通过申请的服务数量
	@Query(value="select count(*) from `server` where userid = ?1 and (active = '1' or active = '0') group by userid", nativeQuery=true)
	int existServer(String userid);
	
	/* ------------manager-----------*/
	
	// 查找用户申请的服务
	Iterable<Server> findByUserid(String userid);
}
