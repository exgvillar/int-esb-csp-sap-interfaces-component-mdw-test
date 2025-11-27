package com.consubanco.sap.interfaces.dispersion;

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

public class ZCRMUTIL_GET_HABINHAB_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZCRMUTIL_GET_HABINHAB_ProxyImpl.class );
	
	public ZCRMUTIL_GET_HABINHAB_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMUTIL_GET_HABINHAB" );
			if(ft == null)
				throw new RuntimeException("ZCRMUTIL_GET_HABINHAB not found in SAP.");
			
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
			
			log.info( "Request Function :: " +  function.getImportParameterList().toString() );
			
			function.execute(destination);
						
			ZCRMUTIL_GET_HABINHAB_OutputData tableData = new ZCRMUTIL_GET_HABINHAB_OutputData();
			
			tableData.setLaborableDay( function.getExportParameterList().getString("E_HABIL").equals("X") ? true : false );
			
			returnList.add( tableData );	
	
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMUTIL_GET_HABINHAB" , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
