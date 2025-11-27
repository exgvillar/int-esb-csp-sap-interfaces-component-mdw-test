/**
 * 
 */
package com.consupago.sap.interfaces.proxy.cdb.products;

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
public class ZRFC_NOMBRE_PRODUCTO_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZRFC_NOMBRE_PRODUCTO_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZRFC_NOMBRE_PRODUCTO_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZRFC_NOMBRE_PRODUCTO_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZRFC_NOMBRE_PRODUCTO_ProxyImpl proxy = new ZRFC_NOMBRE_PRODUCTO_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_PRODUCTO");
        input.setValue( "510" );
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
