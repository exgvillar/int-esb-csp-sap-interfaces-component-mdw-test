/**
 * 
 */
package com.consubanco.sap.interfaces.debtBalanceInsurance;

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
 * @author omar.corona
 *
 */
public class ZCRMSGDEU_ORDENSERV_X_ESTATUS_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMSGDEU_ORDENSERV_X_ESTATUS_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMSGDEU_ORDENSERV_X_ESTATUS_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMSGDEU_ORDENSERV_X_ESTATUS_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMSGDEU_ORDENSERV_X_ESTATUS_ProxyImpl proxy = new ZCRMSGDEU_ORDENSERV_X_ESTATUS_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_ID_ESTATUS");
        input.setValue( "E0001" );
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
