package com.olx.sac.sacwebbff.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


/**
* REST exception handlers defined at a global level for the application
**/
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RestResponseEntityExceptionHandler.class);
	
	@ExceptionHandler(value = { AttendanceControllerException.class })
	protected ResponseEntity<Object> handleUnknownException(AttendanceControllerException ex) {
		LOGGER.error(ex.getMessage() + ex);
		return new ResponseEntity<Object>(ex.getMessage(), new HttpHeaders(), HttpStatus.EXPECTATION_FAILED);
	}
	
	@ExceptionHandler(value = { CallServiceException.class })
	protected ResponseEntity<Object> handleCallServiceException(CallServiceException ex) {
		LOGGER.error(ex.getMessage() + ex);
		return new ResponseEntity<Object>(ex.getMessage(), new HttpHeaders(), HttpStatus.EXPECTATION_FAILED);
	}
 
}