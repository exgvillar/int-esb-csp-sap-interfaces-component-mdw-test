/**
 * 
 */
package com.consubanco.sap.interfaces.coi;

import java.io.File;
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
 * @author haydee.sanchez
 *
 */
public class ZCRMOP1098_P012_REGISTROLOTE_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMOP1098_P012_REGISTROLOTE_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMOP1098_P012_REGISTROLOTE_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMOP1098_P012_REGISTROLOTE_ProxyImplTC(String name) {
		super(name);
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
		
		File file = new File("/BF/970d3b5f-4ba5-4a4f-b167-6e4e9b9efc11_expediente.pdf");
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMOP1098_P012_REGISTROLOTE_ProxyImpl proxy = new ZCRMOP1098_P012_REGISTROLOTE_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_LOTE");
        input.setValue( "1" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_FOLDER");
        input.setValue( "12345" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_FULL_FILENAME");
        input.setValue( "970d3b5f-4ba5-4a4f-b167-6e4e9b9efc11_expediente.pdf" );
        inputParams.add( input );
        
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams, file );
        
        log.info( returnData.toString() );
        
        
	}
}
