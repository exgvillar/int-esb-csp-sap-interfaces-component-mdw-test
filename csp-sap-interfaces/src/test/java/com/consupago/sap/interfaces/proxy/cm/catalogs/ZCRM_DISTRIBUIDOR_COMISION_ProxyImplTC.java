/**
 * 
 */
package com.consupago.sap.interfaces.proxy.cm.catalogs;

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
public class ZCRM_DISTRIBUIDOR_COMISION_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRM_DISTRIBUIDOR_COMISION_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRM_DISTRIBUIDOR_COMISION_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRM_DISTRIBUIDOR_COMISION_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRM_DISTRIBUIDOR_COMISION_ProxyImpl proxy = new ZCRM_DISTRIBUIDOR_COMISION_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
//        ProxyInputParameter input = new ProxyInputParameter();       
//        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
