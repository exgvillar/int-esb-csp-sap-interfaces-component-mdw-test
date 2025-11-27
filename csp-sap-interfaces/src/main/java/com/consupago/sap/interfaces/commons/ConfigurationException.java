package com.consupago.sap.interfaces.commons;


/**
 * TODO document this class/interface
 */
public class ConfigurationException extends ServiceException {
	/** serial version UID */
	private static final long serialVersionUID = 7285610092532236516L;

	/**
	 * TODO document this constructor
	 * 
	 */
	public ConfigurationException() { super(); }

	/**
	 * TODO document this constructor
	 * @param message
	 */
	public ConfigurationException( String message ) { super( message ); }

	/**
	 * TODO document this constructor
	 * @param cause
	 */
	public ConfigurationException( Throwable cause ) { super( cause ); }

	/**
	 * TODO document this constructor
	 * @param message
	 * @param cause
	 */
	public ConfigurationException( String message, Throwable cause ) { super( message, cause ); }
}
