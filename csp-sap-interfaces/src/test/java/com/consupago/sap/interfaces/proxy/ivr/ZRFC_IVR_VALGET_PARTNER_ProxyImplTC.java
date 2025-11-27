/**
 * 
 */
package com.consupago.sap.interfaces.proxy.ivr;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.lang.StringUtils;
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
public class ZRFC_IVR_VALGET_PARTNER_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZRFC_IVR_VALGET_PARTNER_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZRFC_IVR_VALGET_PARTNER_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZRFC_IVR_VALGET_PARTNER_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZRFC_IVR_VALGET_PARTNER_ProxyImpl proxy = new ZRFC_IVR_VALGET_PARTNER_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_CLIENTID");
        input.setValue( "10001530" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_TYPE");
        input.setValue( StringUtils.trim( "2" ) );
        inputParams.add( input );
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
