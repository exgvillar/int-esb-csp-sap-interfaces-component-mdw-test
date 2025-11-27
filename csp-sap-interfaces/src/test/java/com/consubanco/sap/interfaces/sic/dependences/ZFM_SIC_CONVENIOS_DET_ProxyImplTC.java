/**
 * 
 */
package com.consubanco.sap.interfaces.sic.dependences;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.sic.dependences.ZFM_SIC_CONVENIOS_DET_ProxyImpl;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author haydee.sanchez
 *
 */
public class ZFM_SIC_CONVENIOS_DET_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZFM_SIC_CONVENIOS_DET_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZFM_SIC_CONVENIOS_DET_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZFM_SIC_CONVENIOS_DET_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZFM_SIC_CONVENIOS_DET_ProxyImpl proxy = new ZFM_SIC_CONVENIOS_DET_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("P_CONV");
        input.setValue( "10000027" );
        inputParams.add( input );
         
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
