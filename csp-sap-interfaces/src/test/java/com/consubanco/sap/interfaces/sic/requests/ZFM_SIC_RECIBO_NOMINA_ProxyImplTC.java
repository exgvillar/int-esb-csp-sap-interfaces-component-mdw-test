/**
 * 
 */
package com.consubanco.sap.interfaces.sic.requests;

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
public class ZFM_SIC_RECIBO_NOMINA_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZFM_SIC_RECIBO_NOMINA_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZFM_SIC_RECIBO_NOMINA_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZFM_SIC_RECIBO_NOMINA_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZFM_SIC_RECIBO_NOMINA_ProxyImpl proxy = new ZFM_SIC_RECIBO_NOMINA_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("P_SOLICITUD");
        input.setValue( "0050029944" );
        inputParams.add( input );
         
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
