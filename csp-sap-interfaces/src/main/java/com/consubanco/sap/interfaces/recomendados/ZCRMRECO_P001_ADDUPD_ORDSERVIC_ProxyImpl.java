package com.consubanco.sap.interfaces.recomendados;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.recomendados.model.ORDEN_SERVICIO_Model;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoTable;

public class ZCRMRECO_P001_ADDUPD_ORDSERVIC_ProxyImpl{

	private static Log log = LogFactory.getLog( ZCRMRECO_P001_ADDUPD_ORDSERVIC_ProxyImpl.class );
	
	public ZCRMRECO_P001_ADDUPD_ORDSERVIC_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ORDEN_SERVICIO_Model inputParamsData) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMRECO_P001_ADDUPD_ORDSERVIC" );
			if(ft == null)
				throw new RuntimeException("ZCRMRECO_P001_ADDUPD_ORDSERVIC not found in SAP.");
			
			function = ft.getFunction();


			if( inputParamsData != null ) {

				function.getImportParameterList().setValue("I_NUMORDSER", inputParamsData.getNumeroOrdenServicio());
				function.getImportParameterList().setValue("I_BPREFIERE", inputParamsData.getBpRefiere());
				function.getImportParameterList().setValue("I_IDSOLREFI", inputParamsData.getSolClienteRefiere());
				function.getImportParameterList().setValue("I_BPREFERID", inputParamsData.getBpReferido());
				function.getImportParameterList().setValue("I_MONTOPAGO", inputParamsData.getMontoPago());
				function.getImportParameterList().setValue("I_BPRESPONS", inputParamsData.getBpEmpleadoResponsable());
				function.getImportParameterList().setValue("I_SOLCLTREF", inputParamsData.getSolClienteReferido());
				function.getImportParameterList().setValue("I_FECABPROB", inputParamsData.getFechaAprobacion());
				function.getImportParameterList().setValue("I_OBSERVACI", inputParamsData.getObservaciones());
				function.getImportParameterList().setValue("I_NUMDPAGOS", inputParamsData.getOcurrenciasPago());
				function.getImportParameterList().setValue("I_CANALORIG", inputParamsData.getCanalOrigen());
				function.getImportParameterList().setValue("I_REFERPAGO", inputParamsData.getReferenciaPago());

				
				// Iterate MOTIVE Table				
				JCoTable motiveTable = function.getImportParameterList().getTable("IT_MOTIVO");
			
				ArrayList<String> motiveInputList = inputParamsData.getMotivos();

				if( motiveInputList != null ) {
					Iterator<String> iterator = motiveInputList.iterator();
					while( iterator.hasNext() ) {
						String motivo = (String) iterator.next();
						
						motiveTable.appendRow();
						motiveTable.setValue("CODE", motivo );

					}
				}
			}

			log.info( function.getImportParameterList().toString() );
			function.execute(destination);

			ZCRMRECO_P001_ADDUPD_ORDSERVIC_OutputData data = new ZCRMRECO_P001_ADDUPD_ORDSERVIC_OutputData();

			data.setMessage(function.getExportParameterList().getString("E_MESSAGES"));


			JCoTable dataTable = function.getExportParameterList().getTable("ET_ORDSER");
			log.info( "" +  dataTable.toString() );

			List<ORDEN_SERVICIO_Model> listServiceOrder = new ArrayList<ORDEN_SERVICIO_Model>();
			for (int i = 0; i < dataTable.getNumRows(); i++, dataTable.nextRow() ) {
				
				ORDEN_SERVICIO_Model ordenServicio = new ORDEN_SERVICIO_Model();
				
				ordenServicio.setNumeroOrdenServicio( dataTable.getString("NUMDOC") ); 
				
				listServiceOrder.add( ordenServicio );	
			}

			data.setOrdenServicioList(listServiceOrder);

			
			log.info( "" +  data.toString() );

			returnList.add( data );
	
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMRECO_P001_ADDUPD_ORDSERVIC" , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
