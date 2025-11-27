/**
 * 
 */
package com.consubanco.sap.interfaces.tickets;

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
public class ZCRMRFC_P001_CHGSTS_TKDACL_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMRFC_P001_CHGSTS_TKDACL_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMRFC_P001_CHGSTS_TKDACL_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMRFC_P001_CHGSTS_TKDACL_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMRFC_P001_CHGSTS_TKDACL_ProxyImpl proxy = new ZCRMRFC_P001_CHGSTS_TKDACL_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
                
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_TAREA");
        input.setValue( "0400000198" );
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("I_USER");
        input.setValue( "hsanchez" );
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("I_STATUS");
        input.setValue( "E0004" );
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
