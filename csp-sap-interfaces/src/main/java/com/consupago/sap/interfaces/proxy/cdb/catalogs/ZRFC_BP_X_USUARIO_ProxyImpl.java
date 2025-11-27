package com.consupago.sap.interfaces.proxy.cdb.catalogs;

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

public class ZRFC_BP_X_USUARIO_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZRFC_SUC_EMP_X_USUARIO_ProxyImpl.class );
	
	public ZRFC_BP_X_USUARIO_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate("ZRFC_BP_X_USUARIO");
			if(ft == null)
	            throw new RuntimeException("ZRFC_BP_X_USUARIO not found in SAP.");
			
			function = ft.getFunction();
	
			// TODO Change to uppercase
			Iterator<ProxyInputParameter> iter = inputParamtersList.iterator();
			while( iter.hasNext() ) {
				ProxyInputParameter inputParam = iter.next();
				function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );	
			}
			
			
			function.execute(destination);
			
			ZRFC_BP_X_USUARIO_OutputData output = new ZRFC_BP_X_USUARIO_OutputData();
			output.setBusinessPartnerId( function.getExportParameterList().getString("E_NUMBP") );
			output.setBusinessPartnerName( function.getExportParameterList().getString("E_NOMBP") );
			output.setCellPhone( function.getExportParameterList().getString("E_CELULAR") );
			returnList.add( output );
			
			log.info( "" +  output.toString() );
			
		} catch (AbapException e) {
			log.error(" executing function " + "ZRFC_BP_X_USUARIO" , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
