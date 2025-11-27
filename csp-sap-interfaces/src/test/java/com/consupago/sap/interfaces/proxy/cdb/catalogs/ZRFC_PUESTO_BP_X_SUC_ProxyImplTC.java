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
import com.consupago.sap.interfaces.proxy.cdb.catalogs.ZRFC_PROMO_X_SUCURSAL_ProxyImpl;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author ramon.becerra
 *
 */
public class ZRFC_PUESTO_BP_X_SUC_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZRFC_PUESTO_BP_X_SUC_ProxyImplTC.class );
	
	
	/**
	 * 
	 */
	public ZRFC_PUESTO_BP_X_SUC_ProxyImplTC() {
	}

	/**
	 * @param name
	 */
	public ZRFC_PUESTO_BP_X_SUC_ProxyImplTC(String name) {
		super(name);
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZRFC_PUESTO_BP_X_SUC_ProxyImpl proxy = new ZRFC_PUESTO_BP_X_SUC_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("ID_SUCURSAL");
        input.setValue( "50000037" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("ID_BP");
        input.setValue( "0010002580" );
        inputParams.add( input );
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
