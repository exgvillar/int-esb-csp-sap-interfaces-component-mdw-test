package com.consubanco.sap.interfaces.common.status;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

public class ZRFC_ACT_CASO_COTIZ_ProxyImplTC extends TestCase {
	private static Log log = LogFactory.getLog( ZRFC_ACT_CASO_COTIZ_ProxyImplTC.class );
	
	
	public ZRFC_ACT_CASO_COTIZ_ProxyImplTC(String name) {
		super(name);
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZRFC_ACT_CASO_COTIZ_ProxyImpl proxy = new ZRFC_ACT_CASO_COTIZ_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("EXT_KEY");
        input.setValue( "0050006758" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("IV_STATUS");
        input.setValue( "4110" );
        inputParams.add( input );
       
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}


}
