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
 * @author hsanchez
 *
 */
public class ZCRMSGDEU_UPDOSSEGDEUD_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMSGDEU_UPDOSSEGDEUD_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMSGDEU_UPDOSSEGDEUD_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMSGDEU_UPDOSSEGDEUD_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMSGDEU_UPDOSSEGDEUD_ProxyImpl proxy = new ZCRMSGDEU_UPDOSSEGDEUD_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_ID_ORDEN_SERVICIO");
        input.setValue( "1710000002" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_ESTATUS");
        input.setValue( "E0003" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_TEXTID");
        input.setValue( "" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_OBSERVACIONES");
        input.setValue( "Ejemplo1" );
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
