/**
 * 
 */
package com.consubanco.sap.interfaces.commons.relations;

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
public class ZCRMORI_P018_ADDINQ_SOLBPM_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMORI_P018_ADDINQ_SOLBPM_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMORI_P018_ADDINQ_SOLBPM_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMORI_P018_ADDINQ_SOLBPM_ProxyImplTC(String name) {
		super(name);
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMORI_P018_ADDINQ_SOLBPM_ProxyImpl proxy = new ZCRMORI_P018_ADDINQ_SOLBPM_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_MODE");
        input.setValue( "E" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_SOLICIT");
        input.setValue( "0060000823" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_PROCESS");
        input.setValue( "456" );
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
