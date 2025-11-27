/**
 * 
 */
package com.consupago.sap.interfaces.proxy.cdb;

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
public class ZRFC_ORIG_TOTMENS_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZRFC_ORIG_TOTMENS_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZRFC_ORIG_TOTMENS_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZRFC_ORIG_TOTMENS_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZRFC_ORIG_TOTMENS_ProxyImpl proxy = new ZRFC_ORIG_TOTMENS_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_CONVENIO");
        input.setValue( "10000027" );
        inputParams.add( input );
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
