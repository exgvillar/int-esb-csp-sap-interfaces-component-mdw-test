package com.consubanco.sap.interfaces.commons.sipre;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.ProxyInputParameterWithTable;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

import junit.framework.TestCase;

public class ZCRMADS_E001_GETINFOGENERAL_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog(ZCRMADS_E001_GETINFOGENERAL_ProxyImplTC.class);

	public ZCRMADS_E001_GETINFOGENERAL_ProxyImplTC() {
		super();
	}
	
	public void testDestination() throws Exception {
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMADS_E001_GETINFOGENERAL_ProxyImpl proxy = new ZCRMADS_E001_GETINFOGENERAL_ProxyImpl();
        
        ProxyInputParameterWithTable inputParams = new ProxyInputParameterWithTable();
        inputParams.setGeneralParam( new ArrayList<ProxyInputParameter>() );
        
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_ID_TASK");
        input.setValue( "" );
        inputParams.getGeneralParam().add( input );
        input = new ProxyInputParameter();
        input.setKey("I_BP");
        input.setValue( "" );
        inputParams.getGeneralParam().add( input );
        input = new ProxyInputParameter();
        input.setKey("I_CURP");
        input.setValue( "PERC800101HDFRMR05" );
        inputParams.getGeneralParam().add( input );   
         
        List<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( "Return data ---> " + returnData.toString() );
	}
		
}
