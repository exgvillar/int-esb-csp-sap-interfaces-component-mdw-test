/**
 * 
 */
package com.consubanco.sap.interfaces.commons;

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
 * @author haydee.sanchez
 *
 */
public class ZCRMORI_E001_CATGENER_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMORI_E001_CATGENER_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMORI_E001_CATGENER_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMORI_E001_CATGENER_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMORI_E001_CATGENER_ProxyImpl proxy = new ZCRMORI_E001_CATGENER_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_IDCAT");
        input.setValue( "21" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_IDPARENTKEY");
        input.setValue( "MX" );
        inputParams.add( input );
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
