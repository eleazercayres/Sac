package com.olx.sac.sacwebbff.service;

import java.util.List;

import com.olx.sac.sacserviceapi.attendance.AttendanceDTO;
import com.olx.sac.sacserviceapi.attendance.CallDTO;
import com.olx.sac.sacwebbff.exception.CallServiceException;

public interface AttendanceService {

	public List<CallDTO> findAll() throws CallServiceException;
	
	public List<CallDTO> findCallGroupByCareDayAndUfOrderByCareDayDesc() throws CallServiceException;

	public List<String> findAllReasonCalleds() throws CallServiceException;

	public List<String> findAllTypeOfCalls() throws CallServiceException;

	void insertCall(AttendanceDTO callDTO) throws CallServiceException;
}
