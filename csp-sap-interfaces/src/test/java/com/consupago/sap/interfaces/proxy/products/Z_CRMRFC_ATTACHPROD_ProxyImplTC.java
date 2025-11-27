/**
 * 
 */
package com.consupago.sap.interfaces.proxy.products;

import java.io.File;
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
public class Z_CRMRFC_ATTACHPROD_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( Z_CRMRFC_ATTACHPROD_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public Z_CRMRFC_ATTACHPROD_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public Z_CRMRFC_ATTACHPROD_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        File file = new File("/BF/c6aa81e0-81bd-4010-846e-f7757c82e891_expediente.pdf");
        
        Z_CRMRFC_ATTACHPROD_ProxyImpl proxy = new Z_CRMRFC_ATTACHPROD_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("PRODUCT");
        input.setValue( "10000027" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("FULL_FILENAME");
        input.setValue( file.getName() );
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams, file );
        
        log.info( returnData.toString() );
        
        
	}
}
