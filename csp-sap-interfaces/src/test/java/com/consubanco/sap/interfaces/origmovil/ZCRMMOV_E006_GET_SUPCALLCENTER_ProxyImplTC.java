/**
 * 
 */
package com.consubanco.sap.interfaces.origmovil;

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
public class ZCRMMOV_E006_GET_SUPCALLCENTER_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMMOV_E006_GET_SUPCALLCENTER_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMMOV_E006_GET_SUPCALLCENTER_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMMOV_E006_GET_SUPCALLCENTER_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMMOV_E006_GET_SUPCALLCENTER_ProxyImpl proxy = new ZCRMMOV_E006_GET_SUPCALLCENTER_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_IDCALLC");
        input.setValue( "SUP_C_CRED" );
        inputParams.add( input );
               
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
