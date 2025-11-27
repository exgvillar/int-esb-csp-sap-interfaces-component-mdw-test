/**
 * 
 */
package com.consubanco.sap.interfaces.massiveLoad;

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
 * @author hsanchez
 *
 */
public class ZCRMORIG_P001_CREAOPORTUNIDAD_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMORIG_P001_CREAOPORTUNIDAD_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMORIG_P001_CREAOPORTUNIDAD_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMORIG_P001_CREAOPORTUNIDAD_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMORIG_P001_CREAOPORTUNIDAD_ProxyImpl proxy = new ZCRMORIG_P001_CREAOPORTUNIDAD_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_BP");
        input.setValue( "1058819" );
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("I_SOURCECHANNEL");
        input.setValue( "ZC7" ); // ZC7 FAMSA / ZC8 MasNomina 
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("I_EXTERNALFOLIOAPP");
        input.setValue( "6780987567" );  
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
