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
public class ZCRM_SUCURSAL_COMISION_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRM_SUCURSAL_COMISION_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRM_SUCURSAL_COMISION_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRM_SUCURSAL_COMISION_ProxyImplTC(String name) {
		super(name);
		
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRM_SUCURSAL_COMISION_ProxyImpl proxy = new ZCRM_SUCURSAL_COMISION_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("IDDISTRIBUIDOR");
        input.setValue( "CSCSP" );        
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
