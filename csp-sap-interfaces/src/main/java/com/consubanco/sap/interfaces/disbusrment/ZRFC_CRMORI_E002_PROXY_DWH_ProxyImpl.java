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
public class ZRFC_CRMORI_E002_PROXY_DWH_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZRFC_CRMORI_E002_PROXY_DWH_ProxyImpl.class );
	
	public ZRFC_CRMORI_E002_PROXY_DWH_ProxyImpl() {
		super();		
	}


	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList ) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {			
			ft = destination.getRepository().getFunctionTemplate( "ZRFC_CRMORI_E002_PROXY_DWH" );
			if(ft == null)
				throw new RuntimeException("ZRFC_CRMORI_E002_PROXY_DWH not found in SAP.");
			
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
			
			ZRFC_CRMORI_E002_PROXY_DWH_OutputData data = new ZRFC_CRMORI_E002_PROXY_DWH_OutputData();
			data.setSuccess( function.getExportParameterList().getString("E_EXITO").equals("X") ? true : false );
			data.setMessage( function.getExportParameterList().getString("E_MESSAGE") );
			
			returnList.add( data );
			
		} catch (AbapException e) {
			log.error(" executing function " + "ZRFC_CRMORI_E002_PROXY_DWH :: ", e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
