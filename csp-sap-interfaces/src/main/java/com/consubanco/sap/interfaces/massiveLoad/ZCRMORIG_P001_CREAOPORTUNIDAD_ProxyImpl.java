package com.consubanco.sap.interfaces.massiveLoad;

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

public class ZCRMORIG_P001_CREAOPORTUNIDAD_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZCRMORIG_P001_CREAOPORTUNIDAD_ProxyImpl.class );
	
	
	public ZCRMORIG_P001_CREAOPORTUNIDAD_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMORIG_P001_CREAOPORTUNIDAD" );
			if(ft == null)
				throw new RuntimeException("ZCRMORIG_P001_CREAOPORTUNIDAD not found in SAP.");
			
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
			
			log.info("InputParameters :: " + function.getImportParameterList().toString() );
			function.execute(destination);
			log.info("OutputParameters :: " + function.getExportParameterList().toString() );

			ZCRMORIG_P001_CREAOPORTUNIDAD_OutputData data = new ZCRMORIG_P001_CREAOPORTUNIDAD_OutputData();
			data.setOpportunityId( function.getExportParameterList().getString("E_OPORTUNIDADID") );
			data.setCaseId( function.getExportParameterList().getString("E_CASOID") );
			
			returnList.add( data );
				
	
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMORIG_P001_CREAOPORTUNIDAD" , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
