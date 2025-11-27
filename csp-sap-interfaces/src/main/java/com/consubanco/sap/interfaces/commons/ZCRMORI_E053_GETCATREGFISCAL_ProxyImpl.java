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
import com.sap.conn.jco.JCoTable;

public class ZCRMORI_E053_GETCATREGFISCAL_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog(ZCRMORI_E053_GETCATREGFISCAL_ProxyImpl.class);

	public ZCRMORI_E053_GETCATREGFISCAL_ProxyImpl() {
		super();
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction(JCoDestination destination,
			ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {

		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {

			ft = destination.getRepository().getFunctionTemplate("ZCRMORI_E053_GETCATREGFISCAL");
			if (ft == null)
				throw new RuntimeException("ZCRMORI_E053_GETCATREGFISCAL not found in SAP.");

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

			JCoTable data = function.getExportParameterList().getTable("E_DATOSFISCALES");

			log.info("" + data.toString());
			for (int i = 0; i < data.getNumRows(); i++, data.nextRow()) {
				ZCRMORI_E053_GETCATREGFISCAL_OutputData tableData = new ZCRMORI_E053_GETCATREGFISCAL_OutputData();

				tableData.setKey(StringUtils.trimToEmpty(data.getString("E_ID")).toUpperCase());
				tableData.setDescription(StringUtils.trimToEmpty(data.getString("E_DESCRIPCION")).toUpperCase());

				returnList.add(tableData);
			}

		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMORI_E053_GETCATREGFISCAL", e);
			throw e;
		} finally {

		}

		return (returnList);
	}

}
