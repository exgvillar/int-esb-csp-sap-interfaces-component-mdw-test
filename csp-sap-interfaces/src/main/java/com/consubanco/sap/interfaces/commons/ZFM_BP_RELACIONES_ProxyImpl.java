package com.consubanco.sap.interfaces.commons;

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

public class ZFM_BP_RELACIONES_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZFM_BP_RELACIONES_ProxyImpl.class );
	
	public ZFM_BP_RELACIONES_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZFM_BP_RELACIONES" );
			if(ft == null)
				throw new RuntimeException("ZFM_BP_RELACIONES not found in SAP.");
			
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
			
			JCoTable data = function.getTableParameterList().getTable("T_EMPLEADO_SUPERVISOR");
			
			log.info( "" +  data.toString() );
			for (int i = 0; i < data.getNumRows(); i++, data.nextRow() ) {
				ZFM_BP_RELACIONES_OutputData tableData = new ZFM_BP_RELACIONES_OutputData();
				
				tableData.setBp( data.getString("ID_EMPLEADO") );
				tableData.setName1( data.getString("NOMBRE") );
				tableData.setName2( data.getString("NOMBRE_2") );
				tableData.setLastname1( data.getString("APELLIDO_PATERNO") );
				tableData.setLastname2( data.getString("APELLIDO_MATERNO") );
				
				returnList.add( tableData );
			}
	
		} catch (AbapException e) {
			log.error(" executing function " + "ZFM_BP_RELACIONES" , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
