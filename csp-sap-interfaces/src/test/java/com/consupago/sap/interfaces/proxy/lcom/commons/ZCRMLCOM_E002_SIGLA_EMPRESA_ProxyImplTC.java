package com.consupago.sap.interfaces.proxy.lcom.commons;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

public class ZCRMLCOM_E002_SIGLA_EMPRESA_ProxyImplTC extends TestCase {
	private static Log log = LogFactory.getLog( ZCRMLCOM_E002_SIGLA_EMPRESA_ProxyImplTC.class );
	
	
	public ZCRMLCOM_E002_SIGLA_EMPRESA_ProxyImplTC(String name) {
		super(name);
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMLCOM_E002_SIGLA_EMPRESA_ProxyImpl proxy = new ZCRMLCOM_E002_SIGLA_EMPRESA_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("ID_EMPRESA");
        input.setValue( "0050000003" );
        inputParams.add( input );
       
        System.out.println("RET:" + proxy.executeRemoteFunction(destination, inputParams ) );
	}


}
