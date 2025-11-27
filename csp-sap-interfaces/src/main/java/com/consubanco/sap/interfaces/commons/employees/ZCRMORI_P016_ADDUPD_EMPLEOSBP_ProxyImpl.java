package com.consubanco.sap.interfaces.commons.employees;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.commons.employees.model.ZTL_EMPLEOBP_Model;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoStructure;
import com.sap.conn.jco.JCoTable;


public class ZCRMORI_P016_ADDUPD_EMPLEOSBP_ProxyImpl {

	private static Log log = LogFactory.getLog( ZCRMORI_P016_ADDUPD_EMPLEOSBP_ProxyImpl.class );
	
	public ZCRMORI_P016_ADDUPD_EMPLEOSBP_ProxyImpl() {
		super();		
	}

	public List<IProxyOutputData> executeRemoteFunction( JCoDestination destination, List<ZTL_EMPLEOBP_Model> inputParams ) throws Exception {
		
		ZCRMORI_P016_ADDUPD_EMPLEOSBP_OutputData outputData = new ZCRMORI_P016_ADDUPD_EMPLEOSBP_OutputData();
		List<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;
		boolean success = false;

		try {			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMORI_P016_ADDUPD_EMPLEOSBP" );
			if(ft == null)
				throw new RuntimeException("ZCRMORI_P016_ADDUPD_EMPLEOSBP not found in SAP.");
			
			function = ft.getFunction();
	
			if( inputParams != null ) {
				
				JCoStructure orderUpdateStruct = function.getImportParameterList().getStructure("I_COMPLABOR");	
				// Iterate Tables
				JCoTable employeesTable = function.getImportParameterList().getTable("IT_LABORABLES");
				JCoTable phonesTable = function.getImportParameterList().getTable("IT_TELEFONOS");
				JCoTable mailsTable = function.getImportParameterList().getTable("IT_MAILS");
				
				Iterator<ZTL_EMPLEOBP_Model> empIterator = inputParams.iterator();
				while( empIterator.hasNext() ) {
					ZTL_EMPLEOBP_Model _data = (ZTL_EMPLEOBP_Model) empIterator.next();
					
					function.getImportParameterList().setValue("I_BP", _data.getBpId() );
					
					orderUpdateStruct.setValue("INGRESO_MENSUAL", _data.getIngresoMensual() );
					orderUpdateStruct.setValue("OTINGR_MENSUAL", _data.getOtrosIngresos() );
					orderUpdateStruct.setValue("FUENTE_OTRING", _data.getFuenteOtrosIngresos() );
					orderUpdateStruct.setValue("MONEDA", "MXN" );
					orderUpdateStruct.setValue("ANIO_INGRESO", "" ); 
					orderUpdateStruct.setValue("MES_INGRESO", "" ); 
					
					log.info( ">>>" + orderUpdateStruct.toString() );
					
					employeesTable.appendRow();
					employeesTable.setValue("JOBGR_ZGP", _data.getClaveProfesion() ); 
					employeesTable.setValue("EMPLOYER", _data.getLugarTrabajo() ); 
					employeesTable.setValue("ZZ_SEC_LAB", _data.getGiroEmpresa() ); 
					employeesTable.setValue("ZZ_ACT_LAB", _data.getActividadEmpresa() ); 
					employeesTable.setValue("EMPLOYMENT", _data.getCargoDesempenadoId() );
					employeesTable.setValue("EMPLOYM_T", _data.getCargoDesempenado() );
					employeesTable.setValue("ANTIG_EACT", _data.getAntiguedadEmpleoActual() ); 
					employeesTable.setValue("ANTIG_EANT", _data.getAntiguedadEmpleoAnterior() );
					employeesTable.setValue("GIROACT", _data.getGiroActividadAltoRiesgo() );
					
					log.info( ">>>" + employeesTable.toString() );
					
					if( StringUtils.isNotEmpty( _data.getTelefonoTrabajo() ) ){
						phonesTable.appendRow();
						phonesTable.setValue("TELEPHONE", _data.getTelefonoTrabajo() );
						phonesTable.setValue("EXTENSION", "" );
						/*
						 * TODO: OPCELULAR
						 * 1 - Fijo
						 * 2 - Otro
						 * 3 - Celular
						 */
						phonesTable.setValue("OPCELULAR", "1" ); 
						phonesTable.setValue("COMENTARIOS", _data.getLugarTrabajo() );
						phonesTable.setValue("SECUENCIA", "");
					}
					
					log.info( ">>>" + phonesTable.toString() );
					
					if( StringUtils.isNotEmpty( _data.getMail() ) ){
						mailsTable.appendRow();
						mailsTable.setValue("EMAIL", _data.getMail() );
						mailsTable.setValue("COMENTARIOS", _data.getLugarTrabajo() );
						mailsTable.setValue("SECUENCIA", "" );
						//mailsTable.setValue("BORRAR", "" ); 
					}
					
					log.info( ">>>" + mailsTable.toString() );
				}
			}				
			
			function.execute(destination);
			
			log.info(function.getExportParameterList().toString());
			
			String message = function.getExportParameterList().getString("E_MESSAGE");
			
			if ("X".equals(function.getExportParameterList().getString("E_SUCCESS") )) {
				success = true;
			}
	
			outputData.setMessage(message);
			outputData.setSuccess(success);
			returnList.add(outputData);
			
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMORI_P016_ADDUPD_EMPLEOSBP" , e);
			throw e;
		} 
		
		return returnList;
	}
	
}
