/**
 * 
 */
package com.consupago.sap.interfaces.proxy.regions;

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
public class CRM_DAM_AUOC_REGIONS_COUNTRIES_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( CRM_DAM_AUOC_REGIONS_COUNTRIES_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public CRM_DAM_AUOC_REGIONS_COUNTRIES_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public CRM_DAM_AUOC_REGIONS_COUNTRIES_ProxyImplTC(String name) {
		super(name);
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        CRM_DAM_AUOC_REGIONS_COUNTRIES_ProxyImpl proxy = new CRM_DAM_AUOC_REGIONS_COUNTRIES_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("IV_COUNTRY");
        input.setValue( "MX" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("IV_LANGUAGE");
        input.setValue( "ES" );
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
