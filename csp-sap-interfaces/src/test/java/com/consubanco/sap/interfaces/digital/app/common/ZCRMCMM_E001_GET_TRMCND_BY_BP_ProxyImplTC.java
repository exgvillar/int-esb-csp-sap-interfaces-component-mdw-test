/**
 * 
 */
package com.consubanco.sap.interfaces.digital.app.common;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.digital.app.common.ZCRMCMM_E001_GET_TRMCND_BY_BP_ProxyImpl;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author haydee.sanchez
 *
 */
public class ZCRMCMM_E001_GET_TRMCND_BY_BP_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMCMM_E001_GET_TRMCND_BY_BP_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMCMM_E001_GET_TRMCND_BY_BP_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMCMM_E001_GET_TRMCND_BY_BP_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMCMM_E001_GET_TRMCND_BY_BP_ProxyImpl proxy = new ZCRMCMM_E001_GET_TRMCND_BY_BP_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_ZBP");
        input.setValue( "0000000142" ); 
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("I_ZSOURCE_CH_APP");
        input.setValue( "BKY" );
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
       
        log.info( "Result Data :: " + returnData.toString() );
        
	}
}
