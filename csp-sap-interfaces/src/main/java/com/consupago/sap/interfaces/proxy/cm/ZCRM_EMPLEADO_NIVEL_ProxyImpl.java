package com.consupago.sap.interfaces.proxy.cm;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
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
public class ZCRM_EMPLEADO_NIVEL_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZCRM_EMPLEADO_NIVEL_ProxyImpl.class );
	
	private final String RFC_NAME = "ZCRM_EMPLEADO_NIVEL";
	
	public ZCRM_EMPLEADO_NIVEL_ProxyImpl() {
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
			
			JCoTable data = function.getTableParameterList().getTable("TE_EMPLEADO_SUCURSAL");
			ZCRM_EMPLEADO_NIVEL_OutputData output = new ZCRM_EMPLEADO_NIVEL_OutputData();
			ArrayList<TE_EMPLEADO_SUCURSAL_OutputData> empleadoSucursalList = new ArrayList<TE_EMPLEADO_SUCURSAL_OutputData>();
			ArrayList<TE_EMPLEADO_TOTAL_OutputData> empleadoTotalList = new ArrayList<TE_EMPLEADO_TOTAL_OutputData>();
			
			log.info( "" +  data.toString() );
			for (int i = 0; i < data.getNumRows(); i++, data.nextRow() ) {
				TE_EMPLEADO_SUCURSAL_OutputData tableData = new TE_EMPLEADO_SUCURSAL_OutputData();
				
				tableData.setIdEmpleado( data.getString("IDEMPLEADO") );
				tableData.setSiglaSucursal( data.getString("SUCURSAL") );
				empleadoSucursalList.add( tableData );				
			}
			
			data = function.getTableParameterList().getTable("TE_EMPLEADO_TOTAL");
			log.info( "" +  data.toString() );
			for (int i = 0; i < data.getNumRows(); i++, data.nextRow() ) {
				TE_EMPLEADO_TOTAL_OutputData tableData = new TE_EMPLEADO_TOTAL_OutputData();
				
				tableData.setIdEmpleado( data.getString("IDEMPLEADO") );
				tableData.setNivel( data.getString("NIVEL") );
				tableData.setMonto( data.getDouble("MONTO") );
				tableData.setNombre1( data.getString("NOMBRE") );
				tableData.setNombre2( data.getString("NOMBRE2") );
				tableData.setApellidoPaterno( data.getString("APELLIDO_PATERNO") );
				tableData.setApellidoMaterno( data.getString("APELLIDO_MATERNO") );
				tableData.setSigla_puesto( data.getString("PUESTO_SIGLA") );
				tableData.setPuesto( data.getString("PUESTO") );
				tableData.setNumEmpleadoNomina( data.getString("NUMERO_PERSONAL") );
				tableData.setBpSuperior( data.getString("SUPERIOR") );
				tableData.setCelula( data.getString("CELULA") );
				tableData.setTipoRelacion( data.getString("RELACION") );
				tableData.setActivo( data.getString("ACTIVO").equals("X") ? true : false );
				empleadoTotalList.add( tableData );				
			}
			
			output.setTablaEmpleadoSucursal( empleadoSucursalList );
			output.setTablaEmpleadoTotal( empleadoTotalList );
			returnList.add( output );
		} catch (AbapException e) {
			log.error(" executing function " + RFC_NAME , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
