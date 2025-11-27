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
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author haydee.sanchez
 *
 */
public class ZCRMWKQUE_E010_GET_MASTERQUEUE_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMWKQUE_E010_GET_MASTERQUEUE_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMWKQUE_E010_GET_MASTERQUEUE_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMWKQUE_E010_GET_MASTERQUEUE_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMWKQUE_E010_GET_MASTERQUEUE_ProxyImpl proxy = new ZCRMWKQUE_E010_GET_MASTERQUEUE_ProxyImpl();
        
        ZCRMWKQUE_E010_GET_MASTERQUEUE_OutputData data = new ZCRMWKQUE_E010_GET_MASTERQUEUE_OutputData();
        
        data.setProcessId( "" );//70bc269cb72911e6942d000000526c32
        data.setTaskId( "" );//TASK70bc269cb72911e6942d000000526c32
        data.setCorrelationId( "" );//CORR70bc269cb72911e6942d000
        data.setFolioApplication( "0050385535" );//0050385535
        data.setApplicationStatusKey( "" );//E0043
        data.setAssignedUser( "" );//brasso o *
        data.setExecutorRole( "" );//CAPTURISTA
        data.setNotificationRole( "" );//SUPERVISOR_COX
        data.setReprocessingNumber( 1 );
        data.setRecapture( true );
        data.setTaskPriorityKey( "" );//1
        data.setTaskPriorityDesc( "" );//MUY ALTA
        data.setManualAssignationUser( true );
                
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, data );
       
        log.info( "Resurn Data :: " + returnData.toString() );
        
	}
}
