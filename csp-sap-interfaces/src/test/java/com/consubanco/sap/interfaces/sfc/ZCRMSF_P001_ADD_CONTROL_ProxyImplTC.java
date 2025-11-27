package com.consubanco.sap.interfaces.sfc;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

import junit.framework.TestCase;

public class ZCRMSF_P001_ADD_CONTROL_ProxyImplTC extends TestCase {
	
	private static Log log = LogFactory.getLog(ZCRMSF_P001_ADD_CONTROL_ProxyImplTC.class);
		
	public ZCRMSF_P001_ADD_CONTROL_ProxyImplTC() {
		super();
	}

	public void testDestination() throws Exception {
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
		
        ZCRMSF_P001_ADD_CONTROL_ProxyImpl proxy = new ZCRMSF_P001_ADD_CONTROL_ProxyImpl();

        List<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_APPLICATIONID");
        input.setValue( "1478963252" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_APPLICATIONCRM");
        input.setValue( "0050000500" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_OPPORTUNITYSFC");
        input.setValue( "12457976323" );
        inputParams.add( input ); 
        input = new ProxyInputParameter();
        input.setKey("I_FILENET_KEY");
        input.setValue( "11559889878" );
        inputParams.add( input ); 
		
        List<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( "Return data ---> " + returnData.toString() );
	}
}
