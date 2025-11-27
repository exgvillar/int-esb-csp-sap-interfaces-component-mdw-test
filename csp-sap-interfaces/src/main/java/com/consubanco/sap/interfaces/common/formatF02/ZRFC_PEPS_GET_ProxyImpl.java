package com.consubanco.sap.interfaces.common.formatF02;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.common.formatF02.model.ZTL_PEPS_FAMILIAR_Model;
import com.consubanco.sap.interfaces.common.formatF02.model.ZTL_PEPS_INGRESO_Model;
import com.consubanco.sap.interfaces.common.formatF02.model.ZTL_PEPS_Model;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoStructure;
import com.sap.conn.jco.JCoTable;


public class ZRFC_PEPS_GET_ProxyImpl {

	private static Log log = LogFactory.getLog( ZRFC_PEPS_GET_ProxyImpl.class );
	
	public ZRFC_PEPS_GET_ProxyImpl() {
		super();		
	}

	public ZTL_PEPS_Model executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList ) throws Exception {
		
		ZTL_PEPS_Model pepData = null;
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZRFC_PEPS_GET" );
			if(ft == null)
				throw new RuntimeException("ZRFC_PEPS_GET not found in SAP.");
			
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
			
			log.info("Function.Import: " + function.getImportParameterList().toString());
			function.execute(destination);
			log.info("Function.Export: " + function.getExportParameterList().toString());

			pepData = new ZTL_PEPS_Model();
			JCoStructure pepStruct = function.getExportParameterList().getStructure("E_DATA");	
			log.info("Function.Export: E_DATA" + pepStruct.toString());

			pepData.setNumCliente( pepStruct.getString("CLIENTE_PEP") );
			pepData.setNumSolicitud( pepStruct.getString( "NUMDOC" ) );
			pepData.setFechaCreacionSolicitud( pepStruct.getDate("FECALT_PET" ) );
			pepData.setFechaEstatusPEP( pepStruct.getDate( "FECSTS_PEP" ) );
			pepData.setFechaAltaQEQ( pepStruct.getDate( "FECALT_QEQ" ) );
			pepData.setFechaBajaQEQ( pepStruct.getDate( "FECBAJ_QEQ" ) );
			pepData.setPuestoPEP( pepStruct.getString( "CAR_PTO_PEP" ) );
			pepData.setAreaDepto( pepStruct.getString( "AREA_DEPTO" ) );
			pepData.setCargoEleccionPopular( pepStruct.getString( "CAR_ELEC_POP" ) );
			pepData.setFechaInicioGestion( pepStruct.getDate( "INICIO_GESTION" ) );
			pepData.setNombreDependencia( pepStruct.getString( "NOMBRE_DEPEND" ) );
			pepData.setDireccionDependencia( pepStruct.getString( "DIRECC_DEPEND" ) );
			pepData.setIngresoBrutoMensual( pepStruct.getDouble( "BRUTO_INGRESOS" ) );
			pepData.setOtrosNegocios( pepStruct.getString( "OTROS_NEGOCIOS" ) );
			pepData.setDescOtrosNegocios( pepStruct.getString( "DESCRIPCION" ) );
				
			// Iterate tipos de ingreso structure
			JCoTable ingresosTable = function.getTableParameterList().getTable("T_TING");
			log.info("Function.Export: T_TING - tipos de ingreso" + ingresosTable.toString());

			ArrayList<ZTL_PEPS_INGRESO_Model> ingresosList = new ArrayList<ZTL_PEPS_INGRESO_Model>();
			for (int i = 0; i < ingresosTable.getNumRows(); i++, ingresosTable.nextRow() ) {
				ZTL_PEPS_INGRESO_Model _ingreso = new ZTL_PEPS_INGRESO_Model();
				_ingreso.setCveIngreso( ingresosTable.getString("ID_INGRE") );
				_ingreso.setDescIngreso( ingresosTable.getString("DESCRIP") );
				_ingreso.setTipoValor( ingresosTable.getString("TIPO_VAL") );
				_ingreso.setValor( ingresosTable.getString("VALOR") );
				ingresosList.add( _ingreso );
			}
			pepData.setIngresos( ingresosList );
				
			// Iterate Familiares structure
			JCoTable familiaresTable = function.getTableParameterList().getTable("T_FAMI");
			log.info("Function.Export: T_FAMI - familiares" + familiaresTable.toString());

			ArrayList<ZTL_PEPS_FAMILIAR_Model> familiaresList = new ArrayList<ZTL_PEPS_FAMILIAR_Model>();
			for (int i = 0; i < familiaresTable.getNumRows(); i++, familiaresTable.nextRow() ) {
				ZTL_PEPS_FAMILIAR_Model _familiar = new ZTL_PEPS_FAMILIAR_Model();
				_familiar.setNombre( familiaresTable.getString("NOMBRE_FAM") );
				_familiar.setOcupacion( familiaresTable.getString("OCUPAC_FAM") );
				_familiar.setEstadoRadica( familiaresTable.getString("EDORAD_FAM") );
				familiaresList.add( _familiar );
			}
			pepData.setFamiliares( familiaresList );
			pepData.setMessage(function.getExportParameterList().getString("E_MESSAGE"));			
	
		} catch (AbapException e) {
			log.error(" executing function " + "ZRFC_PEPS_GET" , e);
			throw e;
		} finally {
			
		}
		
		return ( pepData );
	}
	
}
