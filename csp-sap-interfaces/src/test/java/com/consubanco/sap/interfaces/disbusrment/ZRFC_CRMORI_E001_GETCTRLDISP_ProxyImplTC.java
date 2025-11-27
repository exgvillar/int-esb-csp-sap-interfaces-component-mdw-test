/**
 * 
 */
package com.consubanco.sap.interfaces.disbusrment;

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
 * @author haydee.sanchez
 *
 */
public class ZRFC_CRMORI_E001_GETCTRLDISP_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZRFC_CRMORI_E001_GETCTRLDISP_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZRFC_CRMORI_E001_GETCTRLDISP_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZRFC_CRMORI_E001_GETCTRLDISP_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZRFC_CRMORI_E001_GETCTRLDISP_ProxyImpl proxy = new ZRFC_CRMORI_E001_GETCTRLDISP_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_CLAVERASTREO");
        input.setValue( "3456789046" );
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
