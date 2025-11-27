package com.consupago.sap.interfaces.proxy.dispersion.netcash;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

public class ZCRMETET_E001_OBTIENE_DATBANK_ProxyImplTC  extends TestCase  {

	private static Log log = LogFactory.getLog( ZCRMETET_E001_OBTIENE_DATBANK_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMETET_E001_OBTIENE_DATBANK_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMETET_E001_OBTIENE_DATBANK_ProxyImplTC(String name) {
		super(name);
	}

	public void testExecute( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMETET_E001_OBTIENE_DATBANK_ProxyImpl proxy = new ZCRMETET_E001_OBTIENE_DATBANK_ProxyImpl();

        Long inicio = System.currentTimeMillis();
        System.out.println(destination.getClient() );
    	ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
    	ProxyInputParameter input = new ProxyInputParameter();
    	input.setKey("I_PARTNER");
    	input.setValue( "0017000012" );
    	inputParams.add( input );

//    	input.setKey("I_OBJID");
//    	input.setValue( "0050000004" );
//    	inputParams.add( input );

    	
    	ZCRMETET_E001_OBTIENE_DATBANK_OutputData returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        Long fin = System.currentTimeMillis();
        System.out.println("returnData: " + returnData.toString() );
        System.out.println("tiempo: "+ (fin-inicio)/1000 );
	}
}
