package com.consubanco.sap.interfaces.cxn.csbe;

/**
 * hsanchez
 */
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoTable;


public class ZCRMCTEM_E002_SOLBYCLIENT_ProxyImpl {

	private static Log log = LogFactory.getLog( ZCRMCTEM_E002_SOLBYCLIENT_ProxyImpl.class );
	
	public ZCRMCTEM_E002_SOLBYCLIENT_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList ) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMCTEM_E002_SOLBYCLIENT" );
			if(ft == null)
				throw new RuntimeException("ZCRMCTEM_E002_SOLBYCLIENT not found in SAP.");
			
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
			
			log.info( "INPUT DATA :: " + function.getImportParameterList().toString() );
		
			function.execute(destination);

			JCoTable data = function.getExportParameterList().getTable("ET_RESULT");
			
			log.info( "" +  data.toString() );
			for (int i = 0; i < data.getNumRows(); i++, data.nextRow() ) {
				ZCRMCTEM_E002_SOLBYCLIENT_OutputData tableData = new ZCRMCTEM_E002_SOLBYCLIENT_OutputData();
				tableData.setRequestId( data.getString("NUM_SOLICITUD") );
				tableData.setCreateDate( data.getDate("FECHA_SOLICITUD") );
				tableData.setLastStatusDate( data.getDate("FECHA_ULT_STATUS") );
				tableData.setStatusId( data.getString("ID_ESTATUS") );
				tableData.setStatusDesc( data.getString("DESC_ESTATUS") );
				tableData.setRequestAmount( data.getDouble("MONTO_SOLICITADO") );
				tableData.setDispersionAuth( data.getString("AUTORIZADO_DISP").equals("X") ? true : false );
				tableData.setBpId( data.getString("BP") );
				tableData.setRfc( data.getString("RFC") );
				tableData.setName1( data.getString("NOMBRE1") );
				tableData.setName2( data.getString("NOMBRE2") );
				tableData.setLastName1( data.getString("APELLIDO_P") );
				tableData.setLastName2( data.getString("APELLIDO_M") );
				tableData.setCnca( StringUtils.trimToEmpty(data.getString("CNCA")).equals("X") ? true : false );
				tableData.setSecondDisposition( StringUtils.trimToEmpty(data.getString("SEGUNDA_DISPO")).equals("X") ? true : false );
				tableData.setLcom( StringUtils.trimToEmpty(data.getString("LCOM")).equals("X") ? true : false );
				tableData.setNewCredit( StringUtils.trimToEmpty(data.getString("CREDITO_NUEVO")).equals("X") ? true : false );
				tableData.setIntercompany( StringUtils.trimToEmpty(data.getString("INTERCOMPANIA")).equals("X") ? true : false );
				tableData.setDispositionNumber( data.getInt("NUM_DISPO") );
				tableData.setIntercompanyAmount( data.getDouble("MONTO_INTER") );
				tableData.setConvenioCRM( data.getString("ID_CONVENIO_CRM") );
				tableData.setConvenioBRMS( data.getString("ID_CONVENIO_BRMS") );
				tableData.setConvenioDesc( data.getString("DESC_CONVENIO") );
				tableData.setCompanySigla( data.getString("CLV_EMPRESA") );				
				tableData.setCompanyDesc( data.getString("NOM_EMPRESA") );
				
				returnList.add( tableData );
			}
	
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMCTEM_E002_SOLBYCLIENT" , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
