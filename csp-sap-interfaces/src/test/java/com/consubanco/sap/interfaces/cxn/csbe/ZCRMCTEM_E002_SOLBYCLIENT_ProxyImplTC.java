/**
 * 
 */
package com.consubanco.sap.interfaces.cxn.csbe;

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
public class ZCRMCTEM_E002_SOLBYCLIENT_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMCTEM_E002_SOLBYCLIENT_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMCTEM_E002_SOLBYCLIENT_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMCTEM_E002_SOLBYCLIENT_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMCTEM_E002_SOLBYCLIENT_ProxyImpl proxy = new ZCRMCTEM_E002_SOLBYCLIENT_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_CLIENTE");
        input.setValue( "0002600689" );
//        input.setValue( "0002600689" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_RFC");
        input.setValue( "" );
//        input.setValue( "AACE700101" );
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
