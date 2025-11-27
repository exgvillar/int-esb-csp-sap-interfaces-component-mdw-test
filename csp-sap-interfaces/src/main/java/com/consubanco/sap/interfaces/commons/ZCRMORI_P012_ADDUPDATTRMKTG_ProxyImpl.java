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


public class ZCRMORI_P012_ADDUPDATTRMKTG_ProxyImpl  {

	private static Log log = LogFactory.getLog( ZCRMORI_P012_ADDUPDATTRMKTG_ProxyImpl.class );
	
	
	public ZCRMORI_P012_ADDUPDATTRMKTG_ProxyImpl() {
		super();		
	}

	public boolean executeRemoteFunction( JCoDestination destination, ProxyInputParameterWithTable inputParamters ) throws Exception {
		
		boolean successful = false;
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMORI_P012_ADDUPDATTRMKTG" );
			if(ft == null)
				throw new RuntimeException("ZCRMORI_P012_ADDUPDATTRMKTG not found in SAP.");
			
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
			JCoTable tableInput = function.getImportParameterList().getTable("I_ATTMKTG");
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
			
			successful = true;				
			
	
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMORI_P012_ADDUPDATTRMKTG" , e);
			throw e;
		} finally {
			
		}
		
		return( successful );
	}
	
}
