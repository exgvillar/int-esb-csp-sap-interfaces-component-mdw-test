package com.consubanco.sap.interfaces.ine;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.ine.model.ZMFile;
import com.consubanco.sap.interfaces.ine.model.ZMValidINERequest;
import com.consupago.sap.interfaces.format.Formatter;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.IStandardSAPProxy;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoParameterList;
import com.sap.conn.jco.JCoTable;



public class ZCRMBIO_E006_VALIDATEINE_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog(ZCRMBIO_E006_VALIDATEINE_ProxyImpl.class);
	private static final String RFC = "ZCRMBIO_E006_VALIDATEINE";

	public ArrayList<IProxyOutputData> executeRemoteFunction(JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList)
			throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;


		try {

			ft = destination.getRepository().getFunctionTemplate(RFC);
			if (ft == null)
				throw new RuntimeException(RFC + " not found in SAP.");

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
			
			ZCRMBIO_E006_VALIDATEINE_OutputData outputData = new ZCRMBIO_E006_VALIDATEINE_OutputData();
			outputData.setMessage(function.getExportParameterList().getString("E_MESSAGE"));
			outputData.setSuccess(function.getExportParameterList().getString("E_SUCCESS").equals("X") ? true : false);

			outputData.setTaskBiometricsID(function.getExportParameterList().getString("E_TASKBIOMETRICSID"));
			outputData.setIneValidity(function.getExportParameterList().getString("E_INEVIGENCIA"));
			outputData.setValid("X".equalsIgnoreCase(function.getExportParameterList().getString("E_ISVALID")));

			JCoTable filesTable = function.getExportParameterList().getTable("E_FILES");

			for (int i = 0; i < filesTable.getNumRows(); i++, filesTable.nextRow()) {
				ZMFile file = new ZMFile();
				file.setName(filesTable.getString("I_FILE_NAME"));
				file.setBase64(java.util.Base64.getEncoder().encodeToString(filesTable.getByteArray("I_BINARY")));
			}
			log.info("ZCRMBIO_E006_VALIDATEINE_OutputData ---> " + outputData);
			returnList.add(outputData);

		} catch (AbapException e) {
			log.error(" executing function " + RFC, e);
			throw e;
		}

		return returnList;

//
//		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
//		JCoFunctionTemplate ft = null;
//		JCoFunction function = null;
//		BASE64Encoder encoder = new BASE64Encoder();
//
//		try {
//
//			ft = destination.getRepository().getFunctionTemplate(RFC);
//			if (ft == null)
//				throw new RuntimeException(RFC + " not found in SAP.");
//
//			function = ft.getFunction();
//
//			JCoParameterList importParameters = function.getImportParameterList();
//
//			log.info("ZMValidINERequest ---> " + request);
//
//			importParameters.setValue("I_CUSTOMERBP", (StringUtils.trimToNull(request.getCustomerBp()) != null)
//					? Formatter.fillStringWithZerosOnLeft(request.getCustomerBp(), 10) : request.getCustomerBp());
//			// importParameters.setValue("I_FOLIOAPPREFERENCE",
//			// (StringUtils.trimToNull(request.getSheetAPPReference())!=null)?Formatter.fillStringWithZerosOnLeft(request.getSheetAPPReference(),
//			// 10) : request.getSheetAPPReference());
//
//			function.execute(destination);
//			JCoParameterList exportParameters = function.getExportParameterList();
//
//			ZCRMBIO_E006_VALIDATEINE_OutputData outputData = new ZCRMBIO_E006_VALIDATEINE_OutputData();
//			outputData.setMessage(exportParameters.getString("E_MESSAGE"));
//			outputData.setSuccess("X".equalsIgnoreCase(exportParameters.getString("E_SUCCESS")));
//			outputData.setTaskBiometricsID(exportParameters.getString("E_TASKBIOMETRICSID"));
//			outputData.setIneValidity(exportParameters.getString("E_INEVIGENCIA"));
//			outputData.setValid("X".equalsIgnoreCase(exportParameters.getString("E_ISVALID")));
//
//			JCoTable filesTable = exportParameters.getTable("E_FILES");
//
//			for (int i = 0; i < filesTable.getNumRows(); i++, filesTable.nextRow()) {
//				ZMFile file = new ZMFile();
//				file.setName(filesTable.getString("I_FILE_NAME"));
//				file.setBase64(encoder.encode(filesTable.getByteArray("I_BINARY")));
//			}
//
		
	}
}
