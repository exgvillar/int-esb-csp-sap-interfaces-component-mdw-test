package com.consubanco.sap.interfaces.bpm.queues.generals;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;

public class ZCRMWKQUE_P006_ADDUPD_MASTERQ_ProxyImpl {

	private static Log log = LogFactory.getLog( ZCRMWKQUE_P006_ADDUPD_MASTERQ_ProxyImpl.class );
	
	
	public ZCRMWKQUE_P006_ADDUPD_MASTERQ_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ZCRMWKQUE_P006_ADDUPD_MASTERQ_OutputData data ) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;
		
		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMWKQUE_P006_ADDUPD_MASTERQ" );
			if(ft == null)
				throw new RuntimeException("ZCRMWKQUE_P006_ADDUPD_MASTERQ not found in SAP.");
			
			function = ft.getFunction();
			
			function.getImportParameterList().setValue("I_FOLIO_APPLI", data.getFolioApplication() );
			function.getImportParameterList().setValue("I_PROCESS_ID", data.getProcessId() );
			function.getImportParameterList().setValue("I_TASK_ID", data.getTaskId() );
			function.getImportParameterList().setValue("I_CORRELATION_ID", data.getCorrelationId() );
			function.getImportParameterList().setValue("I_STATUS_ID", data.getApplicationStatusKey() );
			function.getImportParameterList().setValue("I_STATUS_DESC", data.getApplicationStatusDesc() );
			function.getImportParameterList().setValue("I_LAST_ASG_DATE", data.getLastAssignationDate() );
			function.getImportParameterList().setValue("I_LAST_ASG_HOUR", data.getLastAssignationHour() );
			function.getImportParameterList().setValue("I_ASSIGNED_USER", data.getAssignedUser() );
			function.getImportParameterList().setValue("I_EXECUTER_ROL", data.getExecutorRole() );
			function.getImportParameterList().setValue("I_NOTIF_ROL", data.getNotificationRole() );
			function.getImportParameterList().setValue("I_REPROCES_NUM", data.getReprocessingNumber() );
			function.getImportParameterList().setValue("I_RECAPTURE", data.isRecapture() ? "X" : "" );
			function.getImportParameterList().setValue("I_EXECUTED", data.isExecuted() ? "X" : "" );
			function.getImportParameterList().setValue("I_TIEMPO_TRANS", data.getElapsedTimeMins() > 0 ? data.getElapsedTimeMins() : "" );
			function.getImportParameterList().setValue("I_TASK_PRIOR_ID", data.getTaskPriorityKey() );
			function.getImportParameterList().setValue("I_TASK_PRIOR_DES", data.getTaskPriorityDesc() );
			function.getImportParameterList().setValue("I_ASSIG_USER_MAN", data.isManualAssignationUser() ? "X" : "" );
			function.getImportParameterList().setValue("I_CALIF_RATE", data.getRate() );
			function.getImportParameterList().setValue("I_NUM_RECAPTURA", data.getRecaptureNumber() );
			function.getImportParameterList().setValue("I_BORRADO", data.isDeleteRecord() ? "X" : "" );
			
			log.info("RFC CRM Input :: " + function.getImportParameterList().toString() );
			function.execute(destination);
			
			data.setResult( function.getExportParameterList().getString("E_EXITO").equals("X") ? true : false );
			data.setMessage( function.getExportParameterList().getString("E_MESSAGE") );

			returnList.add( data );
			
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMWKQUE_P006_ADDUPD_MASTERQ :: " + function.getExportParameterList().getString("E_MESSAGE") , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
