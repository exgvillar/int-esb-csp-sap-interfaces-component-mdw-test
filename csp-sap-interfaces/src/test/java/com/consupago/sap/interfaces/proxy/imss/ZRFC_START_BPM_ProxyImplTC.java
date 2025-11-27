/**
 * 
 */
package com.consupago.sap.interfaces.proxy.imss;

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
 * @author ramon.becerra
 *
 */
public class ZRFC_START_BPM_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZRFC_START_BPM_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZRFC_START_BPM_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZRFC_START_BPM_ProxyImplTC(String name) {
		super(name);
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZRFC_START_BPM_ProxyImpl proxy = new ZRFC_START_BPM_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_STATUS");
        input.setValue( "E0065" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_SAVE");
        input.setValue( "" );
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
