package com.olx.sac.sacservice.service;

import com.olx.sac.sacservice.exception.CallServiceException;
import com.olx.sac.sacserviceapi.attendance.StateDTO;

public interface StateService {

	public StateDTO findOnByUf(String uf) throws CallServiceException;
}
