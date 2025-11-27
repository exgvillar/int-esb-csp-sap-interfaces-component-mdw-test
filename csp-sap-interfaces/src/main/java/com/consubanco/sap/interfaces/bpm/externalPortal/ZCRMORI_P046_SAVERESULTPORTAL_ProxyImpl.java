package com.consubanco.sap.interfaces.bpm.externalPortal;

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

public class ZCRMORI_P046_SAVERESULTPORTAL_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog(ZCRMORI_P046_SAVERESULTPORTAL_ProxyImpl.class);

	public ZCRMORI_P046_SAVERESULTPORTAL_ProxyImpl() {
		super();
	}
	
	public ArrayList<IProxyOutputData> executeRemoteFunction(JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {

			ft = destination.getRepository().getFunctionTemplate("ZCRMORI_P046_SAVERESULTPORTAL");
			if (ft == null)
				throw new RuntimeException("ZCRMORI_P046_SAVERESULTPORTAL not found in SAP.");

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
			function.execute(destination);

			log.info(function.toString());
			
			String success = function.getExportParameterList().getString("E_SUCCESS");
			String message = function.getExportParameterList().getString("E_MESSAGE");
			
			ZCRMORI_P046_SAVERESULTPORTAL_OutputData outputData = new ZCRMORI_P046_SAVERESULTPORTAL_OutputData();
			if ("X".equalsIgnoreCase(success)) {
				outputData.setSuccess(true);
			}else{
				outputData.setSuccess(false);
				outputData.setMessage(message);				
			}
			
			log.info(function.toString());

			returnList.add(outputData);

		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMORI_P046_SAVERESULTPORTAL", e);
			throw e;
		} finally {

		}
		
		log.info("<-- ZCRMORI_P046_SAVERESULTPORTAL_ProxyImpl.executeRemoteFunction()");
		
		return (returnList);
	}

}
