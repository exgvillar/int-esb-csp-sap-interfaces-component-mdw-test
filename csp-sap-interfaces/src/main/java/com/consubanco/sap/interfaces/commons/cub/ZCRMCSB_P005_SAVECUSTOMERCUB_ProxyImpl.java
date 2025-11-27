/**
 * 
 */
package com.consubanco.sap.interfaces.commons.cub;

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

/**
 * @author estefania.montoya
 *
 */
public class ZCRMCSB_P005_SAVECUSTOMERCUB_ProxyImpl implements IStandardSAPProxy {
	
	private static Log logger = LogFactory.getLog(ZCRMCSB_P005_SAVECUSTOMERCUB_ProxyImpl.class);

	public ArrayList<IProxyOutputData> executeRemoteFunction(JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {

			ft = destination.getRepository().getFunctionTemplate("ZCRMCSB_P005_SAVECUSTOMERCUB");
			if (ft == null)
				throw new RuntimeException("ZCRMCSB_P005_SAVECUSTOMERCUB not found in SAP.");

			function = ft.getFunction();

			logger.info("Function.Import:ZCRMCSB_P005_SAVECUSTOMERCUB: " + function.getImportParameterList().toString());

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
			logger.info("Function.Export:ZCRMCSB_P005_SAVECUSTOMERCUB: " + function.getExportParameterList().toString());

			ZCRMCSB_P005_SAVECUSTOMERCUB_OutputData output = new ZCRMCSB_P005_SAVECUSTOMERCUB_OutputData();
			output.setSuccess(function.getExportParameterList().getString("E_SUCCESS").equals("X") ? true : false);
			output.setMessage(function.getExportParameterList().getString("E_MESSAGE"));

			returnList.add(output);
		} catch (AbapException e) {
			logger.error(" executing function " + "ZCRMCSB_P005_SAVECUSTOMERCUB", e);
			throw e;
		}

		return (returnList);
	}

}
