/**
 * 
 */
package com.consupago.sap.interfaces.proxy.netcash;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author ramon.becerra
 *
 */
public class ZRFC_DESCARGA_NETCASH_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZRFC_DESCARGA_NETCASH_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZRFC_DESCARGA_NETCASH_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZRFC_DESCARGA_NETCASH_ProxyImplTC(String name) {
		super(name);
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZRFC_DESCARGA_NETCASH_ProxyImpl proxy = new ZRFC_DESCARGA_NETCASH_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_FOLDER");
        input.setValue( "501035162814" );
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.size() );
        log.info( returnData.toString() );
        
        
	}
}
