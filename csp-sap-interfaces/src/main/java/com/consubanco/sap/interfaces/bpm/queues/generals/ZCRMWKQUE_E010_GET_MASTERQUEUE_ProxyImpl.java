package com.consubanco.sap.interfaces.bpm.queues.generals;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoTable;

public class ZCRMWKQUE_E010_GET_MASTERQUEUE_ProxyImpl {

	private static Log log = LogFactory.getLog( ZCRMWKQUE_E010_GET_MASTERQUEUE_ProxyImpl.class );
	
	public ZCRMWKQUE_E010_GET_MASTERQUEUE_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ZCRMWKQUE_E010_GET_MASTERQUEUE_OutputData inputData ) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMWKQUE_E010_GET_MASTERQUEUE" );
			if(ft == null)
				throw new RuntimeException("ZCRMWKQUE_E010_GET_MASTERQUEUE not found in SAP.");
			
			function = ft.getFunction();
	
			function.getImportParameterList().setValue("I_PROCESS_ID", inputData.getProcessId() );
			function.getImportParameterList().setValue("I_TASK_ID", inputData.getTaskId() );
			function.getImportParameterList().setValue("I_CORRELATION_ID", inputData.getCorrelationId() );
			function.getImportParameterList().setValue("I_FOLIO", inputData.getFolioApplication() );
			function.getImportParameterList().setValue("I_STATUS_ID", inputData.getApplicationStatusKey() );
			function.getImportParameterList().setValue("I_ASSIGNED_USR", inputData.getAssignedUser() );
			function.getImportParameterList().setValue("I_EXCECUTE", inputData.getExecutorRole() );
			function.getImportParameterList().setValue("I_NOTIF_GRP", inputData.getNotificationRole() );
			function.getImportParameterList().setValue("I_REPROC_NUM", inputData.getReprocessingNumber() <= 0 ? "" : inputData.getReprocessingNumber() );
			function.getImportParameterList().setValue("I_RECAPTURA", inputData.isRecapture() ? "X" : "" );
			function.getImportParameterList().setValue("I_PRIORITY_ID", inputData.getTaskPriorityKey() );
			function.getImportParameterList().setValue("I_PRIORITY_DESC", inputData.getTaskPriorityDesc() );
			function.getImportParameterList().setValue("I_ASSIG_USER_MAN", inputData.isManualAssignationUser() ? "X" : "" );
			
			log.info("RFC Input :: " + function.getImportParameterList().toString() );
			function.execute(destination);
			
			JCoTable data = function.getExportParameterList().getTable("E_DATA");
			log.info( "" +  data.toString() );
			for (int i = 0; i < data.getNumRows(); i++, data.nextRow() ) {
				ZCRMWKQUE_E010_GET_MASTERQUEUE_OutputData tableData = new ZCRMWKQUE_E010_GET_MASTERQUEUE_OutputData();
				
				tableData.setProcessId( data.getString("ZPROCESS_ID") );
				tableData.setTaskId( data.getString("ZTASK_ID") );
				tableData.setCorrelationId( data.getString("ZCORRELATION_ID") );
				tableData.setApplicationStatusKey( data.getString("ZSTATUS_ID") );
				tableData.setApplicationStatusDesc( data.getString("ZDESC_STATUS") );
				tableData.setFolioApplication( data.getString("ZFOLIO_APPLI") );
				tableData.setCreateDate( data.getDate("ZCREATE_DATE") );
				tableData.setCreateHour( data.getString("ZCREATE_TIME") );
				tableData.setLastUpdateDate( data.getDate("ZUPDATE_DATE") );
				tableData.setLastUpdateHour( data.getString("ZUPDATE_TIME") );
				tableData.setAssignedUser( data.getString("ZASSIGN_USER") );
				tableData.setExecutorRole( data.getString("ZEXCEC_ROL") );
				tableData.setNotificationRole( data.getString("ZNOTIF_GROUP") );
				tableData.setRecapture( data.getString("ZRECAPTURA").equals("X") ? true : false );
				tableData.setElapsedTimeMins( data.getLong("ZLAPSED_TIME") );
				tableData.setLastAssignationDate( data.getDate("ZLAST_ASIG_DATE") );
				tableData.setLastAssignationHour( data.getString("ZLAST_ASIG_HOUR") );
				tableData.setReprocessingNumber( data.getInt("ZREPORCESS_NO") );
				tableData.setTaskPriorityKey( data.getString("ZTASK_PRIORYTY") );
				tableData.setTaskPriorityDesc( data.getString("ZDESC_TASK_PRIORY") );
				tableData.setManualAssignationUser( data.getString("ZASSIG_USER_MAN").equals("X") ? true : false );
				tableData.setWaitTime( data.getLong("ZWAIT_TIME") );
				tableData.setRate( data.getInt("ZCALIF_RATE") );
				tableData.setRecaptureNumber( data.getInt("ZNUM_RECAPTURA") );
				
				returnList.add( tableData );					
			}
	
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMWKQUE_E010_GET_MASTERQUEUE :: " + function.getExportParameterList().getString("E_MESSAGE") , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
