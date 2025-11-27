/**
 * 
 */
package com.consupago.sap.interfaces.proxy.cotizador;

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
public class ZRFC_GET_CALCULOCAT_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZRFC_GET_CALCULOCAT_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZRFC_GET_CALCULOCAT_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZRFC_GET_CALCULOCAT_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZRFC_GET_CALCULOCAT_ProxyImpl proxy = new ZRFC_GET_CALCULOCAT_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("P_PRODU_ID");
        input.setValue( "554" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("P_MONTOCRE");
        input.setValue( "25000" );
        input.setType("java.lang.Double");
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("P_NUMPAGOS");
        input.setValue( "18" );
        input.setType("java.lang.Integer");
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("P_FRECUENC");
        input.setValue( "Q" );
        inputParams.add( input );
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
