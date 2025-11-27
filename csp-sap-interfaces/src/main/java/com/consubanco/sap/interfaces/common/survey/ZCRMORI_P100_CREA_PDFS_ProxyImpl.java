package com.consubanco.sap.interfaces.common.survey;

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

public class ZCRMORI_P100_CREA_PDFS_ProxyImpl  {

	private static Log log = LogFactory.getLog( ZCRMORI_P100_CREA_PDFS_ProxyImpl.class );
	
	public ZCRMORI_P100_CREA_PDFS_ProxyImpl() {
		super();		
	}

	public void executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMORI_P100_CREA_PDFS" );
			if(ft == null)
				throw new RuntimeException("ZCRMORI_P100_CREA_PDFS not found in SAP.");
			
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
			
			log.info("Input Params: "+function.getImportParameterList().toString());
			
			function.execute(destination);
							
	
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMORI_P100_CREA_PDFS" , e);
			throw e;
		} finally {
			
		}
		
		return;
	}
	
}
