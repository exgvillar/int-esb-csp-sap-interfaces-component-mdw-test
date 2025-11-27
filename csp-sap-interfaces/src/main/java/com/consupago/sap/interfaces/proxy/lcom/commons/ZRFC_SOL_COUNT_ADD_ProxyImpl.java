package com.consupago.sap.interfaces.proxy.lcom.commons;

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


public class ZRFC_SOL_COUNT_ADD_ProxyImpl  {
	private static Log log = LogFactory.getLog( ZRFC_SOL_COUNT_ADD_ProxyImpl.class );
	
	private final String RFC_NAME = "ZRFC_SOL_COUNT_ADD";
	
	public ZRFC_SOL_COUNT_ADD_ProxyImpl() {
		super();		
	}

	public void executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		ArrayList<ZIT_CONVENIO_CAT_OutputData> returnList = new ArrayList<ZIT_CONVENIO_CAT_OutputData>();
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
			function.execute(destination);
		} catch (AbapException e) {
			log.error(" executing function " + RFC_NAME , e);
			throw e;
		} finally {
			
		}
	}
	
}
