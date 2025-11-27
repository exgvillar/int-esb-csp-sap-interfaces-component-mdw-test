package com.consubanco.sap.interfaces.cxn.forms;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.IStandardSAPProxy;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;

public class ZCRMORI_P102_PDF_FOLIOCC_ProxyImpl implements IStandardSAPProxy {
	
	private static Log log = LogFactory.getLog(ZCRMORI_P102_PDF_FOLIOCC_ProxyImpl.class);

	public ZCRMORI_P102_PDF_FOLIOCC_ProxyImpl() {
		super();
	}

	
	public ArrayList<IProxyOutputData> executeRemoteFunction(JCoDestination destination,
			ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {

		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			ft = destination.getRepository().getFunctionTemplate("ZCRMORI_P102_PDF_FOLIOCC");
			if (ft == null)
				throw new RuntimeException("ZCRMORI_P102_PDF_FOLIOCC not found in SAP.");

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

			log.info("Function.Import: " + function.getImportParameterList().toString());
			function.execute(destination);
			log.info("Function.Export: " + function.getExportParameterList().toString());
			
			ZCRMORI_P102_PDF_FOLIOCC_OutputData outputData = new ZCRMORI_P102_PDF_FOLIOCC_OutputData();
			outputData.setSuccess(function.getExportParameterList().getString("E_SUCCESS").equals("X") ? true : false );
			outputData.setMessage( function.getExportParameterList().getString("E_MESSAGE") );


			returnList.add(outputData);
		} catch (Exception e) {
			log.error(" executing function " + "ZCRMORI_P102_PDF_FOLIOCC_ProxyImpl : ", e);
			throw e;
		}

		return returnList;
	}

}
