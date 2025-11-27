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
public class ZCRMWKQUE_E015_DATA_SOL_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMWKQUE_E015_DATA_SOL_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMWKQUE_E015_DATA_SOL_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMWKQUE_E015_DATA_SOL_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMWKQUE_E015_DATA_SOL_ProxyImpl proxy = new ZCRMWKQUE_E015_DATA_SOL_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_SOLICITUD");
        input.setValue( "0050627864" ); 
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
       
        log.info( "Resurn Data :: " + returnData.toString() );
        
	}
}
