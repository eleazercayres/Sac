package com.olx.sac.sacwebbff.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.olx.sac.sacserviceapi.attendance.StateDTO;
import com.olx.sac.sacwebbff.exception.CallServiceException;
import com.olx.sac.sacwebbff.service.StateService;

@RestController
@RequestMapping("/olx/")
public class StateController {
	
	@Autowired
	private StateService stateService; 

	@Cacheable("States")
	@RequestMapping(value="/states", method=RequestMethod.GET)
	public @ResponseBody List<StateDTO> findAllState() throws CallServiceException {

		List<StateDTO> result;

		try {

			result = stateService.findAll();
			
		} catch (CallServiceException e) {
			throw new CallServiceException("Error in findall states", e);
		}

		return result;
	}
	
}