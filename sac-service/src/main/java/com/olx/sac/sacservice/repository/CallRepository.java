package com.olx.sac.sacservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.olx.sac.sacservice.entity.Call;

@Repository
public interface CallRepository  extends JpaRepository<Call, Long> {
	
	public List<Call> findAllCall();

}
