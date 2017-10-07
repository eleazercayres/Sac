package com.olx.sac.sacservice.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.olx.sac.sacservice.entity.Call;
import com.olx.sac.sacservice.exception.CallServiceException;
import com.olx.sac.sacservice.repository.CallRepository;
import com.olx.sac.sacservice.service.AttendanceService;
import com.olx.sac.sacserviceapi.attendance.CallDTO;

@Service
public class AttendanceServiceImpl implements AttendanceService {
	
	@Autowired
	private CallRepository callRepository;
	
    private ModelMapper modelMapper;

    /**
     * List All calls with group by careDay and UF and order by careDay Desc
     */
	@Override
	public List<CallDTO> findCallGroupByCareDayAndUfOrderByCareDayDesc() throws CallServiceException {

		List<CallDTO> callsDTO = null;
		
		try {
			callsDTO = callRepository.findCallGroupByCareDayAndUfOrderByCareDayDesc();
		} catch (Exception e) {
			throw new CallServiceException(e);
		}		
		return callsDTO;
	}

	/**
	 * Insert a new Call
	 */
	@Override
	@Async("workExecutor")
	public void insertCall(CallDTO callDTO) throws CallServiceException {
		
		try {
			modelMapper = new ModelMapper();
			Call call = modelMapper.map(callDTO, Call.class);
			callRepository.save(call);
			
		} catch (Exception e) {
			throw new CallServiceException(e);
		}	
	}

}