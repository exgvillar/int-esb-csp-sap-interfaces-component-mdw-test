package com.consupago.sap.interfaces.proxy.lcom.commons;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

public class ZRFC_INF_CONVENIO_CAT_ProxyImplTC extends TestCase {
	private static Log log = LogFactory.getLog( ZRFC_INF_CONVENIO_CAT_ProxyImplTC.class );
	
	
	public ZRFC_INF_CONVENIO_CAT_ProxyImplTC(String name) {
		super(name);
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZRFC_INF_CONVENIO_CAT_ProxyImpl proxy = new ZRFC_INF_CONVENIO_CAT_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("PRODUCT_ID");
        input.setValue( "10000570" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("OBJECT_ID");
        input.setValue( "10000570" );
        inputParams.add( input );
       
        System.out.println( proxy.executeRemoteFunction(destination, inputParams ) );
	}


}
