package com.consubanco.sap.interfaces.exceptions;

public class RFCExecutionException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7377010382097160577L;

	public RFCExecutionException() {
		super();
	}

	public RFCExecutionException(String message) {
		super(message);
	}

	public RFCExecutionException(String message, Throwable cause) {
		super(message, cause);
	}

	public RFCExecutionException(Throwable cause) {
		super(cause);
	}
}
