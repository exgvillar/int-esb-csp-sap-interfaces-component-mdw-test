package com.consubanco.sap.interfaces.common.formatF02;

import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.common.formatF02.model.ZTL_PEPS_FAMILIAR_Model;
import com.consubanco.sap.interfaces.common.formatF02.model.ZTL_PEPS_INGRESO_Model;
import com.consubanco.sap.interfaces.common.formatF02.model.ZTL_PEPS_Model;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoStructure;
import com.sap.conn.jco.JCoTable;


public class ZRFC_PEPS_PUT_ProxyImpl {

	private static Log log = LogFactory.getLog( ZRFC_PEPS_PUT_ProxyImpl.class );
	
	public ZRFC_PEPS_PUT_ProxyImpl() {
		super();		
	}

	public boolean executeRemoteFunction( JCoDestination destination, ZTL_PEPS_Model pepInputParams ) throws Exception {
		
		boolean result = false;
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZRFC_PEPS_PUT" );
			if(ft == null)
				throw new RuntimeException("ZRFC_PEPS_PUT not found in SAP.");
			
			function = ft.getFunction();
			
	
			JCoStructure pepUpdateStruct = function.getImportParameterList().getStructure("I_DATA");	
			if( pepInputParams != null ) {
				pepUpdateStruct.setValue("CLIENTE_PEP", pepInputParams.getNumCliente() );
				pepUpdateStruct.setValue("NUMDOC", pepInputParams.getNumSolicitud() );
				pepUpdateStruct.setValue("FECALT_PET", pepInputParams.getFechaCreacionSolicitud() );
				pepUpdateStruct.setValue("FECSTS_PEP", pepInputParams.getFechaEstatusPEP() );
				pepUpdateStruct.setValue("FECALT_QEQ", pepInputParams.getFechaAltaQEQ() );
				pepUpdateStruct.setValue("FECBAJ_QEQ", pepInputParams.getFechaBajaQEQ() );
				pepUpdateStruct.setValue("CAR_PTO_PEP", pepInputParams.getPuestoPEP() );
				pepUpdateStruct.setValue("AREA_DEPTO", pepInputParams.getAreaDepto() );
				pepUpdateStruct.setValue("CAR_ELEC_POP", pepInputParams.getCargoEleccionPopular() );
				pepUpdateStruct.setValue("INICIO_GESTION", pepInputParams.getFechaInicioGestion() );
				pepUpdateStruct.setValue("NOMBRE_DEPEND", pepInputParams.getNombreDependencia() );
				pepUpdateStruct.setValue("DIRECC_DEPEND", pepInputParams.getDireccionDependencia() );
				pepUpdateStruct.setValue("BRUTO_INGRESOS", pepInputParams.getIngresoBrutoMensual() );
				pepUpdateStruct.setValue("OTROS_NEGOCIOS", pepInputParams.getOtrosNegocios() );
				pepUpdateStruct.setValue("DESCRIPCION", pepInputParams.getDescOtrosNegocios() );
				
				log.info("" + pepUpdateStruct.toString() );
				
				// Iterate tipos de ingreso structure
				JCoTable ingresosTable = function.getTableParameterList().getTable("T_TING");
				if( pepInputParams.getIngresos() != null ) {
					Iterator<ZTL_PEPS_INGRESO_Model> itIngresos = pepInputParams.getIngresos().iterator();
					while( itIngresos.hasNext() ) {
						ZTL_PEPS_INGRESO_Model _ingreso = (ZTL_PEPS_INGRESO_Model) itIngresos.next();
						ingresosTable.appendRow();
						ingresosTable.setValue("ID_INGRE", _ingreso.getCveIngreso() );
						ingresosTable.setValue("DESCRIP", _ingreso.getDescIngreso() );
						ingresosTable.setValue("TIPO_VAL", _ingreso.getTipoValor() );
						ingresosTable.setValue("VALOR", _ingreso.getValor() );
						
					}
				}
				
				log.info("" + ingresosTable.toString() );
				
				// Iterate Familiares structure
				//JCoTable familiaresTable = function.getImportParameterList().getTable("T_FAMI");
				JCoTable familiaresTable = function.getTableParameterList().getTable("T_FAMI");
				if( pepInputParams.getFamiliares() != null ) {
					Iterator<ZTL_PEPS_FAMILIAR_Model> itFamiliar = pepInputParams.getFamiliares().iterator();
					while( itFamiliar.hasNext() ) {
						ZTL_PEPS_FAMILIAR_Model _familiar = (ZTL_PEPS_FAMILIAR_Model) itFamiliar.next();
						familiaresTable.appendRow();
						familiaresTable.setValue("NOMBRE_FAM", _familiar.getNombre() );
						familiaresTable.setValue("OCUPAC_FAM", _familiar.getOcupacion() );
						familiaresTable.setValue("EDORAD_FAM", _familiar.getEstadoRadica() );
						
					}
				}	
				log.info("" + familiaresTable.toString() );
			}
			
		
			
			function.execute(destination);
			
			result = true;
				
	
		} catch (AbapException e) {
			log.error(" executing function " + "ZRFC_PEPS_PUT" , e);
			throw e;
		} finally {
			
		}
		
		return result;
	}
	
}
