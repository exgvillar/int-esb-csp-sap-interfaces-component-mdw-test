package com.consupago.sap.interfaces.proxy.dispersionnostro.lcom;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.format.SAPFormatter;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

public class ZCRMLCOM_E002_READLCOM_XSTATUS_ProxyImplTC  extends TestCase  {

	private static Log log = LogFactory.getLog( ZCRMLCOM_E002_READLCOM_XSTATUS_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMLCOM_E002_READLCOM_XSTATUS_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMLCOM_E002_READLCOM_XSTATUS_ProxyImplTC(String name) {
		super(name);
	}

	public void testExecute( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMLCOM_E002_READLCOM_XSTATUS_ProxyImpl proxy = new ZCRMLCOM_E002_READLCOM_XSTATUS_ProxyImpl();

        Long inicio = System.currentTimeMillis();
        System.out.println(destination.getClient() );
        
    	ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
    	ProxyInputParameter input = new ProxyInputParameter();
    	
    	input.setKey("I_SOLICITUD");
    	input.setValue( "0050384809" );
    	inputParams.add( input );
    	
    	input = new ProxyInputParameter();
        input.setKey("I_STATUS");
        input.setValue( "E0031" );
        inputParams.add( input );

        input = new ProxyInputParameter();
        input.setKey("I_TIPDOC");
        input.setValue( "ZCSP" );
        inputParams.add( input );
        
        input = new ProxyInputParameter();    
		input.setKey("I_FECINI");		
		input.setDateValue( SAPFormatter.formatSAPDate( "01.01.2015" ) );
		input.setType("java.util.Date");		
		inputParams.add( input );
		
		input = new ProxyInputParameter();    
		input.setKey("I_FECFIN");
		input.setDateValue( SAPFormatter.formatSAPDate( "31.12.2016" ) );
		input.setType("java.util.Date");
		inputParams.add( input );
		
		
    	
    	ZCRMLCOM_E002_READLCOM_XSTATUS_OutputData returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        Long fin = System.currentTimeMillis();
        System.out.println("returnData: " + returnData.toString() );
        System.out.println("tiempo: "+ (fin-inicio)/1000 );

        
	}
}
