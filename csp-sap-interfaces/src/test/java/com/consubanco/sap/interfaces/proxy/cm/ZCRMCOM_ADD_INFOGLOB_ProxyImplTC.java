/**
 * 
 */
package com.consubanco.sap.interfaces.proxy.cm;

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
public class ZCRMCOM_ADD_INFOGLOB_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMCOM_ADD_INFOGLOB_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMCOM_ADD_INFOGLOB_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMCOM_ADD_INFOGLOB_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMCOM_ADD_INFOGLOB_ProxyImpl proxy = new ZCRMCOM_ADD_INFOGLOB_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_SUCURSAL");
        input.setValue( "50000036" ); 
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("I_NUMSOL");
        input.setValue( "0050385718" ); 
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("I_MONTO_SOLI");
        input.setValue( "25000" ); 
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("I_MONTO_CNCA");
        input.setValue( "5000" ); 
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("I_MONTO_INTE");
        input.setValue( "3000" ); 
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
       
        log.info( "Resurn Data :: " + returnData.toString() );
        
	}
}
