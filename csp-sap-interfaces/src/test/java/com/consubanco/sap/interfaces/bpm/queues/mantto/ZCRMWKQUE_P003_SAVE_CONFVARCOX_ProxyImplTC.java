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
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author haydee.sanchez
 *
 */
public class ZCRMWKQUE_P003_SAVE_CONFVARCOX_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMWKQUE_P003_SAVE_CONFVARCOX_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMWKQUE_P003_SAVE_CONFVARCOX_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMWKQUE_P003_SAVE_CONFVARCOX_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMWKQUE_P003_SAVE_CONFVARCOX_ProxyImpl proxy = new ZCRMWKQUE_P003_SAVE_CONFVARCOX_ProxyImpl();
        
        ArrayList<ZCRMWKQUE_P003_SAVE_CONFVARCOX_OutputData> paramsList = new ArrayList<ZCRMWKQUE_P003_SAVE_CONFVARCOX_OutputData>();
        ZCRMWKQUE_P003_SAVE_CONFVARCOX_OutputData data = new ZCRMWKQUE_P003_SAVE_CONFVARCOX_OutputData();
        data.setId( "" );
        data.setFieldName( "monto-solicitado" );
        data.setType( "3" );
        data.setValue( "90000" );
        data.setRatePriority( 5 );
        data.setRequestedBy( "hsanchez" );
        data.setAuthorized( false );
        data.setAuthorizedBy( "rbecerra" );
        data.setActive( false );
        
        paramsList.add( data );
		        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, paramsList );
       
        log.info( "Resurn Data :: " + returnData.toString() );
        
	}
}
