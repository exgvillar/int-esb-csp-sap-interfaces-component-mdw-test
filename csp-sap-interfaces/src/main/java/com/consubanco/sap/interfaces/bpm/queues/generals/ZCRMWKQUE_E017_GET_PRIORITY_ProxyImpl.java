package com.consubanco.sap.interfaces.bpm.queues.generals;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.IStandardSAPProxy;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoTable;

public class ZCRMWKQUE_E017_GET_PRIORITY_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZCRMWKQUE_E017_GET_PRIORITY_ProxyImpl.class );
	
	public ZCRMWKQUE_E017_GET_PRIORITY_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMWKQUE_E017_GET_PRIORITY" );
			if(ft == null)
				throw new RuntimeException("ZCRMWKQUE_E017_GET_PRIORITY not found in SAP.");
			
			function = ft.getFunction();
	
			Iterator<ProxyInputParameter> iter = inputParamtersList.iterator();
			while( iter.hasNext() ) {
				ProxyInputParameter inputParam = iter.next();
				if( StringUtils.trimToNull( inputParam.getType() ) == null ) {
					function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );	
				} else {
					if( inputParam.getType().equals("java.util.date") )
						function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getDateValue() );
					else
						function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );
				}
			}
			
			log.info( function.getImportParameterList().toString() );
			function.execute(destination);
			
			JCoTable data = function.getExportParameterList().getTable("E_DATA");
			log.info( "" +  data.toString() );
			for (int i = 0; i < data.getNumRows(); i++, data.nextRow() ) {
				ZCRMWKQUE_E017_GET_PRIORITY_OutputData tableData = new ZCRMWKQUE_E017_GET_PRIORITY_OutputData();
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
				
				returnList.add( tableData );					
			}
			
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMWKQUE_E017_GET_PRIORITY :: " + function.getExportParameterList().getString("E_MESSAGE") , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
