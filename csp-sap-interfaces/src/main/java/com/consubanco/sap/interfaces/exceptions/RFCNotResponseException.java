package com.consubanco.sap.interfaces.exceptions;

public class RFCNotResponseException extends Exception {



	/**
	 * 
	 */
	private static final long serialVersionUID = -1103868386106888387L;

	public RFCNotResponseException() {
		super();
	}

	public RFCNotResponseException(String message) {
		super(message);
	}

	public RFCNotResponseException(String message, Throwable cause) {
		super(message, cause);
	}

	public RFCNotResponseException(Throwable cause) {
		super(cause);
	}
}
