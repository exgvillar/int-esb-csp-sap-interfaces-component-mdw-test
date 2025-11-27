package com.consubanco.sap.interfaces.activeBranch.exceptions;

public class RFCExecutionException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8486605883803325478L;

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
