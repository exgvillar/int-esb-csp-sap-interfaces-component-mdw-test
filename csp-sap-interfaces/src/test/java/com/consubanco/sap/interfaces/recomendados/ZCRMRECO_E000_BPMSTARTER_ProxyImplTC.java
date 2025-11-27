package com.consubanco.sap.interfaces.recomendados;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author omar.corona
 *
 */
public class ZCRMRECO_E000_BPMSTARTER_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMRECO_E000_BPMSTARTER_ProxyImplTC.class );
	


	/**
	 * 
	 */
	public ZCRMRECO_E000_BPMSTARTER_ProxyImplTC() {
		
	}


	
	/**
	 * @param name
	 */
	public ZCRMRECO_E000_BPMSTARTER_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}


	
	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMRECO_E000_BPMSTARTER_ProxyImpl proxy = new ZCRMRECO_E000_BPMSTARTER_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_NUMSOL");
        input.setValue( "0050001554" );
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
	}
}
