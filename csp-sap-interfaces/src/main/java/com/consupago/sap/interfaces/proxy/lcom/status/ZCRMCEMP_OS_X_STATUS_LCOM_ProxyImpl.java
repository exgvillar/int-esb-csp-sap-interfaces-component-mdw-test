package com.consupago.sap.interfaces.proxy.lcom.status;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoTable;

public class ZCRMCEMP_OS_X_STATUS_LCOM_ProxyImpl {

	private static Log log = LogFactory.getLog( ZCRMCEMP_OS_X_STATUS_LCOM_ProxyImpl.class );
	
	private final String RFC_NAME = "ZCRMCEMP_OS_X_STATUS_LCOM";
	
	public ZCRMCEMP_OS_X_STATUS_LCOM_ProxyImpl() {
		super();		
	}

	public ArrayList<ZCRMCEMP_OS_X_STATUS_LCOM_OutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<ZCRMCEMP_OS_X_STATUS_LCOM_OutputData> returnList = new ArrayList<ZCRMCEMP_OS_X_STATUS_LCOM_OutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( RFC_NAME );
			if(ft == null)
	            throw new RuntimeException( RFC_NAME + " not found in SAP.");
			
			function = ft.getFunction();
	
			Iterator<ProxyInputParameter> iter = inputParamtersList.iterator();
			while( iter.hasNext() ) {
				ProxyInputParameter inputParam = iter.next();
//				function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );
				
				if( StringUtils.trimToNull( inputParam.getType() ) == null ) {
					function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );	
				} else {
					if( inputParam.getType().equals("java.util.date") )
						function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getDateValue() );
					else
						function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );
				}
			}					
			
			function.execute(destination);
			
			JCoTable data = function.getExportParameterList().getTable("E_DATA");
			
			log.info( "" +  data.toString() );
			for (int i = 0; i < data.getNumRows(); i++, data.nextRow() ) {
			
				ZCRMCEMP_OS_X_STATUS_LCOM_OutputData tableData = new ZCRMCEMP_OS_X_STATUS_LCOM_OutputData();
				
				tableData.setDocumentId( data.getString("OBJECT_ID") );
				tableData.setStatusId( data.getString("STAT") );				
				tableData.setStatus( data.getString("TXT30") );				
				tableData.setCompetidor( data.getString("NOM_COMP") );
				tableData.setAmount( data.getDouble("ZZFLD00006U") );				
				
				tableData.setRfc( data.getString("IDNUMBER") );
				tableData.setAccountNumber( data.getString("BANKN") );
				tableData.setBankId( data.getString("BANKL") );
				
				/*
				 * TODO: Reemplazar estos valores por los correctos
				 */
				tableData.setRequestId( data.getString("OBJECT_ID_SOL") );
				tableData.setStatusRequestId( data.getString("STAT_SOL") );
				tableData.setStatusRequest( data.getString("TXT30_SOL") );
				
				returnList.add( tableData );				
				
			}
			
		} catch (AbapException e) {
			log.error(" executing function " + RFC_NAME , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
