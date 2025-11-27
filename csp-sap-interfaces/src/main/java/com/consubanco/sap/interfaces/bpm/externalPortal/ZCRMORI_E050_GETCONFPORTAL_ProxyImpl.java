package com.consubanco.sap.interfaces.bpm.externalPortal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.bpm.externalPortal.model.ZCRMORI_E050_GETCONFPORTAL_Model;
import com.consubanco.sap.interfaces.bpm.externalPortal.model.ZESCRMORI_E052_E_DOCUMENTO_Model;
import com.consubanco.sap.interfaces.bpm.externalPortal.model.ZESCRMORI_E052_ZDINAMICOS_Model;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.IStandardSAPProxy;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoStructure;
import com.sap.conn.jco.JCoTable;

public class ZCRMORI_E050_GETCONFPORTAL_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog(ZCRMORI_E050_GETCONFPORTAL_ProxyImpl.class);

	public ZCRMORI_E050_GETCONFPORTAL_ProxyImpl() {
		super();
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction(JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {

			ft = destination.getRepository().getFunctionTemplate("ZCRMORI_E050_GETCONFPORTAL");
			if (ft == null)
				throw new RuntimeException("ZCRMORI_E050_GETCONFPORTAL not found in SAP.");

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

			ZCRMORI_E050_GETCONFPORTAL_OutputData outputData = new ZCRMORI_E050_GETCONFPORTAL_OutputData();
			if ("X".equalsIgnoreCase(success)) {
				List<ZESCRMORI_E052_ZDINAMICOS_Model> fields = new ArrayList<ZESCRMORI_E052_ZDINAMICOS_Model>();
				List<ZESCRMORI_E052_E_DOCUMENTO_Model> documents = new ArrayList<ZESCRMORI_E052_E_DOCUMENTO_Model>();
				outputData.setSuccess(true);

				ZCRMORI_E050_GETCONFPORTAL_Model datosPortal = new ZCRMORI_E050_GETCONFPORTAL_Model();
				
				JCoStructure structure = function.getExportParameterList().getStructure(("E_DATOSPORTAL"));
				log.info(structure.toString());

				datosPortal.setId(structure.getString("E_PORTALID"));
				datosPortal.setNombre(structure.getString("E_PORTALNAME"));
				datosPortal.setUser(structure.getString("E_USER"));
				datosPortal.setPassword(structure.getString("E_PASSWORD"));
				datosPortal.setUrl(structure.getString("E_URL"));
				datosPortal.setFicha(structure.getString("E_FICHA"));
				datosPortal.setNomina(structure.getString("E_NOMINA"));
				datosPortal.setIdDoctoAnexo(structure.getString("E_DOCOANEXOPORTAL"));
				datosPortal.setClaveDcto(structure.getString("E_CLAVEDESCUENTO"));
				
				JCoTable dinamicsTable = structure.getTable("E_DINAMICOS");
				for (int i = 0; i < dinamicsTable.getNumRows(); i++, dinamicsTable.nextRow()){
					fields.add(
							new ZESCRMORI_E052_ZDINAMICOS_Model(
									dinamicsTable.getString("E_IDDOCUMENTO"), 
									dinamicsTable.getString("E_IDCAMPO"),
									dinamicsTable.getString("E_VALOR"),
									dinamicsTable.getString("E_NAME")
									));
									
				}
				datosPortal.setFields(fields);
				
				JCoTable documentsTable = structure.getTable("E_DOCUMENTOS");
				for (int i = 0; i < documentsTable.getNumRows(); i++, documentsTable.nextRow()){
					documents.add(
							new ZESCRMORI_E052_E_DOCUMENTO_Model(
									documentsTable.getString("DOCTOID"), 
									documentsTable.getString("DOCTONOMBRE"),
									documentsTable.getString("DOCTOIDPORTAL")
									));
									
				}
				datosPortal.setDocuments(documents);
				
				System.out.println("Documentos: "+documents.size());
				
				outputData.setDatosPortal(datosPortal);
			}else{
				outputData.setSuccess(false);
				outputData.setMessage(message);
			}
			
			log.info(function.toString());

			returnList.add(outputData);

		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMORI_E050_GETCONFPORTAL", e);
			throw e;
		} finally {

		}
		
		log.info("<-- ZCRMORI_E050_GETCONFPORTAL_ProxyImpl.executeRemoteFunction()");
		
		return (returnList);
	}

}
