package com.olx.sac.sacservice.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olx.sac.sacservice.entity.State;
import com.olx.sac.sacservice.exception.CallServiceException;
import com.olx.sac.sacservice.repository.StateRepository;
import com.olx.sac.sacservice.service.StateService;
import com.olx.sac.sacserviceapi.attendance.StateDTO;

@Service
public class StateServiceImpl implements StateService {

	@Autowired
	private StateRepository stateRepository;
	
	private ModelMapper modelMapper;
	
	@Override
	public StateDTO findOnByUf(String uf) throws CallServiceException {
		
		StateDTO stateDTO = null;
		
		try {
			modelMapper = new ModelMapper();
			State state= stateRepository.findOneByUf(uf);
			stateDTO = modelMapper.map(state, StateDTO.class);
		} catch (Exception e) {
			throw new CallServiceException(e);
		}		
		return stateDTO;
	}
}
