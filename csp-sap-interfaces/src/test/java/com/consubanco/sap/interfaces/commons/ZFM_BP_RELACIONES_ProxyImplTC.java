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
public class ZFM_BP_RELACIONES_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZFM_BP_RELACIONES_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZFM_BP_RELACIONES_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZFM_BP_RELACIONES_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZFM_BP_RELACIONES_ProxyImpl proxy = new ZFM_BP_RELACIONES_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_BP");
        input.setValue( "0010003104" );
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("I_RELACION");
        input.setValue( "ZSUCOB" );
        inputParams.add( input );
         
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
