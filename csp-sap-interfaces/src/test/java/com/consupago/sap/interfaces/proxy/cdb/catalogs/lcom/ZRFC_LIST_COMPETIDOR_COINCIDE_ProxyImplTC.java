/**
 * 
 */
package com.consupago.sap.interfaces.proxy.cdb.catalogs.lcom;

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
public class ZRFC_LIST_COMPETIDOR_COINCIDE_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZRFC_LIST_COMPETIDOR_COINCIDE_ProxyImplTC.class );
	
	
	/**
	 * 
	 */
	public ZRFC_LIST_COMPETIDOR_COINCIDE_ProxyImplTC() {
	}

	/**
	 * @param name
	 */
	public ZRFC_LIST_COMPETIDOR_COINCIDE_ProxyImplTC(String name) {
		super(name);
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZRFC_LIST_COMPETIDOR_COINCIDE_ProxyImpl proxy = new ZRFC_LIST_COMPETIDOR_COINCIDE_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("P_NAME");
        input.setValue( "" );
        inputParams.add( input );
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
