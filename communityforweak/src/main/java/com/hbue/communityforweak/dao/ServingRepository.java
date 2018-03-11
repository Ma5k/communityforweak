package com.hbue.communityforweak.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hbue.communityforweak.entry.Serving;

public interface ServingRepository extends JpaRepository<Serving, Long> {
	Iterable<Serving> findByClassify(String classify);
}
