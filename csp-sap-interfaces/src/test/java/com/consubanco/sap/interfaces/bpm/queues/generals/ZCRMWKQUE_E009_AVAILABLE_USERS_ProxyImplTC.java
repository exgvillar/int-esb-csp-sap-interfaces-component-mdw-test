/**
 * 
 */
package com.consubanco.sap.interfaces.bpm.queues.generals;

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
public class ZCRMWKQUE_E009_AVAILABLE_USERS_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMWKQUE_E009_AVAILABLE_USERS_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMWKQUE_E009_AVAILABLE_USERS_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMWKQUE_E009_AVAILABLE_USERS_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMWKQUE_E009_AVAILABLE_USERS_ProxyImpl proxy = new ZCRMWKQUE_E009_AVAILABLE_USERS_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_CLAVE_AREA");
        input.setValue( "" );//2
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_DESC_AREA");
        input.setValue( "" );//AUTORIZACION
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_CLAVE_ESTATUS");
        input.setValue( "1" );//1
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_DESC_ESTATUS");//ACTIVO
        input.setValue( "" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_CLAVE_CONVENIO");
        input.setValue( "" );//10000027
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_CLV_CAT_PROD");
        input.setValue( "" );//LCOM
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_CANAL_ORIGEN");
        input.setValue( "Z01" );//Z01
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_NUM_SOL_ASIG");
        input.setValue( "0" );//2
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_NUM_REG_MAX");
        input.setValue( "50" );//20
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_AVAIL_USER");
        input.setValue( "" );//BRASSO
        inputParams.add( input );
                
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
       
        log.info( "Resurn Data :: " + returnData.toString() );
        
	}
}
