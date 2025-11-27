/**
 * 
 */
package com.consubanco.sap.interfaces.cxn.dynamics;

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
public class ZCRMORI_GETINFO_DOCSUC_X_SOLCO_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMORI_GETINFO_DOCSUC_X_SOLCO_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMORI_GETINFO_DOCSUC_X_SOLCO_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMORI_GETINFO_DOCSUC_X_SOLCO_ProxyImplTC(String name) {
		super(name);
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMORI_GETINFO_DOCSUC_X_SOLCO_ProxyImpl proxy = new ZCRMORI_GETINFO_DOCSUC_X_SOLCO_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_CONVENIO_CRM");
        input.setValue( "" ); //10000590
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_CONVENIO_BRMS");
        input.setValue( "" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_DOCUMENTO");
        input.setValue( "33" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_CAMPO");
        input.setValue( "8" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_VALOR");
        input.setValue( "JUANITO" );
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
