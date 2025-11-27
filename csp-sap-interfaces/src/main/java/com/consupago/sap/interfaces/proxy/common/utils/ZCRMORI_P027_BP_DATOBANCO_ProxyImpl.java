package com.consupago.sap.interfaces.proxy.common.utils;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.ProxyInputParameterWithTable;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoTable;

public class ZCRMORI_P027_BP_DATOBANCO_ProxyImpl {

	private static Log log = LogFactory.getLog( ZCRMORI_P027_BP_DATOBANCO_ProxyImpl.class );
	
	private final String RFC_NAME = "ZCRMORI_P027_BP_DATOBANCO";
	
	public ZCRMORI_P027_BP_DATOBANCO_ProxyImpl() {
		super();		
	}

	public void executeRemoteFunction( JCoDestination destination, ProxyInputParameterWithTable inputParamters) throws Exception {
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;
		log.info(destination.toString());
		try {
			ft = destination.getRepository().getFunctionTemplate( RFC_NAME );
			if(ft == null)
	            throw new RuntimeException( RFC_NAME + " not found in SAP.");
			function = ft.getFunction();

			// general params
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
			
			
			// record - table params
			JCoTable tableInput = function.getTableParameterList().getTable("I_BANCO");
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
			

			function.execute(destination);
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMCSB_P001_UPDTADDRBP" , e);
			throw e;
		} finally {
			
		}
	}
	
}
