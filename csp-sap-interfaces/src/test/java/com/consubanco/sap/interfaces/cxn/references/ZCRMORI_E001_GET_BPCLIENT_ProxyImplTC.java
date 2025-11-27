/**
 * 
 */
package com.consubanco.sap.interfaces.cxn.references;

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
public class ZCRMORI_E001_GET_BPCLIENT_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMORI_E001_GET_BPCLIENT_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMORI_E001_GET_BPCLIENT_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMORI_E001_GET_BPCLIENT_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMORI_E001_GET_BPCLIENT_ProxyImpl proxy = new ZCRMORI_E001_GET_BPCLIENT_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_BPREFERE");
        input.setValue( "0000419123" );
        inputParams.add( input );
       
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
