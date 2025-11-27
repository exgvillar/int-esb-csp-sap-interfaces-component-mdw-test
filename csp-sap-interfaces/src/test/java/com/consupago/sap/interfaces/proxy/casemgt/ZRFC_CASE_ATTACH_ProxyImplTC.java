/**
 * 
 */
package com.consupago.sap.interfaces.proxy.casemgt;

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
public class ZRFC_CASE_ATTACH_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZRFC_CASE_ATTACH_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZRFC_CASE_ATTACH_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZRFC_CASE_ATTACH_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZRFC_CASE_ATTACH_ProxyImpl proxy = new ZRFC_CASE_ATTACH_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_CASE");
        input.setValue( "000000035418" );
        inputParams.add( input );
        
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
