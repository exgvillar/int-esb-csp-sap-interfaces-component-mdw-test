/**
 * 
 */
package com.consupago.sap.interfaces.proxy.convenios;

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
public class ZCRM_GET_CAT_CONV_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRM_GET_CAT_CONV_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRM_GET_CAT_CONV_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRM_GET_CAT_CONV_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRM_GET_CAT_CONV_ProxyImpl proxy = new ZCRM_GET_CAT_CONV_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("P_EMP");
        input.setValue( "271" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("P_EDO");
        input.setValue( "VER" );
        inputParams.add( input );
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
