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
 * @author haydee.sanchez
 *
 */
public class ZCRMORI_E053_GETCATREGFISCAL_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMORI_E053_GETCATREGFISCAL_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMORI_E053_GETCATREGFISCAL_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMORI_E053_GETCATREGFISCAL_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMORI_E053_GETCATREGFISCAL_ProxyImpl proxy = new ZCRMORI_E053_GETCATREGFISCAL_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_TIPOPERSONAQUEAPLICA");
        input.setValue( "MORAL" ); // "FISICA" , "MORAL"
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
