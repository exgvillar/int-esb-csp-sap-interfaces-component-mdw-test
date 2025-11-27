/**
 * 
 */
package com.consubanco.sap.interfaces.commons;

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
 * @author Ing. Adrian Alejo - Tw @adrixmnt
 *
 */
public class ZCRMCSB_P003_SAVECUSTFLAG_ProxyImpl implements IStandardSAPProxy {

	private static Log logger = LogFactory.getLog(ZCRMCSB_P003_SAVECUSTFLAG_ProxyImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.consupago.sap.interfaces.proxy.IStandardSAPProxy#
	 * executeRemoteFunction(com.sap.conn.jco.JCoDestination,
	 * java.util.ArrayList)
	 */
	public ArrayList<IProxyOutputData> executeRemoteFunction(JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {

		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {

			ft = destination.getRepository().getFunctionTemplate("ZCRMCSB_P003_SAVECUSTFLAG");
			if (ft == null)
				throw new RuntimeException("ZCRMCSB_P003_SAVECUSTFLAG not found in SAP.");

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

			ZCRMCSB_P003_SAVECUSTFLAG_OutputData output = new ZCRMCSB_P003_SAVECUSTFLAG_OutputData();
			output.setSuccess(function.getExportParameterList().getString("E_SUCCESS").equals("X") ? true : false);
			output.setMessage(function.getExportParameterList().getString("E_MESSAGE"));

			returnList.add(output);
		} catch (AbapException e) {
			logger.error(" executing function " + "ZCRMCSB_P003_SAVECUSTFLAG", e);
			throw e;
		}

		return (returnList);
	}

}
