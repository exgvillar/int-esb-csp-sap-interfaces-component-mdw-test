package com.consupago.sap.interfaces.proxy.notes;

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

public class ZCRMCSB_P001_SAVE_NOTE_ProxyImpl  {
	private static Log log = LogFactory.getLog( ZCRMCSB_P001_SAVE_NOTE_ProxyImpl.class );
	
	private final String RFC_NAME = "ZCRMCSB_P001_SAVE_NOTE";
	
	public ZCRMCSB_P001_SAVE_NOTE_ProxyImpl() {
		super();		
	}

	public void executeRemoteFunction( JCoDestination destination, ProxyInputParameterWithTable inputParamters) throws Exception {
		
		
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( RFC_NAME );
			if(ft == null)
	            throw new RuntimeException( RFC_NAME + " not found in SAP in System ::" + destination.getClient());
			function = ft.getFunction();
	
			// Parametros normales o generales
//			log.info("General Param:" + inputParamters.getGeneralParam() );
			Iterator<ProxyInputParameter> iterGeneralParams = inputParamters.getGeneralParam().iterator();
			while( iterGeneralParams.hasNext() ) {
				ProxyInputParameter inputParam = iterGeneralParams.next();
					if( StringUtils.trimToNull( inputParam.getType() ) == null ) {
						function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );
					} else {
						if( inputParam.getType().equals("java.util.date") )
							function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getDateValue() );
						else
							function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );
					}	
				
			}
			
			
			// Parametros de tipo table input
						JCoTable tableInput = function.getImportParameterList().getTable("I_TEXT");
						Iterator<Object> iterRecord = inputParamters.getRecordParam().iterator();
						while( iterRecord.hasNext() ) {
							tableInput.appendRow();
							ArrayList<ProxyInputParameter> recordParam = (ArrayList<ProxyInputParameter>) iterRecord.next();
							Iterator<ProxyInputParameter> iterRecorParam = recordParam.iterator();
							while (iterRecorParam.hasNext()) {
								ProxyInputParameter inputParam = (ProxyInputParameter) iterRecorParam.next();
								if( StringUtils.trimToNull( inputParam.getType() ) == null ) {
										tableInput.setValue( inputParam.getKey(), inputParam.getValue() );
								} else {
									if( inputParam.getType().equals("java.util.Date") )
										tableInput.setValue( inputParam.getKey(), inputParam.getDateValue() );
									else
										tableInput.setValue( inputParam.getKey(), inputParam.getValue() );
								}
							}
						}
						
			
			log.info(function.getImportParameterList().toString());
			
			function.execute(destination);
		} catch (AbapException e) {
			log.error(" executing function " + RFC_NAME , e);
			throw e;
		} finally {
			
		}
	}
	
}
