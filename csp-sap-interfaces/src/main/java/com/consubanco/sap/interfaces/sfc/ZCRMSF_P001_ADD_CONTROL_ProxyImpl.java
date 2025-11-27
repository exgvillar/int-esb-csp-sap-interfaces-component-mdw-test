package com.consubanco.sap.interfaces.sfc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;

public class ZCRMSF_P001_ADD_CONTROL_ProxyImpl {

	private static Log log = LogFactory.getLog(ZCRMSF_P001_ADD_CONTROL_ProxyImpl.class);
	private static final String RFC = "ZCRMSF_P001_ADD_CONTROL";
	
	public List<IProxyOutputData> executeRemoteFunction(JCoDestination destination,
			List<ProxyInputParameter> inputParamtersList) throws Exception {
		
		ZCRMSF_P001_ADD_CONTROL_OutputData outputData = new ZCRMSF_P001_ADD_CONTROL_OutputData();
		List<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			ft = destination.getRepository().getFunctionTemplate( RFC );
			if( ft == null ) {
				throw new RuntimeException(RFC + " not found in SAP.");
			}
			
			function = ft.getFunction();
			
			Iterator<ProxyInputParameter> iter = inputParamtersList.iterator();
			while (iter.hasNext()) {
				ProxyInputParameter inputParam = iter.next();
				if (StringUtils.trimToNull(inputParam.getType()) == null) {
					function.getImportParameterList().setValue(inputParam.getKey(), inputParam.getValue());
				} else {
					if (inputParam.getType().equals("java.util.date"))
						function.getImportParameterList().setValue(inputParam.getKey(), inputParam.getDateValue());
					else
						function.getImportParameterList().setValue(inputParam.getKey(), inputParam.getValue());
				}
			}
			
			log.info(function.getImportParameterList().toString());
			
			function.execute(destination);
			
			log.info(function.getExportParameterList().toString());
			
			String message = function.getExportParameterList().getString("E_MESSAGE");			
			String success = function.getExportParameterList().getString("E_SUCCESS");
			String code = function.getExportParameterList().getString("E_CODE");
									
			outputData.setMessage(message);
			outputData.setSuccess(success);
			outputData.setCode(code);
			returnList.add(outputData);
			
			log.info( "RFC :: " + RFC );
			log.info( "Return data ---> " + returnList.toString());
	
		} catch (AbapException e) {
			log.error(" executing function " + RFC);
			log.error(e);
			throw e;
		} 
		
		return (returnList);
	}
}
