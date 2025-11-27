/**
 * 
 */
package com.consubanco.sap.interfaces.bpm.queues.mantto;

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
public class ZCRMWKQUE_P002_UPDPRIORICONVE_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMWKQUE_P002_UPDPRIORICONVE_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMWKQUE_P002_UPDPRIORICONVE_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMWKQUE_P002_UPDPRIORICONVE_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMWKQUE_P002_UPDPRIORICONVE_ProxyImpl proxy = new ZCRMWKQUE_P002_UPDPRIORICONVE_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_ID_CONVENIO");
        input.setValue( "10000027" ); //10000027
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_ID_CATEGORIA");
        input.setValue( "" );//RETN
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_CALIFICACION");
        input.setValue( "2" );//
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
       
        log.info( "Resurn Data :: " + returnData.toString() );
        
	}
}
