/**
 * 
 */
package com.consubanco.sap.interfaces.disbusrment;

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
public class ZCRMCXN_E012_GETOSBYAPP_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMCXN_E012_GETOSBYAPP_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMCXN_E012_GETOSBYAPP_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMCXN_E012_GETOSBYAPP_ProxyImplTC(String name) {
		super(name);

	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMCXN_E012_GETOSBYAPP_ProxyImpl proxy = new ZCRMCXN_E012_GETOSBYAPP_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_SOLICITUD");
        input.setValue( "0050388128" );
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("I_TIPOORDENSERVICIO");
        input.setValue( "ZOOR" );
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
