package com.hbue.communityforweak.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hbue.communityforweak.entry.Activity_partake;

public interface Activity_partakeRepository extends JpaRepository<Activity_partake, Long>{
	Iterable<Activity_partake> findByUserid(String userid);
}
