/**
 * 
 */
package com.consupago.sap.interfaces.proxy.convenios;

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
 * @author ramon.becerra
 *
 */
public class ZFM_FECHAS_JURIDICO_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZFM_FECHAS_JURIDICO_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZFM_FECHAS_JURIDICO_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZFM_FECHAS_JURIDICO_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZFM_FECHAS_JURIDICO_ProxyImpl proxy = new ZFM_FECHAS_JURIDICO_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("PRODUCT_ID");
        input.setValue( "10000027" );
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
