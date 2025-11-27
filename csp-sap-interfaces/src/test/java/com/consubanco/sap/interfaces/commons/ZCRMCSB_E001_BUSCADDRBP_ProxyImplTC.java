/**
 * 
 */
package com.consubanco.sap.interfaces.commons;

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
public class ZCRMCSB_E001_BUSCADDRBP_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMCSB_E001_BUSCADDRBP_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMCSB_E001_BUSCADDRBP_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMCSB_E001_BUSCADDRBP_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMCSB_E001_BUSCADDRBP_ProxyImpl proxy = new ZCRMCSB_E001_BUSCADDRBP_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_BP");
        input.setValue( "0000578005" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_ADDRTYPE");
        input.setValue( "XXDEFAULT" );
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
