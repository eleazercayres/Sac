package com.olx.sac.sacwebbff.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olx.sac.sacserviceapi.attendance.StateDTO;
import com.olx.sac.sacwebbff.entity.State;
import com.olx.sac.sacwebbff.exception.CallServiceException;
import com.olx.sac.sacwebbff.repository.StateRepository;
import com.olx.sac.sacwebbff.service.StateService;


@Service
public class StateServiceImpl implements StateService {

	@Autowired
	private StateRepository stateRepository;
	
	private ModelMapper modelMapper;
	
	@Override
	public List<StateDTO> findAll() throws CallServiceException {
		
		List<StateDTO> statesDTO = null;
		
		try {
			modelMapper = new ModelMapper();
			List<State> states= stateRepository.findAll();
			if (CollectionUtils.isNotEmpty(states)) {
				statesDTO = new ArrayList<StateDTO>();
				for (State state : states) {
					if (state != null) {
						statesDTO.add(modelMapper.map(state, StateDTO.class));
					}
				}
			}
		} catch (Exception e) {
			throw new CallServiceException(e);
		}		
		return statesDTO;
	}
}
