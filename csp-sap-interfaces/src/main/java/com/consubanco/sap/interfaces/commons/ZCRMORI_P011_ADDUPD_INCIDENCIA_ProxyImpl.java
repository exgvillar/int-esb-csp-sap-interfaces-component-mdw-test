package com.consubanco.sap.interfaces.commons;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.ProxyInputParameterWithTable;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoTable;


public class ZCRMORI_P011_ADDUPD_INCIDENCIA_ProxyImpl  {

	private static Log log = LogFactory.getLog( ZCRMORI_P011_ADDUPD_INCIDENCIA_ProxyImpl.class );
	
	
	public ZCRMORI_P011_ADDUPD_INCIDENCIA_ProxyImpl() {
		super();		
	}

	public boolean executeRemoteFunction( JCoDestination destination, ProxyInputParameterWithTable inputParamters ) throws Exception {
		
		boolean result = false;
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMORI_P011_ADDUPD_INCIDENCIA" );
			if(ft == null)
				throw new RuntimeException("ZCRMORI_P011_ADDUPD_INCIDENCIA not found in SAP.");
			
			function = ft.getFunction();
					
			// record - table params
			JCoTable tableInput = function.getImportParameterList().getTable("T_INCIDENCIA");
			Iterator<Object> iterRecord = inputParamters.getRecordParam().iterator();
			while( iterRecord.hasNext() ){
				tableInput.appendRow();
				ArrayList<ProxyInputParameter>  recordParams = (ArrayList<ProxyInputParameter>)iterRecord.next();
				Iterator<ProxyInputParameter> iterRecordParams = recordParams.iterator();
				while( iterRecordParams.hasNext() ) {
					ProxyInputParameter inputParam = iterRecordParams.next();
					if( StringUtils.trimToNull( inputParam.getType() ) == null ) {
						tableInput.setValue( inputParam.getKey(), inputParam.getValue() );
					} else {
						if( inputParam.getType().equals("java.util.date") )
							tableInput.setValue( inputParam.getKey(), inputParam.getDateValue() );
						else
							tableInput.setValue( inputParam.getKey(), inputParam.getValue() );
					}						
				}
			}
			
			log.info( "INPUT >>> " + function.getImportParameterList().getTable("T_INCIDENCIA") );

			function.execute(destination);
			
			result = true;
	
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMORI_P011_ADDUPD_INCIDENCIA" , e);
			throw e;
		} finally {
			
		}
		
		return( result );
	}
	
}
