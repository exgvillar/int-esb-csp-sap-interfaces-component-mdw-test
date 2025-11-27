package com.consubanco.sap.interfaces.cxn.loans;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.cxn.loans.model.ZCRMORI_P002_UPDSTSCNCATASK_Model;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;

public class ZCRMORI_P002_UPDSTSCNCATASK_ProxyImpl {
	
	private static Log log = LogFactory.getLog(ZCRMORI_P002_UPDSTSCNCATASK_ProxyImpl.class);
	private final String rfc = "ZCRMORI_P002_UPDSTSCNCATASK";
	
	public List<IProxyOutputData> executeRemoteFunction(JCoDestination destination,
			ZCRMORI_P002_UPDSTSCNCATASK_Model inputParamsModel) throws Exception {
		
		ZCRMORI_P002_UPDSTSCNCATASK_OutputData outputData = new ZCRMORI_P002_UPDSTSCNCATASK_OutputData();
		List<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			ft = destination.getRepository().getFunctionTemplate( rfc );
			if( ft == null ) {
				throw new RuntimeException(rfc + " not found in SAP.");
			}
			
			function = ft.getFunction();
			
			if( inputParamsModel != null ) {
				function.getImportParameterList().setValue("I_TASKID", inputParamsModel.getTaskId());
				function.getImportParameterList().setValue("I_STATUSID", inputParamsModel.getStatus().getKey());
			}	
			
			log.info(function.getImportParameterList().toString());
			
			function.execute(destination);
			
			log.info(function.getExportParameterList().toString());
			
			String message = function.getExportParameterList().getString("E_MESSAGE");			
			String success = function.getExportParameterList().getString("E_SUCCESS");
									
			outputData.setMessage(message);
			outputData.setSuccess(success);
			returnList.add(outputData);
			
			log.info( "RFC :: " + rfc );
			log.info( "Return data ---> " + returnList.toString());
	
		} catch (AbapException e) {
			log.error(" executing function " + rfc);
			log.error(e);
			throw e;
		} 
		
		return (returnList);
	}
}
