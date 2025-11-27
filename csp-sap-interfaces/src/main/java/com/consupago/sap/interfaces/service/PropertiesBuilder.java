package com.consupago.sap.interfaces.service;

import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang.NullArgumentException;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * Properties Builder.
 */
class PropertiesBuilder {
	/** class logger */
	private static final Log log = LogFactory.getLog( PropertiesBuilder.class );

	/**
	 * Constructor.
	 */
	public PropertiesBuilder() {
		super();
		log.trace( "initializing PropertiesBuilder instance" );
	}

	static Properties filterProperties( Map config, String pattern ) {
		if( config == null ) throw new NullArgumentException( "config" );
		pattern = StringUtils.trimToNull( pattern );
		if( pattern == null ) throw new NullArgumentException( "pattern" );

		Properties properties = new Properties();
		Iterator iter = config.entrySet().iterator();
		Map.Entry entry = null;
		String key = null, value = null;
		while( iter.hasNext() ) {
			entry = (Map.Entry)iter.next();
			if( entry.getKey() instanceof String ) {
				key = (String)entry.getKey();
				if( key.startsWith( pattern ) ) {
					value = (String)entry.getValue();
					properties.put( key, value );
				}
			}
		}

		// ok
		return properties;
	}
}
