package com.consubanco.sap.interfaces.recomendados;

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

public class ZCRMRECO_P005_UPDSO_BRMS_BKR_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZCRMRECO_P005_UPDSO_BRMS_BKR_ProxyImpl.class );
	
	public ZCRMRECO_P005_UPDSO_BRMS_BKR_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		ZCRMRECO_P005_UPDSO_BRMS_BKR_OutputData data = null;
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMRECO_P005_UPDSO_BRMS_BKR" );
			if(ft == null)
				throw new RuntimeException("ZCRMRECO_P005_UPDSO_BRMS_BKR not found in SAP.");
			
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
			
			data = new ZCRMRECO_P005_UPDSO_BRMS_BKR_OutputData();
			data.setMessage( StringUtils.trimToNull( function.getExportParameterList().getString("E_MESSAGES") ) );
			 
			returnList.add( data );
				
	
		} catch (AbapException e) {
			data = new ZCRMRECO_P005_UPDSO_BRMS_BKR_OutputData();
			data.setMessage( e.toString() );
			returnList.add( data );
			log.error(" executing function " + "ZCRMRECO_P005_UPDSO_BRMS_BKR" , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
