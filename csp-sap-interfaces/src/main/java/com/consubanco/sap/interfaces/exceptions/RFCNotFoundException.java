package com.consubanco.sap.interfaces.exceptions;

public class RFCNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 712074305398960289L;
	
	public RFCNotFoundException() {
		super();
	}

	public RFCNotFoundException(String message) {
		super(message);
	}

	public RFCNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public RFCNotFoundException(Throwable cause) {
		super(cause);
	}

}
