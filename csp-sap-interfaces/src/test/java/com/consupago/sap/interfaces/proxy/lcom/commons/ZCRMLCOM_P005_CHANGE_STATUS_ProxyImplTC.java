package com.consupago.sap.interfaces.proxy.lcom.commons;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.lcom.commons.ZCRMLCOM_P005_CHANGE_STATUS_ProxyImpl;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

public class ZCRMLCOM_P005_CHANGE_STATUS_ProxyImplTC extends TestCase {
	private static Log log = LogFactory.getLog( ZCRMLCOM_P005_CHANGE_STATUS_ProxyImplTC.class );
	
	
	public ZCRMLCOM_P005_CHANGE_STATUS_ProxyImplTC(String name) {
		super(name);
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        System.out.println(destination.getClient());
        ZCRMLCOM_P005_CHANGE_STATUS_ProxyImpl proxy = new ZCRMLCOM_P005_CHANGE_STATUS_ProxyImpl();
        
        String[] arrSolic = "0050605725"
        .split("\\|");
        
        for (String lasolic : arrSolic) {
            ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
            ProxyInputParameter input = new ProxyInputParameter();
            input.setKey("I_ORDSER");
            input.setValue( lasolic );
            inputParams.add( input );
            input = new ProxyInputParameter();
            input.setKey("I_TIPDOC");
            input.setValue( "ZCSP" );
            inputParams.add( input );
            input = new ProxyInputParameter();
            input.setKey("I_STATUS");
//            input.setValue( "E0036" ); // COMPRADA
//            input.setValue( "E0034" ); // EN PROCESO DISP A CLIENTE
            input.setValue( "E0036" ); // COMPRADA
            
            inputParams.add( input );
           
            proxy.executeRemoteFunction(destination, inputParams );
		}
	}


}
