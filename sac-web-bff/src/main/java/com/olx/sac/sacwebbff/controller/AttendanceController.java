package com.olx.sac.sacwebbff.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.olx.sac.sacserviceapi.attendance.AttendanceDTO;
import com.olx.sac.sacserviceapi.attendance.CallDTO;
import com.olx.sac.sacwebbff.exception.CallServiceException;
import com.olx.sac.sacwebbff.service.AttendanceService;

@RestController
@RequestMapping("/olx/")
public class AttendanceController {
	
	@Autowired
	private AttendanceService attendanceService; 

	@RequestMapping(value="/reasonCalled", method=RequestMethod.GET)
	public @ResponseBody List<String> findAllReasonCalled() throws CallServiceException {

		List<String> result;

		try {

			result = attendanceService.findAllReasonCalleds();
			
		} catch (CallServiceException e) {
			throw new CallServiceException("Error in service findall attendances", e);
		}

		return result;
	}
	
	@RequestMapping(value="/typeCalled", method=RequestMethod.GET)
	public @ResponseBody List<String> findAllTypeOfCalls() throws CallServiceException {

		List<String> result;

		try {

			result = attendanceService.findAllTypeOfCalls();
			
		} catch (CallServiceException e) {
			throw new CallServiceException("Error in service findall attendances", e);
		}

		return result;
	}
	
	@RequestMapping(value="/attendances", method=RequestMethod.GET)
	public @ResponseBody List<CallDTO> listAttendances() throws CallServiceException {

		List<CallDTO> result;

		try {

			result = attendanceService.findCallGroupByCareDayAndUfOrderByCareDayDesc();
			
		} catch (CallServiceException e) {
			throw new CallServiceException("Error in service findall attendances", e);
		}

		return result;
	}
	
	@RequestMapping(value="/attendances", method=RequestMethod.POST)
	public ResponseEntity<AttendanceDTO> insert(@RequestBody AttendanceDTO call) throws CallServiceException {
		
		try {

			attendanceService.insertCall(call);
			
		} catch (CallServiceException e) {
			throw new CallServiceException("Error in service insert call", e);
		}
		return new ResponseEntity<AttendanceDTO>(call, HttpStatus.OK);
	}
	
}

