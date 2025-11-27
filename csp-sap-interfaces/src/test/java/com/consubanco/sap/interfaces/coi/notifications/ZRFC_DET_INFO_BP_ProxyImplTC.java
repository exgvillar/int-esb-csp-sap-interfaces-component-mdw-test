/**
 * 
 */
package com.consubanco.sap.interfaces.coi.notifications;

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
public class ZRFC_DET_INFO_BP_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZRFC_DET_INFO_BP_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZRFC_DET_INFO_BP_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZRFC_DET_INFO_BP_ProxyImplTC(String name) {
		super(name);
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZRFC_DET_INFO_BP_ProxyImpl proxy = new ZRFC_DET_INFO_BP_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("ZID_PARTNER");
        input.setValue( "4393033" );
        inputParams.add( input );
        
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
