/**
 * 
 */
package com.consubanco.sap.interfaces.proxy.cm;

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
public class ZCRMCOM_GET_ORGANIGRAMA_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMCOM_GET_ORGANIGRAMA_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMCOM_GET_ORGANIGRAMA_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMCOM_GET_ORGANIGRAMA_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMCOM_GET_ORGANIGRAMA_ProxyImpl proxy = new ZCRMCOM_GET_ORGANIGRAMA_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_NUMDOC");
        input.setValue( "0050001724" ); 
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("I_FECINI");
        input.setType("java.util.Date");
        input.setDateValue( SAPFormatter.formatSAPDate( "01.10.2011" ) );
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("I_FECFIN");
        input.setType("java.util.Date");
        input.setDateValue( SAPFormatter.formatSAPDate( "31.10.2011" ) ); 
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
       
        log.info( "Resurn Data :: " + returnData.toString() );
        
	}
}
