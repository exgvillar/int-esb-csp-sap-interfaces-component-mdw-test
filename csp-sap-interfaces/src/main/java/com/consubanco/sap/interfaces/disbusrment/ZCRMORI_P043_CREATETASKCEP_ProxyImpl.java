package com.consubanco.sap.interfaces.disbusrment;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.IStandardSAPProxy;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;

/**
 * @author hsanchez
 *
 */
public class ZCRMORI_P043_CREATETASKCEP_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZCRMORI_P043_CREATETASKCEP_ProxyImpl.class );
	
	public ZCRMORI_P043_CREATETASKCEP_ProxyImpl() {
		super();		
	}


	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList ) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMORI_P043_CREATETASKCEP" );
			if(ft == null)
				throw new RuntimeException("ZCRMORI_P043_CREATETASKCEP not found in SAP.");
			
			function = ft.getFunction();		
			
			Iterator<ProxyInputParameter> iter = inputParamtersList.iterator();
			while( iter.hasNext() ) {
				ProxyInputParameter inputParam = iter.next();
				if( StringUtils.trimToNull( inputParam.getType() ) == null ) {
					function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );	
				} else {
					if( inputParam.getType().equals("java.util.Date") )
						function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getDateValue() );
					else
						function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );
				}
			}
			
			log.info("Function.Import: " + function.getImportParameterList().toString() );
			function.execute(destination);			
			log.info("Function.Export: " + function.getExportParameterList().toString() );			
			
			ZCRMORI_P043_CREATETASKCEP_OutputData data = new ZCRMORI_P043_CREATETASKCEP_OutputData();
			data.setTaskId( function.getExportParameterList().getString("E_TASK_ID") );
			data.setMessage( function.getExportParameterList().getString("E_MESSAGE") );
			
			returnList.add( data );
			
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMORI_P043_CREATETASKCEP :: ", e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
