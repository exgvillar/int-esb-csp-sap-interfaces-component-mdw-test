package com.consubanco.sap.interfaces.commons.relations;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;


public class ZCRMORI_P018_ADDINQ_SOLBPM_ProxyImpl {

	private static Log log = LogFactory.getLog( ZCRMORI_P018_ADDINQ_SOLBPM_ProxyImpl.class );
	
	public ZCRMORI_P018_ADDINQ_SOLBPM_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList ) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMORI_P018_ADDINQ_SOLBPM" );
			if(ft == null)
				throw new RuntimeException("ZCRMORI_P018_ADDINQ_SOLBPM not found in SAP.");
			
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
			
			log.info( "INPUT DATA :: " + function.getImportParameterList().toString() );
		
			function.execute(destination);

			ZCRMORI_P018_ADDINQ_SOLBPM_OutputData output = new ZCRMORI_P018_ADDINQ_SOLBPM_OutputData();
				
			output.setRequestId( function.getExportParameterList().getString("E_SOLICIT") );
			output.setProcessId( function.getExportParameterList().getLong("E_PROCESS") );
			output.setExecutionDate( function.getExportParameterList().getDate("E_FECHA") );
			output.setExecutionHour( function.getExportParameterList().getString("E_HORA") );
				
			log.info( "OUTPUT DATA ::" + output.toString() );
			returnList.add( output );
	
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMORI_P018_ADDINQ_SOLBPM" , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
