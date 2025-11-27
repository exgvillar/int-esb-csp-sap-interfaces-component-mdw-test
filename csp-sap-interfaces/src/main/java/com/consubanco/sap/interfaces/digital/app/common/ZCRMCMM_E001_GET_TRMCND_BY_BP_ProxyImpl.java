package com.consubanco.sap.interfaces.digital.app.common;


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

public class ZCRMCMM_E001_GET_TRMCND_BY_BP_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZCRMCMM_E001_GET_TRMCND_BY_BP_ProxyImpl.class );
	
	public ZCRMCMM_E001_GET_TRMCND_BY_BP_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMCMM_E001_GET_TRMCND_BY_BP" );
			if(ft == null)
				throw new RuntimeException("ZCRMCMM_E001_GET_TRMCND_BY_BP not found in SAP.");
			
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
			
			
			log.info("Input :: " + function.getImportParameterList().toString() );
			function.execute(destination);
			
			ZCRMCMM_E001_GET_TRMCND_BY_BP_OutputData tableData = new ZCRMCMM_E001_GET_TRMCND_BY_BP_OutputData();
			tableData.setTermsConditionsAccepted( function.getExportParameterList().getString("E_ZACEPTA_TERM_COND").equals("X") ? true : false );
			tableData.setCreateDate( function.getExportParameterList().getDate("E_ZCREATE_DATE") );
			tableData.setUpdateDate( function.getExportParameterList().getDate("E_ZUPDATE_DATE") );
			tableData.setMessage( function.getExportParameterList().getString("E_MESSAGE") );
			returnList.add( tableData );
			
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMCMM_E001_GET_TRMCND_BY_BP" , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
