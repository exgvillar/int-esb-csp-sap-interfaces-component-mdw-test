/**
 * 
 */
package com.consubanco.sap.interfaces.bpm.queues.mantto;

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
public class ZCRMWKQUE_E006_GET_TIMEATNCOX_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMWKQUE_E006_GET_TIMEATNCOX_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMWKQUE_E006_GET_TIMEATNCOX_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMWKQUE_E006_GET_TIMEATNCOX_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMWKQUE_E006_GET_TIMEATNCOX_ProxyImpl proxy = new ZCRMWKQUE_E006_GET_TIMEATNCOX_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_PARTNER");
        input.setValue( "0010000061" ); //0010001950
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_USER");
        input.setValue( "" );//brasso
        inputParams.add( input );
         
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
       
        log.info( "Resurn Data :: " + returnData.toString() );
        
	}
}
