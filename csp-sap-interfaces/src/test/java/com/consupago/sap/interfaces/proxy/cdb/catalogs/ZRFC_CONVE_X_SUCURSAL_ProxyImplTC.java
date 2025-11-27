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
import com.consupago.sap.interfaces.proxy.cdb.catalogs.ZRFC_CONVE_X_SUCURSAL_ProxyImpl;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author ramon.becerra
 *
 */
public class ZRFC_CONVE_X_SUCURSAL_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZRFC_CONVE_X_SUCURSAL_ProxyImplTC.class );
	
	
	/**
	 * 
	 */
	public ZRFC_CONVE_X_SUCURSAL_ProxyImplTC() {
	}

	/**
	 * @param name
	 */
	public ZRFC_CONVE_X_SUCURSAL_ProxyImplTC(String name) {
		super(name);
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZRFC_CONVE_X_SUCURSAL_ProxyImpl proxy = new ZRFC_CONVE_X_SUCURSAL_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("PLVAR");
        input.setValue( "01" );
        inputParams.add( input );
        input.setKey("OTYPE");
        input.setValue( "O" );
        inputParams.add( input );
        input.setKey("OBJID");
        input.setValue( "50000442" );
        inputParams.add( input );
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
