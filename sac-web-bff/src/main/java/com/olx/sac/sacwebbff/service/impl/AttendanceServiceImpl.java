package com.olx.sac.sacwebbff.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.olx.sac.sacserviceapi.attendance.AttendanceDTO;
import com.olx.sac.sacserviceapi.attendance.CallDTO;
import com.olx.sac.sacserviceapi.constants.ReasonCalled;
import com.olx.sac.sacserviceapi.constants.TypeOfCall;
import com.olx.sac.sacwebbff.entity.Call;
import com.olx.sac.sacwebbff.entity.State;
import com.olx.sac.sacwebbff.exception.CallServiceException;
import com.olx.sac.sacwebbff.repository.CallRepository;
import com.olx.sac.sacwebbff.service.AttendanceService;

@Service
public class AttendanceServiceImpl implements AttendanceService {
	
	private static final String FORMAT_DATE = "dd/MM/yyyy HH:mm:ss";
	
	@Autowired
	private CallRepository callRepository;
	
	private ModelMapper modelMapper;
	
    /**
     * List All calls with group by careDay and UF and order by careDay Desc
     */
	@Override
	public List<CallDTO> findCallGroupByCareDayAndUfOrderByCareDayDesc() throws CallServiceException {

		List<CallDTO> callsDTO = null;
		
		SimpleDateFormat fmt = new SimpleDateFormat(FORMAT_DATE);    
		
		try {
			callsDTO = callRepository.findCallGroupByCareDayAndUfOrderByCareDayDesc();
			for (CallDTO callDTO : callsDTO) {
				callDTO.setDateFormat(fmt.format(callDTO.getCareDay())); 
			}
		} catch (Exception e) {
			throw new CallServiceException(e);
		}		
		return callsDTO;
	}
	
    /**
     * List All calls
     */
	@Override
	public List<CallDTO> findAll() throws CallServiceException {

		List<Call> calls = null;
		List<CallDTO> callsDTO = null;
		
		try {
			calls = callRepository.findAll();
			if (CollectionUtils.isNotEmpty(calls)) {
				modelMapper = new ModelMapper();
				callsDTO = new ArrayList<>();
				for (Call call : calls) {
					callsDTO.add(modelMapper.map(call, CallDTO.class));
				}
			}
		} catch (Exception e) {
			throw new CallServiceException(e);
		}		
		return callsDTO;
	}

	/**
	 * Insert a new Call
	 */
	@Override
	@Transactional
	public void insertCall(AttendanceDTO callDTO) throws CallServiceException {
		
		try {
			Call call = parseCallDTOToCall(callDTO);
			
			callRepository.save(call);
			
		} catch (Exception e) {
			throw new CallServiceException(e);
		}	
	}

	/**
	 * Parse CallDTO to Call for persist 
	 * @param callDTO
	 * @return
	 */
	private Call parseCallDTOToCall(AttendanceDTO callDTO) {
		
		State state = new State();
		state.setIdState(Integer.valueOf(callDTO.getState()));
		Call call = new Call();
		
		call.setUf(state);
		call.setCareDay(callDTO.getDate());
		call.setReasonCalled(ReasonCalled.fromString(callDTO.getReason()));
		call.setTypeOfCall(TypeOfCall.fromString(callDTO.getType()));
		call.setDetails(callDTO.getDetalhes());
		return call;
	}
	
	/**
	 * List All Reasons
	 */
	@Override
	@Cacheable("Reasons")
	public List<String> findAllReasonCalleds() throws CallServiceException {
		
		List<String> reasons = new ArrayList<>();
		for (ReasonCalled d : ReasonCalled.values()) {
			reasons.add(d.getValue());
		 }
		
		return reasons;
	}
	
	/**
	 * List all Type of call
	 */
	@Override
	@Cacheable("Types")
	public List<String> findAllTypeOfCalls() throws CallServiceException {
		
		List<String> reasons = new ArrayList<>();
		for (TypeOfCall d : TypeOfCall.values()) {
			reasons.add(d.getValue());
		 }
		
		return reasons;
	}
	
}