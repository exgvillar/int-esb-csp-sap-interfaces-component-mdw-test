package com.consubanco.sap.interfaces.dwh.origination;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoTable;

public class ZRFC_GEN_GET_DATSOL_ProxyImpl {

	private static Log log = LogFactory.getLog( ZRFC_GEN_GET_DATSOL_ProxyImpl.class );
	
	public ZRFC_GEN_GET_DATSOL_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ZRFC_GEN_GET_DATSOL_InputData> inputParamsList ) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZRFC_GEN_GET_DATSOL" );
			if(ft == null)
				throw new RuntimeException("ZRFC_GEN_GET_DATSOL not found in SAP.");
			
			function = ft.getFunction();
	
			JCoTable inputTable = function.getImportParameterList().getTable("I_SOLICITUDES");
			Iterator<ZRFC_GEN_GET_DATSOL_InputData> iter = inputParamsList.iterator();
			while( iter.hasNext() ) {
				ZRFC_GEN_GET_DATSOL_InputData inputRow = iter.next();
				inputTable.appendRow();
				inputTable.setValue("SOLICITUD", StringUtils.trimToEmpty( inputRow.getRequestId() ) );				
			}
			
			
			function.execute(destination);
			
			JCoTable data = function.getExportParameterList().getTable("E_SOLICITUDES");
						
			log.info( "" +  data.toString() );
			for (int i = 0; i < data.getNumRows(); i++, data.nextRow() ) {
				ZRFC_GEN_GET_DATSOL_OutputData tableData = new ZRFC_GEN_GET_DATSOL_OutputData();
				
				tableData.setRequestId(  data.getString("CREDITREQUESTID") );
				tableData.setStatusId(  data.getString("IDSTATUS") );
				tableData.setStatusDescription( data.getString("DESCRIPTION") );
				tableData.setRequestDate( data.getDate("CREDITTEREQUEST") );
				
				SimpleDateFormat dFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
				tableData.setLastStatusDate( dFormat.parse( data.getString("LASTDATEREQUEST") ) );
				tableData.setRequestedAmount( data.getDouble("REQUESTEDAMOUNT") );
				tableData.setSiglaEmpresa( data.getString("SIGLA_COMPANY") );
				tableData.setNombreEmpresa( data.getString("COMPANY") );
				
				
				returnList.add( tableData );				
			}
				
	
		} catch (AbapException e) {
			log.error(" executing function " + "ZRFC_GEN_GET_DATSOL" , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
