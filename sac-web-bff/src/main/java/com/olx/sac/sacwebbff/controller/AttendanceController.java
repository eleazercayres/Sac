package com.olx.sac.sacwebbff.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.olx.sac.sacservice.exception.CallServiceException;
import com.olx.sac.sacservice.service.AttendanceService;
import com.olx.sac.sacserviceapi.attendance.CallDTO;

@RestController
@RequestMapping("/olx/")
public class AttendanceController {
	
	@Autowired
	private AttendanceService attendanceService; 

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
	public void insert(@RequestParam("call") CallDTO call) throws CallServiceException {

		try {

			call.setCareDay(new Date());
			attendanceService.insertCall(call);
			
		} catch (CallServiceException e) {
			throw new CallServiceException("Error in service insert call", e);
		}
	}
}
