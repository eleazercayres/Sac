package com.olx.sac.sacservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.olx.sac.sacservice.entity.Call;
import com.olx.sac.sacserviceapi.attendance.CallDTO;

@Repository
public interface CallRepository  extends JpaRepository<Call, Long> {
	public List<Call> findAll();

	@Query(value="SELECT new com.olx.sac.sacserviceapi.attendance.CallDTO(c.phone, c.details, s.nome, c.careDay, c.typeOfCall, c.reasonCalled) "
			+ "from Call c, State s "
			+ "where c.uf.idState = s.idState "
			+ "group by c.careDay, c.uf.nome, c.details, c.typeOfCall, c.reasonCalled "
			+ "order by c.careDay DESC")
	List<CallDTO> findCallGroupByCareDayAndUfOrderByCareDayDesc();


}
