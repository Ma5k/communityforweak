package com.hbue.communityforweak.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hbue.communityforweak.entry.Serving;

public interface ServingRepository extends JpaRepository<Serving, Long> {
	Iterable<Serving> findByClassify(String classify);
	
	Iterable<Serving> findByServicename(String servicename);
	
	Serving findById(int id);
	
	Iterable<Serving> findByUserid(String userid);
	
	Iterable<Serving> findByActive(int active);
	
	//查找某用户参与的所有服务
	@Query(value="select * from serving where serving.id in \r\n" + 
			"(select serviceid from service_partake where userid = ?1)", nativeQuery = true)
	Iterable<Serving> findByParticipantid(String parid);
}
