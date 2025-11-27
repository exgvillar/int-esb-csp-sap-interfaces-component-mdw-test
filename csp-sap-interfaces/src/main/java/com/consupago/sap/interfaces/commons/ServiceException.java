package com.consupago.sap.interfaces.commons;


/**
 * TODO document this class/interface
 */
public class ServiceException extends Exception {
	/** serial version UID */
	private static final long serialVersionUID = -3745218320700722673L;

	/** the exception that caused this one to be thrown */
	private Throwable cause = null;

	/**
	 * TODO document this constructor
	 * 
	 */
	public ServiceException() {
		super();
	}

	/**
	 * TODO document this constructor
	 * @param message
	 */
	public ServiceException( String message ) {
		super( message );
	}

	/**
	 * TODO document this constructor
	 * @param cause
	 */
	public ServiceException( Throwable cause ) {
		super( cause.getMessage() );
		this.cause = cause;
	}

	/**
	 * TODO document this constructor
	 * @param message
	 * @param cause
	 */
	public ServiceException( String message, Throwable cause ) {
		super( message );
		this.cause = cause;
	}

    /**
     * Returns the cause of this throwable or <code>null</code> if the
     * cause is nonexistent or unknown.  (The cause is the throwable that
     * caused this throwable to get thrown.)
     *
     * @return  the cause of this throwable or <code>null</code> if the
     *          cause is nonexistent or unknown.
     */
    public Throwable getCause() {
        return cause;
    }
}
