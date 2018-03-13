package com.hbue.communityforweak.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hbue.communityforweak.entry.Service_partake;

public interface Service_partakeRepository extends JpaRepository<Service_partake, Long>{
	Iterable<Service_partake> findByUserid(String userid);
}
