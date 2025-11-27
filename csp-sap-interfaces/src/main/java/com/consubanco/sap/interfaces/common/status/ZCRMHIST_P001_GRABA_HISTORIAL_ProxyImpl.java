package com.consubanco.sap.interfaces.common.status;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.consubanco.sap.interfaces.commons.ZCRMORI_E005_BUSCADDRBP_OutputData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.ProxyInputParameterWithTable;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoTable;

public class ZCRMHIST_P001_GRABA_HISTORIAL_ProxyImpl  {

	private static Log log = LogFactory.getLog( ZCRMHIST_P001_GRABA_HISTORIAL_ProxyImpl.class );
	
	private final String RFC_NAME = "ZCRMHIST_P001_GRABA_HISTORIAL";
	
	public ZCRMHIST_P001_GRABA_HISTORIAL_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ProxyInputParameterWithTable inputParamters) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			ft = destination.getRepository().getFunctionTemplate( RFC_NAME );
			if(ft == null)
				throw new RuntimeException(RFC_NAME + " not found in SAP.");
			function = ft.getFunction();

			// record - table params
			JCoTable tableInput = function.getImportParameterList().getTable("I_MOD");
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
			System.out.println(tableInput);
			function.execute(destination);

		} catch (AbapException e) {
			log.error(" executing function " + RFC_NAME , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
