/**
 * 
 */
package com.consubanco.sap.interfaces.commons.employees;

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
public class ZCRMORI_E015_GET_EMPLEOSBP_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMORI_E015_GET_EMPLEOSBP_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMORI_E015_GET_EMPLEOSBP_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMORI_E015_GET_EMPLEOSBP_ProxyImplTC(String name) {
		super(name);
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMORI_E015_GET_EMPLEOSBP_ProxyImpl proxy = new ZCRMORI_E015_GET_EMPLEOSBP_ProxyImpl();
                
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_BP");
        input.setValue( "0000000142" );
        inputParams.add( input );
               
        ArrayList<IProxyOutputData> result = proxy.executeRemoteFunction(destination, inputParams );
        log.info("Resultado :: "+result.toString());
        
        
        
	}
}
