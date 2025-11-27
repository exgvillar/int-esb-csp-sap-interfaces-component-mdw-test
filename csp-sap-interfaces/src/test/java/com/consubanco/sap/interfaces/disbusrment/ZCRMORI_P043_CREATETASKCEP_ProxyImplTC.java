/**
 * 
 */
package com.consubanco.sap.interfaces.disbusrment;

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
public class ZCRMORI_P043_CREATETASKCEP_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMORI_P043_CREATETASKCEP_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMORI_P043_CREATETASKCEP_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMORI_P043_CREATETASKCEP_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMORI_P043_CREATETASKCEP_ProxyImpl proxy = new ZCRMORI_P043_CREATETASKCEP_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_FOLIOAPPLICATION");
        input.setValue( "0050386783" ); //0050386761, 0050386771
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
