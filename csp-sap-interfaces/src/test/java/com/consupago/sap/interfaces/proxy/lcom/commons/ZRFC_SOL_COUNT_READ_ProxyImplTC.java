package com.consupago.sap.interfaces.proxy.lcom.commons;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

public class ZRFC_SOL_COUNT_READ_ProxyImplTC extends TestCase {
	private static Log log = LogFactory.getLog( ZRFC_SOL_COUNT_READ_ProxyImplTC.class );
	
	
	public ZRFC_SOL_COUNT_READ_ProxyImplTC(String name) {
		super(name);
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZRFC_SOL_COUNT_READ_ProxyImpl proxy = new ZRFC_SOL_COUNT_READ_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_NUMDOC");
        input.setValue( "0200002207" );
        inputParams.add( input );
       
        System.out.println( proxy.executeRemoteFunction(destination, inputParams ) );
	}


}
