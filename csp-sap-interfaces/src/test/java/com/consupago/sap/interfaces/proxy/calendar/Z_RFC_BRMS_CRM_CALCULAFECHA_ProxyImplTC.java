/**
 * 
 */
package com.consupago.sap.interfaces.proxy.calendar;

import java.util.ArrayList;
import java.util.Calendar;

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
 * @author ramon.becerra
 *
 */
public class Z_RFC_BRMS_CRM_CALCULAFECHA_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( Z_RFC_BRMS_CRM_CALCULAFECHA_ProxyImplTC.class );
	
	
	/**
	 * 
	 */
	public Z_RFC_BRMS_CRM_CALCULAFECHA_ProxyImplTC() {
	}

	/**
	 * @param name
	 */
	public Z_RFC_BRMS_CRM_CALCULAFECHA_ProxyImplTC(String name) {
		super(name);
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        Z_RFC_BRMS_CRM_CALCULAFECHA_ProxyImpl proxy = new Z_RFC_BRMS_CRM_CALCULAFECHA_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_FECHA");
       // input.setValue( "20120822" );
//        input.setType("java.util.Date1");
        input.setDateValue( SAPFormatter.formatSAPDate( "21.11.2016" ) );
        input.setType("java.util.Date");
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_DIAS");
        input.setValue( "0" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_CALENDARIO");
        input.setValue( "Z1" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_DIASHAB");
        input.setValue( "X" );
        inputParams.add( input );
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
