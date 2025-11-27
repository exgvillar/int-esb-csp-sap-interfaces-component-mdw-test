/**
 * 
 */
package com.consubanco.sap.interfaces.dispersion;

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
public class ZCRMUTIL_GET_HABINHAB_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMUTIL_GET_HABINHAB_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMUTIL_GET_HABINHAB_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMUTIL_GET_HABINHAB_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMUTIL_GET_HABINHAB_ProxyImpl proxy = new ZCRMUTIL_GET_HABINHAB_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_DATE");
        input.setDateValue( SAPFormatter.formatSAPDate( "13.12.2016" ) );
        input.setType("java.util.Date");
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_CALENDAR");
        input.setValue( "Z1" );
        inputParams.add( input );
               
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
