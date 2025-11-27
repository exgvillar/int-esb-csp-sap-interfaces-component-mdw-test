/**
 * 
 */
package com.consubanco.sap.interfaces.bpm.queues.generals;

import java.sql.Date;
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
public class ZCRMWKQUE_P006_ADDUPD_MASTERQ_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMWKQUE_P006_ADDUPD_MASTERQ_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMWKQUE_P006_ADDUPD_MASTERQ_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMWKQUE_P006_ADDUPD_MASTERQ_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMWKQUE_P006_ADDUPD_MASTERQ_ProxyImpl proxy = new ZCRMWKQUE_P006_ADDUPD_MASTERQ_ProxyImpl();
        
        ZCRMWKQUE_P006_ADDUPD_MASTERQ_OutputData data = new ZCRMWKQUE_P006_ADDUPD_MASTERQ_OutputData();
        data.setFolioApplication("0050385535");
        data.setProcessId("70bc269cb72911e6942d000000526c32");
        data.setTaskId("TASK70bc269cb72911e6942d000000526c32");
        data.setCorrelationId("CORR70bc269cb72911e6942d000");
        data.setApplicationStatusKey("E0043");
        data.setApplicationStatusDesc("PROCESO ANALISIS CAPTURA COX");
        data.setLastAssignationDate( Date.valueOf("2016-12-04") );
        data.setLastAssignationHour("18:30");
        data.setAssignedUser("brasso");
        data.setExecutorRole("CAPTURA");
        data.setNotificationRole("SUPERVISOR_COX");
        data.setReprocessingNumber( 1 );
        data.setRecapture( false );
        data.setExecuted( true );
        data.setElapsedTimeMins( 0 );
        data.setTaskPriorityKey( "1" );
        data.setTaskPriorityDesc( "MUY ALTA" );
        data.setManualAssignationUser( true );
        data.setRate( 8 );
        data.setRecaptureNumber( 1 );
        data.setDeleteRecord( false );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, data );
       
        log.info( "Resurn Data :: " + returnData.toString() );
        
	}
}
