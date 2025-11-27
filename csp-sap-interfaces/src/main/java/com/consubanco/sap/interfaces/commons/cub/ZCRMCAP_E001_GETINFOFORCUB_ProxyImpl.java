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
import com.sap.conn.jco.JCoStructure;

/**
 * @author estefania.montoya
 *
 */
public class ZCRMCAP_E001_GETINFOFORCUB_ProxyImpl implements IStandardSAPProxy {

	private static Log logger = LogFactory.getLog(ZCRMCAP_E001_GETINFOFORCUB_ProxyImpl.class);

	public ArrayList<IProxyOutputData> executeRemoteFunction(JCoDestination destination,
			ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {

		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;
		
		try {

			ft = destination.getRepository().getFunctionTemplate("ZCRMCAP_E001_GETINFOFORCUB");
			if (ft == null)
				throw new RuntimeException("ZCRMCAP_E001_GETINFOFORCUB not found in SAP.");

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

			logger.info("Function.Import: " + function.getImportParameterList().toString());
			function.execute(destination);
			logger.info("Function.Export: " + function.getExportParameterList().toString());

			ZCRMCAP_E001_GETINFOFORCUB_OutputData output = new ZCRMCAP_E001_GETINFOFORCUB_OutputData();

			output.setMessage(function.getExportParameterList().getString("E_MESSAGE"));
			output.setIdTask(function.getExportParameterList().getString("E_IDTASK"));
			output.setCustomerBP(function.getExportParameterList().getString("E_CUSTOMERBP"));
			output.setCellphone(function.getExportParameterList().getString("E_CELLPHONENUMBER"));
			output.setVerifiedCode(function.getExportParameterList().getString("E_VERIFEDCODE"));
			output.setStatusId(function.getExportParameterList().getString("E_STATUSID"));
			output.setChannel(function.getExportParameterList().getString("E_CHANNEL"));
			output.setSuccess(function.getExportParameterList().getString("E_SUCCESS").equals("X") ? true : false);

			JCoStructure laborData = function.getExportParameterList().getStructure("E_DATOS_LABORALES");
			output.setName(laborData.getString("NAME"));
			output.setLastName(laborData.getString("NAME_LAST"));
			output.setLastName2(laborData.getString("NAME_LAST2"));
			output.setBirthday(laborData.getString("BIRTHDAY"));
			output.setGender(laborData.getString("GENDER"));
			output.setEntdFed(laborData.getString("ENTD_FED"));
			output.setCountryBirth(laborData.getString("COUNTRY"));
			output.setNationality(laborData.getString("NATIONALITY"));
			output.setCurp(laborData.getString("CURP"));
			output.setRfc(laborData.getString("RFC"));
			output.setClavElect(laborData.getString("CLAV_ELECT"));
			output.setFiel(laborData.getString("FIEL"));
			output.setOcupacion(laborData.getString("OCUPACION"));

			JCoStructure DomiData = function.getExportParameterList().getStructure("E_DATOS_DOMICILIO");
			output.setStreet(DomiData.getString("STREET"));
			output.setCol(DomiData.getString("COL"));
			output.setState(DomiData.getString("STATE"));
			output.setCountry(DomiData.getString("COUNTRY"));
			output.setPostCode(DomiData.getString("POST_CODE"));
			output.setNumExt(DomiData.getString("NUMEXT"));
			output.setNumInt(DomiData.getString("NUMINT"));
			output.setMunicip(DomiData.getString("MUNICIP"));
			output.setTel(DomiData.getString("TEL"));
			output.setMail(DomiData.getString("MAIL"));
	
			returnList.add(output);
		} catch (AbapException e) {
			logger.error(" executing function " + "ZCRMCAP_E001_GETINFOFORCUB", e);
			throw e;
		}

		return (returnList);
	}

}
