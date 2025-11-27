package com.consupago.sap.interfaces.proxy.netcash;

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

public class ZRFC_DESCARGA_NETCASH_ProxyImpl {

	private static Log log = LogFactory.getLog( ZRFC_DESCARGA_NETCASH_ProxyImpl.class );
	
	private final String RFC_NAME = "ZRFC_DESCARGA_NETCASH";
	
	public ZRFC_DESCARGA_NETCASH_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList ) throws Exception {
		
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
			
			function.execute(destination);
			
			ZRFC_DESCARGA_NETCASH_OutputData outputData = new ZRFC_DESCARGA_NETCASH_OutputData();
			
			outputData.setLoteId( function.getExportParameterList().getString("E_LOTE"));
			outputData.setCaseId( function.getExportParameterList().getString("E_CASO") );
			
			JCoTable data = function.getTableParameterList().getTable("T_NETCASH");
			
			log.info( "" +  data.toString() );
			
			ArrayList<ZES_REGCASH_TableOutputData> netcashOperationsList = new ArrayList<ZES_REGCASH_TableOutputData>();
			for (int i = 0; i < data.getNumRows(); i++, data.nextRow() ) {
				ZES_REGCASH_TableOutputData tableData = new ZES_REGCASH_TableOutputData();
				
				tableData.setIdSolicitud( data.getString("SOLICITUD") );
				tableData.setBancoABM( data.getString("BANCO_ABM") );				
				tableData.setClabe( data.getString("CUENTA_BEN") );				
				tableData.setMontoMaximoDispersar( data.getDouble("MONTO_MAX") );
				tableData.setNombre1( data.getString("NOMBRE1") );
				tableData.setNombre2( data.getString("NOMBRE2") );
				tableData.setApellidoPaterno( data.getString("APEPAT") );
				tableData.setApellidoMaterno( data.getString("APEMAT") );
				tableData.setRfc( data.getString("RFC") );
				netcashOperationsList.add( tableData );				
			}
			
			outputData.setNetcashOperationsList(netcashOperationsList);
			
			returnList.add( outputData );
		} catch (AbapException e) {
			log.error(" executing function " + RFC_NAME , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
