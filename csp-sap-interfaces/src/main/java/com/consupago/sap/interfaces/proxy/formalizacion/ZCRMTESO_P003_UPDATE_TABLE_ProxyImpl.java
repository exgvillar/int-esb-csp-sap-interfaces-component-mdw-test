package com.consupago.sap.interfaces.proxy.formalizacion;

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

public class ZCRMTESO_P003_UPDATE_TABLE_ProxyImpl {

	private static Log log = LogFactory.getLog( ZCRMTESO_E001_INFO_FORMALIZA_ProxyImpl.class );
	
	private final String RFC_NAME = "ZCRMTESO_P003_UPDATE_TABLE";
	
	public ZCRMTESO_P003_UPDATE_TABLE_ProxyImpl() {
		super();		
	}

	public ZCRMTESO_GENERIC_OutputData executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;
		ZCRMTESO_GENERIC_OutputData outputData = new ZCRMTESO_GENERIC_OutputData();
		try {
			ft = destination.getRepository().getFunctionTemplate( RFC_NAME );
			if(ft == null)
	            throw new RuntimeException( RFC_NAME + " not found in SAP.");
			function = ft.getFunction();
			log.info("input : " +  inputParamtersList.toString() );

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
			String data = function.getExportParameterList().getString("E_MESSAGE");
			outputData.seteMessage(StringUtils.trimToEmpty(data));
		} catch (AbapException e) {
			log.error(" executing function " + RFC_NAME , e);
			throw e;
		} finally {
			
		}
		log.info("output : " +  outputData.toString() );

		return( outputData );
	}
	
}
