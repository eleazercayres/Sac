package com.olx.sac.sacwebbff.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.olx.sac.sacwebbff.entity.State;

@Repository
public interface StateRepository  extends JpaRepository<State, Long> {

	public State findOneByUf(String uf);
	
	public List<State> findAll();
}
