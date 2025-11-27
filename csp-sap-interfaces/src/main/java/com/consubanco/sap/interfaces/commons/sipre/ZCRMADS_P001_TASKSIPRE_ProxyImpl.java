package com.consubanco.sap.interfaces.commons.sipre;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.format.SAPFormatter;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.ProxyInputParameterWithTable;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoTable;

public class ZCRMADS_P001_TASKSIPRE_ProxyImpl {
	
	private static Log log = LogFactory.getLog(ZCRMADS_P001_TASKSIPRE_ProxyImpl.class);
	private static final String RFC = "ZCRMADS_P001_TASKSIPRE";
	
	public List<IProxyOutputData> executeRemoteFunction(JCoDestination destination,
			ProxyInputParameterWithTable inputParams) throws Exception {
		
		ZCRMADS_P001_TASKSIPRE_OutputData outputData = new ZCRMADS_P001_TASKSIPRE_OutputData();
		List<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;
		
		try {			
			ft = destination.getRepository().getFunctionTemplate( RFC );
			if( ft == null ) {
				throw new RuntimeException(RFC + " not found in SAP.");
			}
			
			function = ft.getFunction();
			
			Iterator<ProxyInputParameter> iter = inputParams.getGeneralParam().iterator();
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
					
			//Se setean los datos de entrada de la tabla I_DOCUMENTS
			JCoTable outTable = function.getImportParameterList().getTable("I_DOCUMENTS");
			
			Iterator<Object> iterObject = inputParams.getRecordParam().iterator();
			while( iterObject.hasNext() ){
				outTable.appendRow();
				List<ProxyInputParameter> paramsList = (ArrayList<ProxyInputParameter>)iterObject.next();
				Iterator<ProxyInputParameter> iterProxy = paramsList.iterator();
				while( iterProxy.hasNext() ) {
					ProxyInputParameter input = iterProxy.next();
					if( StringUtils.trimToNull( input.getType() ) == null ) {
						outTable.setValue( input.getKey(), input.getValue() );
						
						if ("BIN".equals( input.getKey() ) ){
							byte[] value = SAPFormatter.convertFileBinario( input.getValue());							
							outTable.setValue( input.getKey(), value );
							log.info("BIN: " + value.length);
						} else{
							outTable.setValue( input.getKey(), input.getValue() );
						}
						
					} else {
						if( input.getType().equals("java.util.date") )
							outTable.setValue( input.getKey(), input.getDateValue() );
						else
							outTable.setValue( input.getKey(), input.getValue() );
					}
				}
			}

			log.info(function.getImportParameterList().toString());
			
			log.info(outTable.toString());	
			
			function.execute(destination);
			
			String taskId = function.getExportParameterList().getString("E_ID_TAKS");
			String success = function.getExportParameterList().getString("E_SUCCESS");
			String message = function.getExportParameterList().getString("E_MESSAGE");			
		
			log.info(function.getExportParameterList().toString());
			
			outputData.setTaskId(taskId);
			outputData.setSuccess(false);
			outputData.setMessage(message);	
			
			if ("X".equalsIgnoreCase(success)) {
				outputData.setSuccess(true);
			}
					
			returnList.add(outputData);
			
			log.info( "RFC :: " + RFC );
			log.info( "Return data ---> " + returnList.toString());
			
		} catch (AbapException e) {
			log.error(" executing function " + RFC);
			log.error(e);
			throw e;
		}

		return (returnList);
	}
}
