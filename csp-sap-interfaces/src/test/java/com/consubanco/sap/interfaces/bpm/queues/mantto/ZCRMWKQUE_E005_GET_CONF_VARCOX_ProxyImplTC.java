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
public class ZCRMWKQUE_E005_GET_CONF_VARCOX_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMWKQUE_E005_GET_CONF_VARCOX_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMWKQUE_E005_GET_CONF_VARCOX_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMWKQUE_E005_GET_CONF_VARCOX_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMWKQUE_E005_GET_CONF_VARCOX_ProxyImpl proxy = new ZCRMWKQUE_E005_GET_CONF_VARCOX_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_CLAVE");
        input.setValue( "" ); //1
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_NOMBRE");
        input.setValue( "fecha-valida" );//monto-solicitado
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_TIPO");
        input.setValue( "" );//2
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_VALOR");
        input.setValue( "" );//90000
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_CALIF_PRIORI");
        input.setValue( "" );//5
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_SOLICITADO_POR");
        input.setValue( "" );//hsanchezag
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_AUTORIZADO");
        input.setValue( "" );//X
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_AUTORIZADO_POR");
        input.setValue( "" );//rbecerra
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_ACTIVO");
        input.setValue( "" );//
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
       
        log.info( "Resurn Data :: " + returnData.toString() );
        
	}
}
