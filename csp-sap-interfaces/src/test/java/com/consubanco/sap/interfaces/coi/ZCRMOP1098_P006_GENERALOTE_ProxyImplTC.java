/**
 * 
 */
package com.consubanco.sap.interfaces.coi;

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
public class ZCRMOP1098_P006_GENERALOTE_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMOP1098_P006_GENERALOTE_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMOP1098_P006_GENERALOTE_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMOP1098_P006_GENERALOTE_ProxyImplTC(String name) {
		super(name);
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMOP1098_P006_GENERALOTE_ProxyImpl proxy = new ZCRMOP1098_P006_GENERALOTE_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_BP");
        input.setValue( "0010004865" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_CREA");
        input.setValue( "X" );
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
