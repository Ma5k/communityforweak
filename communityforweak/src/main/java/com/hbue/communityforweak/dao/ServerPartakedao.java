package com.hbue.communityforweak.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hbue.communityforweak.entry.Serverpartake;

public interface ServerPartakedao extends JpaRepository<Serverpartake, Long>{

	@Query(value="select user.userid, user.username, server_partake.flag "
			+ "from user join server_partake on user.userid = server_partake.userid "
			+ "where server_partake.serverid = ?1",nativeQuery=true)
	List<Object[]> getAllUser(String serverid);
	
}

