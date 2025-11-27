/**
 * 
 */
package com.consubanco.sap.interfaces.massiveLoad;

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
 * @author hsanchez
 *
 */
public class ZCRMORIG_E002_GETFILESBYEXTAPP_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMORIG_E002_GETFILESBYEXTAPP_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMORIG_E002_GETFILESBYEXTAPP_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMORIG_E002_GETFILESBYEXTAPP_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMORIG_E002_GETFILESBYEXTAPP_ProxyImpl proxy = new ZCRMORIG_E002_GETFILESBYEXTAPP_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_EXTERNALFOLIOAPP");
        input.setValue( "000072495249" );
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
