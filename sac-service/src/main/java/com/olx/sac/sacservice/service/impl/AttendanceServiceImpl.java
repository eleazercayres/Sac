package com.olx.sac.sacservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olx.sac.sacservice.entity.Call;
import com.olx.sac.sacservice.repository.CallRepository;
import com.olx.sac.sacservice.service.AttendanceService;
import com.olx.sac.sacserviceapi.attendance.CallDTO;

@Service
public class AttendanceServiceImpl implements AttendanceService {
	
	@Autowired
	private CallRepository callRepository;

	@Override
	public List<CallDTO> findAllAttendances() throws Exception {

		List<Call> calls;
		
		try {
			calls = callRepository.findAllCall();
			
		} catch (Exception e) {
			throw new CallServiceException(e);
		}
		
		return calls;
	}

}
