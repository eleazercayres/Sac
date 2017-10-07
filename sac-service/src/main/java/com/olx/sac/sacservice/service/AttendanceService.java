package com.olx.sac.sacservice.service;

import java.util.List;

import com.olx.sac.sacservice.exception.CallServiceException;
import com.olx.sac.sacserviceapi.attendance.CallDTO;

public interface AttendanceService {

	public List<CallDTO> findCallGroupByCareDayAndUfOrderByCareDayDesc() throws CallServiceException;

	public void insertCall(CallDTO call) throws CallServiceException;
}
