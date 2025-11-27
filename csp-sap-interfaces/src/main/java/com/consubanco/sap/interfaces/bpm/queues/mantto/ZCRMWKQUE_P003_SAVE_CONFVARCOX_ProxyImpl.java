package com.consubanco.sap.interfaces.bpm.queues.mantto;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoTable;

public class ZCRMWKQUE_P003_SAVE_CONFVARCOX_ProxyImpl {

	private static Log log = LogFactory.getLog( ZCRMWKQUE_P003_SAVE_CONFVARCOX_ProxyImpl.class );
	
	
	public ZCRMWKQUE_P003_SAVE_CONFVARCOX_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ZCRMWKQUE_P003_SAVE_CONFVARCOX_OutputData> dataList ) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;
		
		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMWKQUE_P003_SAVE_CONFVARCOX" );
			if(ft == null)
				throw new RuntimeException("ZCRMWKQUE_P003_SAVE_CONFVARCOX not found in SAP.");
			
			function = ft.getFunction();
			
			// record - table params
			JCoTable tableInput = function.getImportParameterList().getTable("IT_CONF_VAR_COX");
			if( dataList != null ){
				Iterator<ZCRMWKQUE_P003_SAVE_CONFVARCOX_OutputData> iterRecord = dataList.iterator();
				while( iterRecord.hasNext() ){
					tableInput.appendRow();
					ZCRMWKQUE_P003_SAVE_CONFVARCOX_OutputData  record = iterRecord.next();
					
					tableInput.setValue("ZCLAVE", record.getId() );
					tableInput.setValue("ZNOMBRE", record.getFieldName() );
					tableInput.setValue("ZTIPO", record.getType() );
					tableInput.setValue("ZVALOR", record.getValue() );
					tableInput.setValue("ZCALIF_PRIORI", record.getRatePriority() );
					tableInput.setValue("ZSOLICITADO_POR", record.getRequestedBy() );
					tableInput.setValue("ZAUTORIZADO", record.isAuthorized() ? "X" : "" );
					tableInput.setValue("ZAUTORIZADO_POR", record.getAuthorizedBy() );
					tableInput.setValue("ZACTIVO", record.isActive() ? "X" : "" );
				}
			}
			
			log.info("RFC CRM Input :: " + function.getImportParameterList().getTable("IT_CONF_VAR_COX").toString() );
			function.execute(destination);
			
			ZCRMWKQUE_P003_SAVE_CONFVARCOX_OutputData resultData = new ZCRMWKQUE_P003_SAVE_CONFVARCOX_OutputData();
			resultData.setResult( function.getExportParameterList().getString("E_EXITO").equals("X") ? true : false );
			resultData.setMessage( function.getExportParameterList().getString("E_MESSAGE") );

			returnList.add( resultData );
			
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMWKQUE_P003_SAVE_CONFVARCOX :: " + function.getExportParameterList().getString("E_MESSAGE") , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
