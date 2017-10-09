package com.olx.sac.sacwebbff.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.olx.sac.sacserviceapi.attendance.CallDTO;
import com.olx.sac.sacwebbff.entity.Call;

@Repository
public interface CallRepository  extends JpaRepository<Call, Long> {
	public List<Call> findAll();

	@Query(value="SELECT new com.olx.sac.sacserviceapi.attendance.CallDTO(c.careDay, c.details, c.reasonCalled, c.typeOfCall, s.nome, s.uf) "
			+ "from Call c, State s "
			+ "where c.uf.idState = s.idState "
			+ "group by s.uf, c.careDay "
			+ "order by s.uf, c.careDay DESC")
	List<CallDTO> findCallGroupByCareDayAndUfOrderByCareDayDesc();


}
