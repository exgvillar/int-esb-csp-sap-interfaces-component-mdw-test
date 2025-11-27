package com.consubanco.sap.interfaces.cxn.followup;

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


public class ZRFC_FOLLOWUP_ProxyImpl {

	private static Log log = LogFactory.getLog( ZRFC_FOLLOWUP_ProxyImpl.class );
	
	public ZRFC_FOLLOWUP_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList ) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZRFC_FOLLOWUP" );
			if(ft == null)
				throw new RuntimeException("ZRFC_FOLLOWUP not found in SAP.");
			
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
			
			
		
			function.execute(destination);

			ZRFC_FOLLOWUP_OutputData output = new ZRFC_FOLLOWUP_OutputData();
			
			log.info( function.toString() );
			
			log.info( "" +  function.getExportParameterList().getString("ZID_SOLICITUD").toString() );
			log.info( "" +  function.getExportParameterList().getString("ZID_CASO").toString() );
			log.info( "" +  function.getExportParameterList().getString("ZID_OPORTUNIDAD").toString() );
			
			output.setRequestId( function.getExportParameterList().getString("ZID_SOLICITUD") );
			output.setCaseId( function.getExportParameterList().getString("ZID_CASO") );
			output.setOpportunityId( function.getExportParameterList().getString("ZID_OPORTUNIDAD") );
			
			returnList.add( output );
	
		} catch (AbapException e) {
			log.error(" executing function " + "ZRFC_FOLLOWUP" , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
