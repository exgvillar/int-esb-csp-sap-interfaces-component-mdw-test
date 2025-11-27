package com.consubanco.sap.interfaces.common.terminados;

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

public class ZCRMCRT_P001_SAVE_CONYUGE_ProxyImpl implements IStandardSAPProxy {
	private static Log log = LogFactory.getLog(ZCRMCRT_P001_SAVE_CONYUGE_ProxyImpl.class);

	public ArrayList<IProxyOutputData> executeRemoteFunction(JCoDestination destination,
			ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {

			ft = destination.getRepository().getFunctionTemplate("ZCRMCRT_P001_SAVE_CONYUGE");
			if (ft == null)
				throw new RuntimeException("ZCRMCRT_P001_SAVE_CONYUGE not found in SAP.");

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

			log.info("Input :: " + function.getImportParameterList().toString());
			function.execute(destination);
			log.info("Output :: " + function.getExportParameterList().toString());

			ZCRMCRT_P001_SAVE_CONYUGE_OutputData data = new ZCRMCRT_P001_SAVE_CONYUGE_OutputData();
			data.setBp(function.getExportParameterList().getString("E_BP_CONYUGE"));
			data.setSuccess(function.getExportParameterList().getString("E_SUCCESS").equals("X") ? true : false);
			data.setMessage(function.getExportParameterList().getString("E_MESSAGE"));

			returnList.add(data);

		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMCRT_P001_SAVE_CONYUGE", e);
			throw e;
		} finally {

		}

		return (returnList);
	}

}
