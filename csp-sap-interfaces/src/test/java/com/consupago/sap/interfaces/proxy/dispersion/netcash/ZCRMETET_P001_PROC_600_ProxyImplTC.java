package com.consupago.sap.interfaces.proxy.dispersion.netcash;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

import junit.framework.TestCase;

public class ZCRMETET_P001_PROC_600_ProxyImplTC  extends TestCase  {

	private static Log log = LogFactory.getLog( ZCRMETET_P001_PROC_600_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMETET_P001_PROC_600_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMETET_P001_PROC_600_ProxyImplTC(String name) {
		super(name);
	}

	public void testExecute( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMETET_P001_PROC_600_ProxyImpl proxy = new ZCRMETET_P001_PROC_600_ProxyImpl();

        Long inicio = System.currentTimeMillis();
        System.out.println(destination.getClient() );
    	ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
    	ProxyInputParameter input = new ProxyInputParameter();
    	input.setKey("I_EMP_RESP");
    	input.setValue( "1234" );
    	inputParams.add( input );

        ArrayList<ZCRMETET_P001_PROC_600_OutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        for (ZCRMETET_P001_PROC_600_OutputData outputData : returnData) {
        	System.out.println("=======================================");
			System.out.println(outputData.toString());
		}
        Long fin = System.currentTimeMillis();
//        System.out.println("returnData: " + returnData.size() );
        System.out.println("tiempo: "+ (fin-inicio)/1000 );
	}
}
