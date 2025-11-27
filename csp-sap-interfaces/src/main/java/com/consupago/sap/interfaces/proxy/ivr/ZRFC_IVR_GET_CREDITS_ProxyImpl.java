package com.consupago.sap.interfaces.proxy.ivr;

import java.text.SimpleDateFormat;
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


public class ZRFC_IVR_GET_CREDITS_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZRFC_IVR_GET_CREDITS_ProxyImpl.class );
	
	public ZRFC_IVR_GET_CREDITS_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZRFC_IVR_GET_CREDITS" );
			if(ft == null)
				throw new RuntimeException("ZRFC_IVR_GET_CREDITS not found in SAP.");
			
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
			
			
			function.execute(destination);
			
			JCoTable data = function.getExportParameterList().getTable("E_CREDITREQUEST");
			ZRFC_IVR_GET_CREDITS_OutputData output = new ZRFC_IVR_GET_CREDITS_OutputData();
			ArrayList<TE_CREDITREQUEST_OutputData> creditRequestsList = new ArrayList<TE_CREDITREQUEST_OutputData>();
			ArrayList<TE_MESSAGE_OutputData> messages = new ArrayList<TE_MESSAGE_OutputData>();
			
			log.info( "" +  data.toString() );
			for (int i = 0; i < data.getNumRows(); i++, data.nextRow() ) {
				TE_CREDITREQUEST_OutputData tableData = new TE_CREDITREQUEST_OutputData();
				
				tableData.setCreditRequestId( data.getString("CREDITREQUESTID") );
				tableData.setStatusId( data.getString("IDSTATUS") );
				tableData.setStatus( data.getString("DESCRIPTION") );
				tableData.setCreditDateRequest( data.getDate("CREDITTEREQUEST") );
				tableData.setRequestedAmount( data.getDouble("REQUESTEDAMOUNT") );
				tableData.setSiglaCompany( data.getString("SIGLA_COMPANY") );
				tableData.setCompany( data.getString("COMPANY") );
	
				SimpleDateFormat dFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
				tableData.setLastDateStatus( dFormat.parse( data.getString("LASTDATEREQUEST") ) );
				
				JCoTable dataIncidence = data.getTable("INCIDENCIAS");
				ArrayList<TE_INCIDENCE_OutputData> incidencesList = new ArrayList<TE_INCIDENCE_OutputData>();		
				for (int j = 0; j < dataIncidence.getNumRows(); j++, dataIncidence.nextRow() ) {
					TE_INCIDENCE_OutputData tableDataInc = new TE_INCIDENCE_OutputData();
					
					tableDataInc.setId( dataIncidence.getString("ID_INCIDENCIA") );
					tableDataInc.setCauseId( dataIncidence.getString("ID_CAUSA") );
					tableDataInc.setCause( dataIncidence.getString("DE_CAUSA") );
					tableDataInc.setMotiveId( dataIncidence.getString("ID_MOTIVO") );
					tableDataInc.setMotive( dataIncidence.getString("DE_MOTIVO") );
					tableDataInc.setDescExt( dataIncidence.getString("DESC_EXT") );
					
					incidencesList.add( tableDataInc );
				}
				tableData.setIncidences( incidencesList );
				
				creditRequestsList.add( tableData );
			}
					
				
			
			TE_MESSAGE_OutputData tableData = new TE_MESSAGE_OutputData();
			
			tableData.setKey( "" );
			tableData.setDescription( function.getExportParameterList().getString("E_MESSAGE")  );
			tableData.setClasification( "" );
			messages.add( tableData );
				
			output.setCreditRequests( creditRequestsList );
			output.setMessages(messages);
			returnList.add( output );
		} catch (AbapException e) {
			log.error(" executing function " + "ZRFC_IVR_GET_CREDITS" , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}	
	
	
}
