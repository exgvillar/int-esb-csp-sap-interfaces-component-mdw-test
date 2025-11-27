/**
 * 
 */
package com.consupago.sap.interfaces.proxy.cdb.liquidity;

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
public class ZCRMOP1098_P009_CONSCONVCOI_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMOP1098_P009_CONSCONVCOI_ProxyImplTC.class );
	
	
	/**
	 * 
	 */
	public ZCRMOP1098_P009_CONSCONVCOI_ProxyImplTC() {
	}

	/**
	 * @param name
	 */
	public ZCRMOP1098_P009_CONSCONVCOI_ProxyImplTC(String name) {
		super(name);
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMOP1098_P009_CONSCONVCOI_ProxyImpl proxy = new ZCRMOP1098_P009_CONSCONVCOI_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
