package com.consubanco.sap.interfaces.coi;

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

public class ZCRMOP1098_P006_GENERALOTE_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZCRMOP1098_P006_GENERALOTE_ProxyImpl.class );
	
	public ZCRMOP1098_P006_GENERALOTE_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMOP1098_P006_GENERALOTE" );
			if(ft == null)
				throw new RuntimeException("ZCRMOP1098_P006_GENERALOTE not found in SAP.");
			
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
			
			
			function.execute(destination);
			
			JCoTable data = function.getExportParameterList().getTable("E_LOTE");
						
			log.info( "" +  data.toString() );
			for (int i = 0; i < data.getNumRows(); i++, data.nextRow() ) {
				ZCRMOP1098_P006_GENERALOTE_OutputData tableData = new ZCRMOP1098_P006_GENERALOTE_OutputData();
				
				tableData.setMandante( data.getString("MANDT") );
				tableData.setLote( data.getString("LOTE") );
				tableData.setRequestId( data.getString("OBJECT_ID") );
				tableData.setFolder( data.getString("FOLDER") );
				tableData.setArchivoNomina( data.getString("ARCHIVO_NOMINA") );
				tableData.setSolvencia( data.getDouble("SOLVENCIA") );
				tableData.setMoneda( data.getString("MONEDA") );
				tableData.setFechaAlta( data.getDate("FECHA_ALTA") );
				tableData.setConvenio( data.getString("CONVENIO") );
				tableData.setConvenioNombre( data.getString("CONVENIO_NOMBRE") );
				tableData.setProducto( data.getString("PRODUCTO") );
				tableData.setProductoNombre( data.getString("PRODUCTO_NOMBRE") );
				tableData.setPrimerNombre( data.getString("NAME_FIRST") );
				tableData.setSegundoNombre( data.getString("NAMEMIDDLE") );
				tableData.setApellidoPaterno( data.getString("NAME_LAST") );
				tableData.setApellidoMaterno( data.getString("NAME_LST2") );
				tableData.setNumeroEmpleado( data.getString("EMP_NO") );
				tableData.setMontoDescuento( data.getDouble("DESC_CRED") );
				tableData.setRfc( data.getString("RFC_CLIEN") );
				tableData.setFechaCambioEstatus( data.getDate("FECHA_ULT_STAT") );
				tableData.setMontoSolicitado( data.getDouble("MONTOSOL") );
				tableData.setPlazo( data.getString("PLAZOCREDITO") );
				returnList.add( tableData );				
			}
				
	
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMOP1098_P006_GENERALOTE" , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
