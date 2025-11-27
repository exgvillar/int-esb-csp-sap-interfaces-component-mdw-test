package com.consupago.sap.interfaces.proxy.lcom;

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

public class ZRFC_SMSLCOM_ProxyImpl {

	private static Log log = LogFactory.getLog( ZRFC_SMSLCOM_ProxyImpl.class );
	
	private final String RFC_NAME = "ZRFC_SMSLCOM";
	
	public ZRFC_SMSLCOM_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList, ArrayList<String> categoryList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
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
			
			JCoTable inputTableData = function.getImportParameterList().getTable("I_CATPROD");
			Iterator kiter = categoryList.iterator();
			while( kiter.hasNext() ) {
				String categoryId = (String) kiter.next();
				inputTableData.appendRow();
				inputTableData.setValue(0, categoryId);		

			}
			
			function.execute(destination);
			
			JCoTable data = function.getExportParameterList().getTable("E_DATA");
			
			log.info( "" +  data.toString() );
			for (int i = 0; i < data.getNumRows(); i++, data.nextRow() ) {
				ZRFC_SMSLCOM_OutputData tableData = new ZRFC_SMSLCOM_OutputData();
				
				tableData.setClienteBusinessPartnerId( data.getString("CLIENTEBPID") );
				tableData.setPromotorBusinessPartnerId( data.getString("PROMOTORBPID") );				
				tableData.setFolioSolicitudCRM( data.getString("FOLIO_SOLICITUD") );				
				tableData.setNumeroCelularCliente( data.getString("CEL_CLIENTE") );
				tableData.setNumeroCelularPromotor( data.getString("CEL_PROMOTOR") );
				tableData.setEmpresaId( data.getString("EMPRESA") );
				tableData.setDistribuidorId( data.getString("DISTRIBUIDOR") );
				tableData.setSucursalId( data.getString("SUCURSAL") );
				tableData.setNombreCompetidor( data.getString("COMPETIDOR") );
				tableData.setMontoCompetidor( data.getDouble("MONTO_COMPETIDOR") );
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
