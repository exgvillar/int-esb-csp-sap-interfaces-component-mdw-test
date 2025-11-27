package com.consupago.sap.interfaces.proxy.cotizador;

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

public class ZRFC_GET_CALCULOCAT_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog( ZRFC_GET_CALCULOCAT_ProxyImpl.class );
	
	private final String RFC_NAME = "ZRFC_GET_CALCULOCAT";
	
	public ZRFC_GET_CALCULOCAT_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			
			ft = destination.getRepository().getFunctionTemplate( RFC_NAME );
			if(ft == null)
	            throw new RuntimeException( RFC_NAME + " not found in SAP.");
			
			function = ft.getFunction();
	
			Iterator<ProxyInputParameter> iter = inputParamtersList.iterator();
			while( iter.hasNext() ) {
				ProxyInputParameter inputParam = iter.next();
//				function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );
				
				if( StringUtils.trimToNull( inputParam.getType() ) == null ) {
					function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );	
				} else {
					if( inputParam.getType().equals("java.util.date") )
						function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getDateValue() );
					else if( inputParam.getType().equals("java.lang.Double") )
						function.getImportParameterList().setValue( inputParam.getKey(), Double.valueOf( inputParam.getValue() ) );
					else if( inputParam.getType().equals("java.lang.Integer") )
						function.getImportParameterList().setValue( inputParam.getKey(), Integer.valueOf( inputParam.getValue() ) );
					else
						function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );
				}
			}
			
			
			function.execute(destination);
			
			ZRFC_GET_CALCULOCAT_OutputData tableData = new ZRFC_GET_CALCULOCAT_OutputData();
			tableData.setMontoDescuento( function.getExportParameterList().getDouble("MONTODES") );
			tableData.setTasaInteres( function.getExportParameterList().getString("TASA_INT") );
			tableData.setCAT( function.getExportParameterList().getDouble("TASA_CAT") );
			
			returnList.add( tableData );	
			
			
		} catch (AbapException e) {
			log.error(" executing function " + RFC_NAME , e);
			throw e;
		} finally {
			
		}
		
		return( returnList );
	}
	
}
