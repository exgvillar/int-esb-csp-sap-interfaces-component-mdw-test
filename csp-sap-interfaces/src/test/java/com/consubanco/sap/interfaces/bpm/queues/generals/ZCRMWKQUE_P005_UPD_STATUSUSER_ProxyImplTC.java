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
public class ZCRMWKQUE_P005_UPD_STATUSUSER_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMWKQUE_P005_UPD_STATUSUSER_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMWKQUE_P005_UPD_STATUSUSER_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMWKQUE_P005_UPD_STATUSUSER_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMWKQUE_P005_UPD_STATUSUSER_ProxyImpl proxy = new ZCRMWKQUE_P005_UPD_STATUSUSER_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_ID_BP");
        input.setValue( "0010001950" ); 
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_USERNAME");
        input.setValue( "" );//brasso
        inputParams.add( input );  
        input = new ProxyInputParameter();
        input.setKey("I_CLV_ESTATUS");
        input.setValue( "1" );//2
        inputParams.add( input );  
        input = new ProxyInputParameter();
        input.setKey("I_DESC_ESTATUS");
        input.setValue( "ACTIVO" );//INACTIVO
        inputParams.add( input );  
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
       
        log.info( "Resurn Data :: " + returnData.toString() );
        
	}
}
