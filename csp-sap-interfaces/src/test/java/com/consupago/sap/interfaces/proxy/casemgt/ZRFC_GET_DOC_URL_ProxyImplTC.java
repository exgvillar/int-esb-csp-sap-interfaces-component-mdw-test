/**
 * 
 */
package com.consupago.sap.interfaces.proxy.casemgt;

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
public class ZRFC_GET_DOC_URL_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZRFC_GET_DOC_URL_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZRFC_GET_DOC_URL_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZRFC_GET_DOC_URL_ProxyImplTC(String name) {
		super(name);
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZRFC_GET_DOC_URL_ProxyImpl proxy = new ZRFC_GET_DOC_URL_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_CASO");
        input.setValue( "35470" ); // Check the two zeros on the left
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_FILENAME");
        input.setValue( "archivopdf.PDF" ); 
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
