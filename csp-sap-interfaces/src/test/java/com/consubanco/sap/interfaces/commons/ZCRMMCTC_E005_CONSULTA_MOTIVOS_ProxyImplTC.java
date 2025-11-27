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
public class ZCRMMCTC_E005_CONSULTA_MOTIVOS_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMMCTC_E005_CONSULTA_MOTIVOS_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMMCTC_E005_CONSULTA_MOTIVOS_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMMCTC_E005_CONSULTA_MOTIVOS_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMMCTC_E005_CONSULTA_MOTIVOS_ProxyImpl proxy = new ZCRMMCTC_E005_CONSULTA_MOTIVOS_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_CVEUSO");
        input.setValue( "TD" );
        inputParams.add( input );
       
        input = new ProxyInputParameter();
        input.setKey("I_IDCAUSA");
        input.setValue( "1" );
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
