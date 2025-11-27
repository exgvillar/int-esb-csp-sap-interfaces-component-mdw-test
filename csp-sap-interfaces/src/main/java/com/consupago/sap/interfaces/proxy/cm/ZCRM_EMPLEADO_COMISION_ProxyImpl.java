package com.consupago.sap.interfaces.proxy.cm;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.IStandardSAPProxy;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoTable;
@Deprecated
public class ZCRM_EMPLEADO_COMISION_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZCRM_EMPLEADO_COMISION_ProxyImpl.class );
	
	private final String RFC_NAME = "ZCRM_EMPLEADO_COMISION";
	
	public ZCRM_EMPLEADO_COMISION_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
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
				function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );	
			}
			
			
			function.execute(destination);
			
			JCoTable data = function.getTableParameterList().getTable("TE_EMPLEADO");
			
			log.info( "" +  data.toString() );
			for (int i = 0; i < data.getNumRows(); i++, data.nextRow() ) {
				ZCRM_EMPLEADO_COMISION_OutputData output = new ZCRM_EMPLEADO_COMISION_OutputData();
				output.setSiglaDistribuidor( data.getString("DISTRIBUIDOR") );
				output.setNombreDistribuidor( data.getString("DESC_DISTRIBUIDOR") );
				output.setIdSucursal( data.getString("SUCURSAL") );
				output.setSiglaSucursal( data.getString("SIGLA_SUCURSAL") );
				output.setNombreSucursal( data.getString("DESC_SUCURSAL") );
				output.setSiglaPuesto( data.getString("PUESTO") );
				output.setNombrePuesto( data.getString("DESC_PUESTO") );
				output.setNombre1( data.getString("NOMBRE") );
				output.setNombre2(  data.getString("NOMBRE2") );
				output.setApellidoPaterno( data.getString("APELLIDO_PATERNO") );
				output.setApellidoMaterno( data.getString("APELLIDO_MATERNO") );
				output.setBusinessPartnerId(  data.getString("BP") );
				output.setFechaInicioContrato( data.getDate( "FECHA_INICIO_CON" ) );
				output.setRfc(  data.getString("RFC") );
				output.setNumEmpleadoNomina( data.getString("NUMERO_PERSONAL") );
				
				returnList.add( output );
			}
			
			/**
			returnMap.put("employeeList", returnList);
			
			data = function.getTableParameterList().getTable("TE_EMPLEADO1");
			
			log.info( "" +  data.toString() );
			for (int i = 0; i < data.getNumRows(); i++, data.nextRow() ) {
				ZCRM_EMPLEADO_COMISION_SUCURSAL_OutputData output = new ZCRM_EMPLEADO_COMISION_SUCURSAL_OutputData();
				output.setSiglaSucursal( data.getString("SIGLA_SUCURSAL") );
				output.setNombreSucursal( data.getString("DESC_SUCURSAL") );
				output.setBusinessPartnerId(  data.getString("BP") );
				
				
				
				
				if( empSucMap.containsKey( output.getBusinessPartnerId() ) ) {
					ArrayList<IProxyOutputData> sucursalesList = (ArrayList) empSucMap.get( output.getBusinessPartnerId() );
					
				} else {
					ArrayList<IProxyOutputData> sucursalesList = new ArrayList<IProxyOutputData>();
					sucursalesList.add( output );
					empSucMap.put( output.getBusinessPartnerId() , sucursalesList );
				}
			}
			
			returnMap.put("branchMap", empSucMap);
			**/
			
		} catch (AbapException e) {
			log.error(" executing function " + RFC_NAME , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
