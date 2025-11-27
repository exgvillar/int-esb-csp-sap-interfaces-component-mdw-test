
package com.consupago.sap.interfaces.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.consupago.sap.interfaces.commons.ConfigurationException;
import com.consupago.sap.interfaces.commons.Service;
import com.consupago.sap.interfaces.commons.ServiceException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoRepository;
import com.sap.conn.jco.JCo;


/**
 * TODO document this class/interface
 */
public class SAPClientService extends Service {
	/** class logger */
	private static final Log log = LogFactory.getLog( SAPClientService.class );

	/** the singleton instance */
	private static SAPClientService singleton = null;

	/** configuration data */
	private Map config = null;

	/** SAP clint pool name */
	private String poolName = null;

	/** JCO function definition repository */
	private JCoRepository repository = null;

	/** current clients per thread */
	private ThreadLocal clients = null;

	/**
	 * Initializes a new instance of <code>SAPClientService</code> with the given name.
	 *
	 * @param  name  the name for the new instance
	 */
	public SAPClientService( String name ) {
		super( name );
		clients = new ThreadLocal();
	}

	/* (non-Javadoc)
	 * @see com.nissan.adapter.service.Service#config(java.lang.Object)
	 */
	public void config( Object newConfig ) throws ConfigurationException {
		if( newConfig == null ) throw new ConfigurationException( "newConfig == null" );
		if( newConfig instanceof Map ) {
			if( config != null ) throw new ConfigurationException( "service already configured" );
			config = new HashMap();
			config.putAll( (Map)newConfig );
			debugConfig( log, config );
			state = Service.STATE_READY;
		} else throw new ConfigurationException( "newConfig not an instance of java.util.Map" );
	}

	/* (non-Javadoc)
	 * @see com.nissan.adapter.service.Service#start()
	 */
	public void start() throws ServiceException {
//		if( state == Service.STATE_RUNNING ) {
//			log.warn( "service already started :: " + getName() );
//			return;
//		}
//		String configValue = null;
//		String serverEnv = null;
//		int instances = 0;
//		try {
//			configValue = (String)config.get( "sap-clients" );
//			instances = Integer.parseInt( configValue );
//		} catch( NumberFormatException ex ) {
//			log.error( "illegal 'sap-clients' value :: " + configValue );
//		}
//		serverEnv = (String)config.get( "server-environment" );
//		if( instances > 0 ) {
//			Properties props = PropertiesBuilder.filterProperties( config, "jco.client." );
//			poolName = SAPServer.CLIENT_POOL + "_" + serverEnv;
//			JCO.addClientPool( poolName, instances, props );
//			repository = JCO.createRepository( SAPServer.CLIENT_REPOSITORY, poolName );
//		} else log.warn( "no SAP clients will be started" );
//		singleton = this;
//		state = Service.STATE_RUNNING;
	}

	/* (non-Javadoc)
	 * @see com.nissan.adapter.service.Service#stop()
	 */
	public void stop() throws ServiceException {
//		if( (state == Service.STATE_STOPPED) || (state == Service.STATE_READY) ) {
//			log.warn( "service already stopped :: " + getName() );
//			return;
//		}
//		if( state != Service.STATE_RUNNING ) throw new IllegalStateException( "state != Service.STATE_RUNNING" );
//		repository = null;
//		JCO.removeClientPool( poolName );
//		singleton = null;
//		state = Service.STATE_READY;
	}

	/**
	 * TODO  document this method
	 *
	 * @return
	 */
	public static SAPClientService getInstance() {
		return singleton;
	}

	/**
	 * TODO  document this method
	 *
	 * @return
	 */
	public JCoRepository getRepository() {
		return repository;
	}

	public JCoDestination acquireClient() {
		JCoDestination destination = null;
//		client = (JCO.Client)clients.get();
//		if( client == null ) {
//			client = JCO.getClient( poolName );
//			clients.set( client );
//		}
		return destination;
	}

	public void releaseClient() {
//		JCO.Client client = (JCO.Client)clients.get();
//		if( client != null ) {
//			JCO.releaseClient( client );
//			clients.set( null );
//		}
	}
}
