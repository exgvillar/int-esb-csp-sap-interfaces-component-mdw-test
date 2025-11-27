/**
 * 
 */
package com.consupago.sap.interfaces.proxy.ecmi;

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
public class ZIF_OBTENERFOLDER_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZIF_OBTENERFOLDER_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZIF_OBTENERFOLDER_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZIF_OBTENERFOLDER_ProxyImplTC(String name) {
		super(name);
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZIF_OBTENERFOLDER_ProxyImpl proxy = new ZIF_OBTENERFOLDER_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("OBJID");
        input.setValue( "0050006773" ); // Check the two zeros on the left
        inputParams.add( input );
 
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
