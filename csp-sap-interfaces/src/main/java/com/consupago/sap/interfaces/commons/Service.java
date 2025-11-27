package com.consupago.sap.interfaces.commons;

import java.util.Iterator;
import java.util.Map;

import org.apache.commons.logging.Log;


/**
 * TODO document this class/interface
 */
public abstract class Service {
	/** state that represents that this service has not been initialized */
	public static final int STATE_UNINITIALIZED = 0;

	/** state that represents that this service is ready to start */
	public static final int STATE_READY = 1;

	/** state that represents that this service is running */
	public static final int STATE_RUNNING = 2;

	/** state that represents that this service is stopped */
	public static final int STATE_STOPPED = 3;

	/** state that represents that this service is stopped */
	public static final int STATE_PAUSSED = 4;

	/** this service's name */
	private String name = null;

	/** current service's state */
	protected int state = Service.STATE_UNINITIALIZED;

	/**
	 * Initializes this service's name.
	 *
	 * @param  name  the name for this service
	 */
	protected Service( String name ) {
		if( name == null ) throw new NullPointerException( "name == null" );
		name = name.trim();
		if( name.length() == 0 ) throw new NullPointerException( "name == \"\"" );
		this.name = name;
	}

	/**
	 * Returns this service's name.
	 *
	 * @return  the name of this service
	 */
	public String getName() { return name; }

	/**
	 * Returns the current state of this service.
	 *
	 * @return  the current state of this service
	 */
	public int getState() { return state; }

	/**
	 * Initializes this service with the given configuration object.
	 *
	 * @param  config  the configuration object used to configure
	 *     this service instance
	 *
	 * @throws  ConfigurationException  if something goes wrong
	 */
	public abstract void config( Object config ) throws ConfigurationException;

	/**
	 * Starts this service.
	 *
	 * @throws ServiceException  if something goes wrong
	 */
	public abstract void start() throws ServiceException;

	/**
	 * Stops this service as soon as posible.
	 *
	 * @throws ServiceException  if something goes wrong
	 */
	public abstract void stop() throws ServiceException;

	/**
	 * Prints all configuration properties that has been passed to
	 * this <code>Service</code> subclass.
	 *
	 * @param  log  the logger to use to write out configuration
	 * @param  config  the configuration data
	 */
	protected void debugConfig( Log log, Map config ) {
		String value = null;
		if( log.isDebugEnabled() ) {
			StringBuffer buffer = new StringBuffer();
			buffer.append( "initializing service :: " ).append( getName() );
			log.debug( buffer.toString() );
			Iterator iter = config.keySet().iterator();
			while( iter.hasNext() ) {
				value = (String)iter.next();
				buffer.setLength( 0 );
				buffer.append( "  " ).append( value ).append( " :: " );
				buffer.append( config.get( value ) );
				log.debug( buffer.toString() );
			}
		}
	}
}
