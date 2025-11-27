/**
 * 
 */
package com.consubanco.sap.interfaces.bt;

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
 * @author jrauluribes
 *
 */
public class ZCRMBT_P003_SAVE_DICTAMEN_BRMS_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMBT_P003_SAVE_DICTAMEN_BRMS_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMBT_P003_SAVE_DICTAMEN_BRMS_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMBT_P003_SAVE_DICTAMEN_BRMS_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMBT_P003_SAVE_DICTAMEN_BRMS_ProxyImpl proxy = new ZCRMBT_P003_SAVE_DICTAMEN_BRMS_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_SOLICITUD");
        input.setValue( "0000123938" );
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("I_BP");
        input.setValue( "" ); 
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("I_DICTAMEN_BRMS");
        input.setValue( "X" ); 
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("I_TELEFONO");
        input.setValue( "5567678988" ); 
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("I_PROTOCOLO");
        input.setValue( "FRAUDE" ); 
        inputParams.add( input );
        
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
       
        log.info( "Resurn Data :: " + returnData.toString() );
        
	}
}
