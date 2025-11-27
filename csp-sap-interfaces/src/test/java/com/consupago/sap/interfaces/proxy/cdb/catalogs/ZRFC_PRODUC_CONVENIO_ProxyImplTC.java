/**
 * 
 */
package com.consupago.sap.interfaces.proxy.cdb.catalogs;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.cdb.catalogs.ZRFC_PRODUC_CONVENIO_ProxyImpl;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author ramon.becerra
 *
 */
public class ZRFC_PRODUC_CONVENIO_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZRFC_PRODUC_CONVENIO_ProxyImplTC.class );
	
	
	/**
	 * 
	 */
	public ZRFC_PRODUC_CONVENIO_ProxyImplTC() {
	}

	/**
	 * @param name
	 */
	public ZRFC_PRODUC_CONVENIO_ProxyImplTC(String name) {
		super(name);
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZRFC_PRODUC_CONVENIO_ProxyImpl proxy = new ZRFC_PRODUC_CONVENIO_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("PRODUCT_ID");
        input.setValue( "10000032" );
        inputParams.add( input );
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
