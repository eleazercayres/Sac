package com.olx.sac.sacservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.olx.sac.sacservice.entity.State;

@Repository
public interface StateRepository  extends JpaRepository<State, Long> {

	public State findOneByUf(String uf);
}
