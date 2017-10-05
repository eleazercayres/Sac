package com.olx.sac.sacwebbff.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.olx.sac.sacservice.service.AttendanceService;
import com.olx.sac.sacserviceapi.attendance.CallDTO;

@RestController
@RequestMapping("/olx/")
public class AttendanceController {
	
	@Autowired
	private AttendanceService attendanceService; 

	@RequestMapping(value="/attendances", method=RequestMethod.GET)
	public @ResponseBody List<String> listAttendances() throws Exception {

		List<String> lastSent = null;

		try {

			List<CallDTO> result = attendanceService.findAllAttendances();
			//logic
			
		} catch (Exception e) {
			throw new Exception(e);
		}

		return lastSent;
	}
}
