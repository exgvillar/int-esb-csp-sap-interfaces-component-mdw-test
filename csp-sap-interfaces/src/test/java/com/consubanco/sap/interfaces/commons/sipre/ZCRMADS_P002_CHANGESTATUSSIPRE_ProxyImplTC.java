package com.consubanco.sap.interfaces.commons.sipre;

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

public class ZCRMADS_P002_CHANGESTATUSSIPRE_ProxyImplTC extends TestCase {
	
	private static Log log = LogFactory.getLog(ZCRMADS_P002_CHANGESTATUSSIPRE_ProxyImplTC.class);
		
	public ZCRMADS_P002_CHANGESTATUSSIPRE_ProxyImplTC() {
		super();
	}

	public void testDestination() throws Exception {
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
		
        ZCRMADS_P002_CHANGESTATUSSIPRE_ProxyImpl proxy = new ZCRMADS_P002_CHANGESTATUSSIPRE_ProxyImpl();

        List<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_TAKS");
        input.setValue( "1890000071" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_STATUSID");
        input.setValue( "E0002" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_NOTE");
        input.setValue( "PRUEBA NOTA" );
        inputParams.add( input );        
		
        List<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( "Return data ---> " + returnData.toString() );
	}
}
