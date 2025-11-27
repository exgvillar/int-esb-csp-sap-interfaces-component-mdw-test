package com.consubanco.sap.interfaces.ine;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.ine.model.ZMFile;
import com.consubanco.sap.interfaces.ine.model.ZMInfoINE;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.IStandardSAPProxy;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoTable;

public class ZCRMBIO_E007_GETINFOINE_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog(ZCRMBIO_E007_GETINFOINE_ProxyImpl.class);
	private static final String RFC = "ZCRMBIO_E007_GETINFOINE";

	public ArrayList<IProxyOutputData> executeRemoteFunction(JCoDestination destination,
			ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {

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

			ZCRMBIO_E007_GETINFOINE_OutputData outputData = new ZCRMBIO_E007_GETINFOINE_OutputData();

			outputData.setMessage(function.getExportParameterList().getString("E_MESSAGE"));
			outputData.setSuccess(function.getExportParameterList().getString("E_SUCCESS").equals("X") ? true : false);

			JCoTable infoIneTable = function.getExportParameterList().getTable("E_CUSTOMER");
			ZMInfoINE zMinfoINE = new ZMInfoINE();

			if (infoIneTable.getNumRows() > 0) {
				zMinfoINE.setVoterId(infoIneTable.getString("E_CLAVEELECTOR"));
				zMinfoINE.setStateId(infoIneTable.getString("E_CLAVEESTADO"));
				zMinfoINE.setRegistrationYear(infoIneTable.getString("E_ANIOREGISTRO"));
				zMinfoINE.setIssueNumber(infoIneTable.getString("E_NUMEMISION"));
				zMinfoINE.setIssueYear(infoIneTable.getString("E_ANIOEMISION"));
				zMinfoINE.setValidityYear(infoIneTable.getString("E_VIGENCIA"));
				zMinfoINE.setCic(infoIneTable.getString("E_CIC"));
				zMinfoINE.setOcr(infoIneTable.getString("E_OCR"));
				zMinfoINE.setMechanicalReading(infoIneTable.getString("E_LECTURAMECANICA"));
				zMinfoINE.setPortalCode(infoIneTable.getString("E_CODIGOPORTAL"));
				zMinfoINE.setCity(infoIneTable.getString("E_CIUDAD"));
				zMinfoINE.setCurp(infoIneTable.getString("E_CURP"));

				JCoTable filesTable = infoIneTable.getTable("E_FILES");
				ArrayList<ZMFile> zmFiles = new ArrayList<ZMFile>();

				for (int i = 0; i < filesTable.getNumRows(); i++, filesTable.nextRow()) {
					ZMFile file = new ZMFile();
					file.setBase64(new String(Base64.encodeBase64(filesTable.getByteArray("E_BINARY"))));
					file.setName(filesTable.getString("E_FILE_NAME"));
					zmFiles.add(file);
				}
				zMinfoINE.setFiles(zmFiles);
			}
			outputData.setInfoIne(zMinfoINE);

			returnList.add(outputData);

		} catch (AbapException e) {
			log.error(" executing function " + RFC, e);
			throw e;
		} finally {

		}

		return returnList;
	}
}
