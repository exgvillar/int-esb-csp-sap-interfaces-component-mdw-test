/**
 * 
 */
package com.consubanco.sap.interfaces.dispersion;

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
public class ZCRMTESO_GET_IND_DISPAUTO_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMTESO_GET_IND_DISPAUTO_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMTESO_GET_IND_DISPAUTO_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMTESO_GET_IND_DISPAUTO_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMTESO_GET_IND_DISPAUTO_ProxyImpl proxy = new ZCRMTESO_GET_IND_DISPAUTO_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
