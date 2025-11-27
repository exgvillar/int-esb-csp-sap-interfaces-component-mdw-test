package com.consubanco.sap.interfaces.recommender;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.recommender.model.ElegibilityModel;
import com.consupago.sap.interfaces.format.Formatter;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoTable;

public class ZCRMRECO_P008_SAVESO_ELEGIBILI_ProxyImpl {

	private static Log log = LogFactory.getLog( ZCRMRECO_P008_SAVESO_ELEGIBILI_ProxyImpl.class );
	
	public ZCRMRECO_P008_SAVESO_ELEGIBILI_ProxyImpl() {
		super();		
	}


	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ElegibilityModel elegibilityModel) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMRECO_P008_SAVESO_ELEGIBILI" );
			if(ft == null)
				throw new RuntimeException("ZCRMRECO_P008_SAVESO_ELEGIBILI not found in SAP.");
			
			function = ft.getFunction();
			setRequestValues(function, elegibilityModel);
			log.info("Function.Import: " + function.getImportParameterList().toString() );
			
			function.execute(destination);
			log.info("Function.Export: " + function.getExportParameterList().toString() );
			
			ZCRMRECO_P008_SAVESO_ELEGIBILI_OutputData data = new ZCRMRECO_P008_SAVESO_ELEGIBILI_OutputData();			
			data.setExito( "X".equalsIgnoreCase( function.getExportParameterList().getString( "E_EXITO" ) ));
			data.setMensaje(function.getExportParameterList().getString("E_MENSAJE"));
						
			returnList.add( data );
	
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMRECO_P008_SAVESO_ELEGIBILI :: ", e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}


	private void setRequestValues(JCoFunction function, ElegibilityModel elegibilityModel) {
		
		function.getImportParameterList().setValue( "I_ID_ORDEN_SERVICIO", StringUtils.trimToEmpty(elegibilityModel.getServiceOrderId()) );	
		function.getImportParameterList().setValue( "I_BP_RECOMENDADOR", Formatter.fillStringWithZerosOnLeft(elegibilityModel.getRecommenderBp(), 10) );	
		function.getImportParameterList().setValue( "I_BP_RECOMENDADO", Formatter.fillStringWithZerosOnLeft(elegibilityModel.getRecommendedBp(), 10) );	
		function.getImportParameterList().setValue( "I_SOL_COT_RECOMENDADO", StringUtils.trimToEmpty(elegibilityModel.getFolioApplication()) );	
		function.getImportParameterList().setValue( "I_MONTO", String.valueOf(elegibilityModel.getAmount()) );	
		function.getImportParameterList().setValue( "I_ID_ESTATUS", StringUtils.trimToEmpty(elegibilityModel.getStatus()) );	
		JCoTable motivesTable = function.getImportParameterList().getTable("IT_MOTIVO");
		if(elegibilityModel.getMotives() != null && !elegibilityModel.getMotives().isEmpty()){
			for (String motive : elegibilityModel.getMotives()) {
				motivesTable.appendRow();
				motivesTable.setValue("ID_MOTIVO", motive);					
			}
		}
		log.info("Motives Table: " + motivesTable.toString() );
		
		function.getImportParameterList().setValue( "I_NUM_RECOMENDADOS",  String.valueOf( elegibilityModel.getRecommendedNumber() ) );	
		function.getImportParameterList().setValue( "I_FECHA_ELEGIBILIDAD", elegibilityModel.getElegibilityDate() );	
		function.getImportParameterList().setValue( "I_ELEGIBLE", elegibilityModel.isElegibility() ? "X" : "" );	
		function.getImportParameterList().setValue( "I_PERIODO_INI", elegibilityModel.getPeriodStartDate() );	
		function.getImportParameterList().setValue( "I_PERIODO_FIN", elegibilityModel.getPeriodEndDate() );	
		
	}

	
}
