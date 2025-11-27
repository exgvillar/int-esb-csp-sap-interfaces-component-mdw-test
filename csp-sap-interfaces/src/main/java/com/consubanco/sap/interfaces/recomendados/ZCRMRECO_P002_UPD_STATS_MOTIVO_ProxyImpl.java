package com.consubanco.sap.interfaces.recomendados;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.recomendados.model.ESTATUS_MOTIVO_Model;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoTable;

public class ZCRMRECO_P002_UPD_STATS_MOTIVO_ProxyImpl{

	private static Log log = LogFactory.getLog( ZCRMRECO_P002_UPD_STATS_MOTIVO_ProxyImpl.class );
	
	public ZCRMRECO_P002_UPD_STATS_MOTIVO_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ESTATUS_MOTIVO_Model inputParamsData) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMRECO_P002_UPD_STATS_MOTIVO" );
			if(ft == null)
				throw new RuntimeException("ZCRMRECO_P002_UPD_STATS_MOTIVO not found in SAP.");
			
			function = ft.getFunction();
			
			if( inputParamsData != null ) {

				log.info( "INPUT " +  inputParamsData.toString() );
				
				function.getImportParameterList().setValue("I_ORDSERV", inputParamsData.getNumeroOrdenServicio());
				function.getImportParameterList().setValue("I_NEWSTAT", inputParamsData.getNuevoEstatus());

				ArrayList<ProxyInputParameter> motiveInputList = inputParamsData.getMotivos();
				
				if( motiveInputList != null ) {

					//Iterate STATUS Table
					JCoTable statusTable = function.getImportParameterList().getTable("IT_MOTIVO");
				
					Iterator<ProxyInputParameter> intIterator = motiveInputList.iterator();
					while( intIterator.hasNext() ) {
						ProxyInputParameter inputParameter = (ProxyInputParameter) intIterator.next();

						statusTable.appendRow();
						statusTable.setValue("CODE", inputParameter.getValue());

					}

				}				
				
			}


			function.execute(destination);
			
			ZCRMRECO_P002_UPD_STATS_MOTIVO_OutputData data = new ZCRMRECO_P002_UPD_STATS_MOTIVO_OutputData();

			data.setMessage(function.getExportParameterList().getString("E_MESSAGES"));

			log.info( "OUPUT " +  data.toString() );

			returnList.add( data );
	
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMRECO_P002_UPD_STATS_MOTIVO" , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
