package com.hbue.communityforweak.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hbue.communityforweak.entry.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	Iterable<User> findByUsername(String username);
	
	User findByUserid(String userid);
	
	Iterable<User> findByAddress(String address);
	
	Iterable<User> findByPermission(Byte permission);
	
	User findByIdcard(String idcard);
	
	//某服务下所有参与用户
	@Query(value="select * from user where user.userid in(\r\n" + 
			"select userid from service_partake s_p where s_p.serviceid = ?1)", nativeQuery = true)
	Iterable<User> findByServiceid(int serid);
	
	//某活动下的所有用户
	@Query(value="select * from user where user.userid in \r\n" + 
			"(select userid from activity_partake a_p where a_p.activityid = ?1)",nativeQuery=true)
	Iterable<User> findByAcitvityid(int actid);
}
