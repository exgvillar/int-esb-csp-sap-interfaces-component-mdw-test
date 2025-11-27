/**
 * 
 */
package com.consubanco.sap.interfaces.bpm.queues.generals;

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
public class ZCRMWKQUE_E017_GET_PRIORITY_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMWKQUE_E017_GET_PRIORITY_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMWKQUE_E017_GET_PRIORITY_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMWKQUE_E017_GET_PRIORITY_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMWKQUE_E017_GET_PRIORITY_ProxyImpl proxy = new ZCRMWKQUE_E017_GET_PRIORITY_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_ROL");
        input.setValue( "CAPTURA" ); 
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("I_PRIORITY");
        input.setValue( "" ); //1
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("I_DESC_PRIORITY");
        input.setValue( "MUY_ALTA" ); // MUY_ALTA
        inputParams.add( input );
                        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
       
        log.info( "Resurn Data :: " + returnData.toString() );
        
	}
}
