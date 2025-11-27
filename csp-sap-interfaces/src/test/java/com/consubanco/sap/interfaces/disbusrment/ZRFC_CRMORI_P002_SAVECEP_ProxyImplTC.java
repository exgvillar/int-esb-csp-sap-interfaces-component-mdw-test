/**
 * 
 */
package com.consubanco.sap.interfaces.disbusrment;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.format.SAPFormatter;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author haydee.sanchez
 *
 */
public class ZRFC_CRMORI_P002_SAVECEP_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZRFC_CRMORI_P002_SAVECEP_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZRFC_CRMORI_P002_SAVECEP_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZRFC_CRMORI_P002_SAVECEP_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZRFC_CRMORI_P002_SAVECEP_ProxyImpl proxy = new ZRFC_CRMORI_P002_SAVECEP_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_CLAVERASTREO");
        input.setValue( "3456789046" );
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("I_CEPGENERADO");
        input.setValue( "X" );
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("I_FECHACEP");
        input.setType("java.util.Date");
        input.setDateValue( SAPFormatter.formatSAPDate( "15.06.2021" ) );
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
