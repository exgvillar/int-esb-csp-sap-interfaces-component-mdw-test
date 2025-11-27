package com.consubanco.sap.interfaces.tickets;

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


public class ZCRMRFC_P001_CHGSTS_TKDACL_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZCRMRFC_P001_CHGSTS_TKDACL_ProxyImpl.class );
	
	public ZCRMRFC_P001_CHGSTS_TKDACL_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( "ZCRMRFC_P001_CHGSTS_TKDACL" );
			if(ft == null)
				throw new RuntimeException("ZCRMRFC_P001_CHGSTS_TKDACL not found in SAP.");
			
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
			
						
			ZCRMRFC_P001_CHGSTS_TKDACL_OutputData output = new ZCRMRFC_P001_CHGSTS_TKDACL_OutputData();
			output.setSuccess( function.getExportParameterList().getString("E_OK").equals("X") ? true : false );
			output.setMessage( function.getExportParameterList().getString("E_MESSAGE") );					

			returnList.add( output );
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMRFC_P001_CHGSTS_TKDACL" , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}	
}
