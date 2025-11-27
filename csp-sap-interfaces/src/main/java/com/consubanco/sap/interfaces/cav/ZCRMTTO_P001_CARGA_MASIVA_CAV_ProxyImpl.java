package com.consubanco.sap.interfaces.cav;

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

public class ZCRMTTO_P001_CARGA_MASIVA_CAV_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog(ZCRMTTO_P001_CARGA_MASIVA_CAV_ProxyImpl.class);

	public ZCRMTTO_P001_CARGA_MASIVA_CAV_ProxyImpl() {
		super();
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction(JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;
		try {

			ft = destination.getRepository().getFunctionTemplate("ZCRMTTO_P001_CARGA_MASIVA_CAV");
			if (ft == null)
				throw new RuntimeException("ZCRMTTO_P001_CARGA_MASIVA_CAV not found in SAP.");

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
			
			ZCRMTTO_P001_CARGA_MASIVA_CAV_OutputData data = new ZCRMTTO_P001_CARGA_MASIVA_CAV_OutputData();
			data.setSuccess("x".equalsIgnoreCase(function.getExportParameterList().getString("E_SUCCESS")));
			data.setMessage(function.getExportParameterList().getString("E_MESSAGE"));

			returnList.add(data);

		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMTTO_P001_CARGA_MASIVA_CAV :: ", e);
			throw e;
		} finally {

		}

		return (returnList);
	}

}