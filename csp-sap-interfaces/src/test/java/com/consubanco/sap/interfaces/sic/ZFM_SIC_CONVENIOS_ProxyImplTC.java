/**
 * 
 */
package com.consubanco.sap.interfaces.sic;

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
public class ZFM_SIC_CONVENIOS_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZFM_SIC_CONVENIOS_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZFM_SIC_CONVENIOS_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZFM_SIC_CONVENIOS_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZFM_SIC_CONVENIOS_ProxyImpl proxy = new ZFM_SIC_CONVENIOS_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("P_PARTNER");
        input.setValue( "10003072" );
        inputParams.add( input );
         
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
