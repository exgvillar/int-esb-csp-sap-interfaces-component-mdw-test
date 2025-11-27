package com.consupago.sap.interfaces.proxy.casemgt;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.IStandardSAPProxy;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;

public class ZRFC_SOLICITUD_CASO_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZRFC_SOLICITUD_CASO_ProxyImpl.class );
	
	public ZRFC_SOLICITUD_CASO_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList ) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate("ZRFC_SOLICITUD_CASO");
			if(ft == null)
	            throw new RuntimeException("ZRFC_SOLICITUD_CASO not found in SAP.");
			
			function = ft.getFunction();
	
			// TODO Change to uppercase
			Iterator<ProxyInputParameter> iter = inputParamtersList.iterator();
			while( iter.hasNext() ) {
				ProxyInputParameter inputParam = iter.next();
				function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );	
			}
			
			
			function.execute(destination);
			
			ZRFC_SOLICITUD_CASO_OutputData output = new ZRFC_SOLICITUD_CASO_OutputData();
			output.setCaseId( function.getExportParameterList().getString("P_CASO") );
			
			returnList.add( output );
			
			log.info( "" +  output.toString() );
			
		} catch (AbapException e) {
			log.error(" executing function " + "ZRFC_SOLICITUD_CASO" , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
