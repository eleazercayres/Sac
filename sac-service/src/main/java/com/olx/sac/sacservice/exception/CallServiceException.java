package com.olx.sac.sacservice.exception;

public class CallServiceException extends RuntimeException {

	private static final long serialVersionUID = 8773191967482658010L;
	
	public CallServiceException(Throwable error) {
		super(error);
	}
	
	public CallServiceException(String message, Throwable error) {
		super(message, error);
	}

	public CallServiceException(String message) {
		super(message);
	}
	
	
}
