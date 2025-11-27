/**
 * 
 */
package com.consubanco.sap.interfaces.dwh.origination;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author haydee.sanchez
 *
 */
public class ZRFC_GEN_GET_DATSOL_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZRFC_GEN_GET_DATSOL_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZRFC_GEN_GET_DATSOL_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZRFC_GEN_GET_DATSOL_ProxyImplTC(String name) {
		super(name);
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZRFC_GEN_GET_DATSOL_ProxyImpl proxy = new ZRFC_GEN_GET_DATSOL_ProxyImpl();
        
        ArrayList<ZRFC_GEN_GET_DATSOL_InputData> inputParams = new ArrayList<ZRFC_GEN_GET_DATSOL_InputData>();
        ZRFC_GEN_GET_DATSOL_InputData input = new ZRFC_GEN_GET_DATSOL_InputData();
        input.setRequestId("0050096281");        
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
