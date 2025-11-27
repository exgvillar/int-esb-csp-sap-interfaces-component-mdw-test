package com.consubanco.sap.interfaces.commons.employees;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.commons.employees.model.ZTL_EMPLEOBP_Model;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.IStandardSAPProxy;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoTable;

public class ZCRMORI_E015_GET_EMPLEOSBP_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZCRMORI_E015_GET_EMPLEOSBP_ProxyImpl.class );
	
	public ZCRMORI_E015_GET_EMPLEOSBP_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMORI_E015_GET_EMPLEOSBP" );
			if(ft == null)
				throw new RuntimeException("ZCRMORI_E015_GET_EMPLEOSBP not found in SAP.");
			
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
			
			log.info("Input :: " + function.getImportParameterList().toString() );
			function.execute(destination);
			log.info("Output :: " + function.getExportParameterList().toString() );
			
			ZCRMORI_E015_GET_EMPLEOSBP_OutputData data = new ZCRMORI_E015_GET_EMPLEOSBP_OutputData();
			data.setSuccess( function.getExportParameterList().getString("E_SUCCESS").equals("X") ? true : false );
			data.setMessage( function.getExportParameterList().getString("E_MESSAGE") );
			
			JCoTable tblEmployee = function.getExportParameterList().getTable("ET_LABORABLES");
			log.info( "" +  tblEmployee.toString() );
			ArrayList<ZTL_EMPLEOBP_Model> employeesList = new ArrayList<ZTL_EMPLEOBP_Model>();
			for (int i = 0; i < tblEmployee.getNumRows(); i++, tblEmployee.nextRow() ) {
				ZTL_EMPLEOBP_Model tableData = new ZTL_EMPLEOBP_Model();
				tableData.setClaveProfesion( tblEmployee.getString("JOBGR_ZGP") ); 
				tableData.setLugarTrabajo( tblEmployee.getString( "EMPLOYER") ); 
				tableData.setGiroEmpresa( tblEmployee.getString("ZZ_SEC_LAB" ) ); 
				tableData.setActividadEmpresa(tblEmployee.getString("ZZ_ACT_LAB") ); 
				tableData.setCargoDesempenadoId( tblEmployee.getString("EMPLOYMENT") );
				tableData.setCargoDesempenado( tblEmployee.getString("EMPLOYM_T") );
				tableData.setAntiguedadEmpleoActual( tblEmployee.getInt("ANTIG_EACT") ); 
				tableData.setAntiguedadEmpleoAnterior( tblEmployee.getInt("ANTIG_EANT") );
				tableData.setGiroActividadAltoRiesgo( tblEmployee.getString("GIROACT") );
				
				JCoTable tblPhones = function.getExportParameterList().getTable("ET_TELEFONOS");
				log.info( "" +  tblPhones.toString() );
				// j < tblPhones.getNumRows() // se itera sólo el primer registro que en realidad es el último capturado
				for (int j = 0; j < ( tblPhones.getRow() > 1 ? 1 : tblPhones.getRow() ) ; j++, tblPhones.nextRow() ) {
					tableData.setTelefonoTrabajo( tblPhones.getString("TELEPHONE") );
				}
				
				JCoTable tblMails = function.getExportParameterList().getTable("ET_MAILS");
				log.info( "" +  tblMails.toString() );
				// j < tblMails.getNumRows() // se itera sólo el primer registro que en realidad es el último capturado
				for (int k = 0; k < ( tblMails.getRow() > 1 ? 1 : tblMails.getRow() ); k++, tblMails.nextRow() ) {
					tableData.setMail( tblMails.getString("EMAIL") );
				}
				
				JCoTable tblComp = function.getExportParameterList().getTable("ET_COMPLABOR");
				log.info( "" +  tblComp.toString() );
				// j < tblMails.getNumRows() // se itera sólo el primer registro que en realidad es el último capturado
				for (int l = 0; l < 1; l++, tblComp.nextRow() ) {
					tableData.setIngresoMensual( tblComp.getDouble("INGRESO_MENSUAL") );
					tableData.setOtrosIngresos( tblComp.getDouble("OTINGR_MENSUAL") );
					tableData.setFuenteOtrosIngresos( tblComp.getString("FUENTE_OTRING") );
				}
				
				employeesList.add( tableData );		
			}
			data.setEmployees( employeesList );
			returnList.add( data );
	
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMORI_E015_GET_EMPLEOSBP" , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
