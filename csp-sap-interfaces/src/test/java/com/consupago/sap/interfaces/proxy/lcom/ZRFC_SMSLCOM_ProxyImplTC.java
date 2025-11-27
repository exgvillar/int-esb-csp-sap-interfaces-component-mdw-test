/**
 * 
 */
package com.consupago.sap.interfaces.proxy.lcom;

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
public class ZRFC_SMSLCOM_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZRFC_SMSLCOM_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZRFC_SMSLCOM_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZRFC_SMSLCOM_ProxyImplTC(String name) {
		super(name);
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZRFC_SMSLCOM_ProxyImpl proxy = new ZRFC_SMSLCOM_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_ESTATUS");
        input.setValue( "E0036" );
        inputParams.add( input );
        
        ArrayList<String> categoryList = new ArrayList<String>();
        categoryList.add("LCOM");
        categoryList.add("CONT");
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams, categoryList );
        
        log.info( returnData.toString() );
        
        
	}
}
