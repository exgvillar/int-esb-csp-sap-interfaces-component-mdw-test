package com.consubanco.sap.interfaces.exceptions;

public class ComponentException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9108732343821919113L;

	public ComponentException() {
		super();
	}

	public ComponentException(String message) {
		super(message);
	}

	public ComponentException(String message, Throwable cause) {
		super(message, cause);
	}

	public ComponentException(Throwable cause) {
		super(cause);
	}
}
