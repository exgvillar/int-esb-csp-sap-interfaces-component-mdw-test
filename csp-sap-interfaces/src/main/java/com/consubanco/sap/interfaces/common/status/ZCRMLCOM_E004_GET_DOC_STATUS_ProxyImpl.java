package com.consubanco.sap.interfaces.common.status;

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
import com.sap.conn.jco.JCoParameterList;
import com.sap.conn.jco.JCoTable;

public class ZCRMLCOM_E004_GET_DOC_STATUS_ProxyImpl  {

	private static Log log = LogFactory.getLog( ZCRMLCOM_E004_GET_DOC_STATUS_ProxyImpl.class );
	
	private final String RFC_NAME = "ZCRMLCOM_E004_GET_DOC_STATUS";
	
	public ZCRMLCOM_E004_GET_DOC_STATUS_ProxyImpl() {
		super();		
	}

	public ZCRMLCOM_E004_GET_DOC_STATUS_OutputData executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
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
			
			ZCRMLCOM_E004_GET_DOC_STATUS_OutputData datRet = new ZCRMLCOM_E004_GET_DOC_STATUS_OutputData();
			
			JCoParameterList output = function.getExportParameterList();
			datRet.setEstatus(StringUtils.trimToNull(output.getString("E_ESTATUS")));
			datRet.setDescrip(StringUtils.trimToNull(output.getString("E_DESCRIP")));
			datRet.setMessage(StringUtils.trimToNull(output.getString("E_MESSAGE")));
		
			return (datRet);

		} catch (AbapException e) {
			log.error(" executing function " + RFC_NAME , e);
			throw e;
		} finally {
			
		}
	}
	
}
