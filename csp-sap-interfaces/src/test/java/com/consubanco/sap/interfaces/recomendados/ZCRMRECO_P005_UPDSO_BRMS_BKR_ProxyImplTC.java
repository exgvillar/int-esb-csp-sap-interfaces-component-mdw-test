/**
 * 
 */
package com.consubanco.sap.interfaces.recomendados;

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
public class ZCRMRECO_P005_UPDSO_BRMS_BKR_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMRECO_P005_UPDSO_BRMS_BKR_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMRECO_P005_UPDSO_BRMS_BKR_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMRECO_P005_UPDSO_BRMS_BKR_ProxyImplTC(String name) {
		super(name);
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMRECO_P005_UPDSO_BRMS_BKR_ProxyImpl proxy = new ZCRMRECO_P005_UPDSO_BRMS_BKR_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_ORDSERV");
        input.setValue( "1525000144" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_MONTO_P");
        input.setValue( "700" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_ESTATUS");
        input.setValue( "E0003" );
        inputParams.add( input );
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
