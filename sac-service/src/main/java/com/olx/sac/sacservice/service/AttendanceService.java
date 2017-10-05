package com.olx.sac.sacservice.service;

import java.util.List;

import org.springframework.web.bind.annotation.ResponseBody;

import com.olx.sac.sacserviceapi.attendance.CallDTO;

public interface AttendanceService {

	public @ResponseBody List<CallDTO> findAllAttendances() throws Exception;
}
