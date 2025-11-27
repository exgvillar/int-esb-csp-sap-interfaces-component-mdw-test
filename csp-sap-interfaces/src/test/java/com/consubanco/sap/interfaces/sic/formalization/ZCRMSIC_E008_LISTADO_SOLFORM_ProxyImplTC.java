/**
 * 
 */
package com.consubanco.sap.interfaces.sic.formalization;

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
public class ZCRMSIC_E008_LISTADO_SOLFORM_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMSIC_E008_LISTADO_SOLFORM_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMSIC_E008_LISTADO_SOLFORM_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMSIC_E008_LISTADO_SOLFORM_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMSIC_E008_LISTADO_SOLFORM_ProxyImpl proxy = new ZCRMSIC_E008_LISTADO_SOLFORM_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_FINI");
        input.setDateValue( SAPFormatter.formatSAPDate( "19.06.2013" ) );
        input.setType("java.util.Date");        
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_FFIN");
        input.setDateValue( SAPFormatter.formatSAPDate( "20.06.2013" ) );
        input.setType("java.util.Date");
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
