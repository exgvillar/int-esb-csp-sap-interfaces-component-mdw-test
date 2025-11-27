package com.consubanco.sap.interfaces.ine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.ine.model.ZMFile;
import com.consubanco.sap.interfaces.ine.model.ZMInfoINE;
import com.consubanco.sap.interfaces.ine.model.ZMSaveInfoINERequest;
import com.consupago.sap.interfaces.format.Formatter;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoParameterList;
import com.sap.conn.jco.JCoTable;

public class ZCRMBIO_P016_SAVEINFOINE_ProxyImpl {

	private static Log log = LogFactory.getLog(ZCRMBIO_P016_SAVEINFOINE_ProxyImpl.class);
	private static final String RFC = "ZCRMBIO_P016_SAVEINFOINE";

	public ArrayList<IProxyOutputData> executeRemoteFunction(JCoDestination destination, ZMSaveInfoINERequest request)
			throws Exception {

		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {

			ft = destination.getRepository().getFunctionTemplate(RFC);
			if (ft == null)
				throw new RuntimeException(RFC + " not found in SAP.");

			function = ft.getFunction();

			JCoParameterList importParameters = function.getImportParameterList();

			log.info("ZMSaveInfoINERequest ---> " + request);

			ZMInfoINE infoINE = request.getInfoINE();

			importParameters.setValue("I_CUSTOMERBP", (StringUtils.trimToNull(request.getCustomerBp()) != null)
					? Formatter.fillStringWithZerosOnLeft(request.getCustomerBp(), 10) : request.getCustomerBp());
			importParameters.setValue("I_CLAVEELECTOR", infoINE.getVoterId());
			importParameters.setValue("I_CLAVEESTADO", infoINE.getStateId());
			importParameters.setValue("I_ANIOREGISTRO", infoINE.getRegistrationYear());
			importParameters.setValue("I_NUMEMISION", infoINE.getIssueNumber());
			importParameters.setValue("I_ANIOEMISION", infoINE.getIssueYear());
			importParameters.setValue("I_VIGENCIA", infoINE.getValidityYear());
			importParameters.setValue("I_CIC", infoINE.getCic());
			importParameters.setValue("I_OCR", infoINE.getOcr());
			importParameters.setValue("I_LECTURAMECANICA", infoINE.getMechanicalReading());
			importParameters.setValue("I_CODIGOPORTAL", infoINE.getPortalCode());
			importParameters.setValue("I_CIUDAD", infoINE.getCity());
			importParameters.setValue("I_CURP", infoINE.getCurp());

			JCoTable tableFiles = importParameters.getTable("I_FILES");

			List<ZMFile> files = infoINE.getFiles();
			if (files != null) {
				Iterator<ZMFile> fileIter = files.iterator();
				while (fileIter.hasNext()) {
					ZMFile file = fileIter.next();
					byte[] decodedBytes =  Base64.decodeBase64(file.getBase64().getBytes()); 
					tableFiles.appendRow();
					tableFiles.setValue("I_FILE_NAME", file.getName());
					tableFiles.setValue("I_BINARY", decodedBytes);
				}
				function.getImportParameterList().setValue("I_FILES", tableFiles);

			}

			function.execute(destination);
			JCoParameterList exportParameters = function.getExportParameterList();

			ZCRMBIO_P016_SAVEINFOINE_OutputData outputData = new ZCRMBIO_P016_SAVEINFOINE_OutputData();
			outputData.setMessage(exportParameters.getString("E_MESSAGE"));
			outputData.setSuccess("X".equalsIgnoreCase(exportParameters.getString("E_SUCCESS")));
			log.info("ZCRMBIO_P016_SAVEINFOINE_OutputData ---> " + outputData);
			returnList.add(outputData);

		} catch (AbapException e) {
			log.error(" executing function " + RFC, e);
			throw e;
		}

		return returnList;
	}
}
