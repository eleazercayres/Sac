package com.olx.sac.sacwebbff.exception;

import org.springframework.stereotype.Controller;

@Controller
public class AttendanceControllerException extends Exception {
	
	private static final long serialVersionUID = 7187086265192602256L;

	private static String message;
	
	public AttendanceControllerException() {}
	
	public AttendanceControllerException(Throwable throwable){
		super(message, throwable);
	}

	public void setMessage(String message) {
		AttendanceControllerException.message = message;
	}
}
