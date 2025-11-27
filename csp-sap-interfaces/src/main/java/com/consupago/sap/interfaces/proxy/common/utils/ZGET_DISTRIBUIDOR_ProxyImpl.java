package com.consupago.sap.interfaces.proxy.common.utils;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoTable;

public class ZGET_DISTRIBUIDOR_ProxyImpl {

	private static Log log = LogFactory.getLog( ZGET_DISTRIBUIDOR_ProxyImpl.class );
	
	private final String RFC_NAME = "ZGET_DISTRIBUIDOR";
	
	public ZGET_DISTRIBUIDOR_ProxyImpl() {
		super();		
	}

	public ArrayList<ZGET_DISTRIBUIDOR_OutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		ArrayList<ZGET_DISTRIBUIDOR_OutputData> returnList = new ArrayList<ZGET_DISTRIBUIDOR_OutputData>();
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
				if( StringUtils.trimToNull( inputParam.getType() ) == null ) {
					function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );	
				} else {
					if( inputParam.getType().equals("java.util.date") )
						function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getDateValue() );
					else
						function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );
				}
			}
			log.info(inputParamtersList.toString() );
//			log.info( inputParamtersList.get(0).getKey() + )
			function.execute(destination);
			JCoTable data = function.getTableParameterList().getTable("IT_EMP_DIS_SUC");
			
			log.info(data.toString() );
			for (int i = 0; i < data.getNumRows(); i++, data.nextRow() ) {
				ZGET_DISTRIBUIDOR_OutputData output = new ZGET_DISTRIBUIDOR_OutputData();
				output.setzObjidempresa( data.getString("Z_OBJIDEMPRESA") );
				output.setzEmpresa(data.getString("Z_EMPRESA") );
				output.setZidEmpresa(data.getString("ZID_EMPRESA") );
				output.setZbpEmpresa(data.getString("ZBP_EMPRESA") );
				output.setzObjiddistrib(data.getString("Z_OBJIDDISTRIB") );
				output.setzDistrib(data.getString("Z_DISTRIB") );
				output.setZidDistrib(data.getString("ZID_DISTRIB") );
				output.setZbpDistrib(data.getString("ZBP_DISTRIB") );
				output.setzObjidsucursal(data.getString("Z_OBJIDSUCURSAL") );
				output.setzSucursal(data.getString("Z_SUCURSAL") );
				output.setZidSucursal(data.getString("ZID_SUCURSAL") );
				
				returnList.add(output);
			}
		 return returnList;

		} catch (AbapException e) {
			log.error(" executing function " + RFC_NAME , e);
			throw e;
		} finally {
			
		}
	}
	
}
