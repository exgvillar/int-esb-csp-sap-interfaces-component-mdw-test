package com.consubanco.sap.interfaces.commons;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.consubanco.sap.interfaces.commons.model.GenericModel;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.IStandardSAPProxy;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.utils.TransactionLatency;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoTable;

public class ZCRMCSB_E002_BUSCABP_ProxyImpl implements IStandardSAPProxy {

	private static Log log = LogFactory.getLog(ZCRMCSB_E002_BUSCABP_ProxyImpl.class);

	public ZCRMCSB_E002_BUSCABP_ProxyImpl() {
		super();
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction(JCoDestination destination,
			ArrayList<ProxyInputParameter> inputParamtersList) throws Exception {

		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {

			ft = destination.getRepository().getFunctionTemplate("ZCRMCSB_E002_BUSCABP");
			if (ft == null)
				throw new RuntimeException("ZCRMCSB_E002_BUSCABP not found in SAP.");

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
			TransactionLatency latency = new TransactionLatency("ZCRMCSB_E002_BUSCABP");
			function.execute(destination);
			latency.finish();
			log.info("Function.Export: " + function.getExportParameterList().toString());

			JCoTable data = function.getExportParameterList().getTable("E_BUSPART");

			log.info("E_BUSPART::" + data.toString());
			for (int i = 0; i < data.getNumRows(); i++, data.nextRow()) {
				ZCRMCSB_E002_BUSCABP_OutputData tableData = new ZCRMCSB_E002_BUSCABP_OutputData();

				tableData.setBpId(data.getString("BP_ID"));
				tableData.setClientId(data.getString("CLIENTID"));
				tableData.setBpRolId(data.getString("ROLLID"));
				tableData.setGroupId(data.getString("GROUPID"));
				tableData.setRfc(data.getString("RFC"));
				tableData.setCurp(data.getString("CURP"));
				tableData.setName1(data.getString("NAME1"));
				tableData.setName2(data.getString("NAME2"));
				tableData.setLastname1(data.getString("LASTNAME1"));
				tableData.setLastname2(data.getString("LASTNAME2"));
				tableData.setNameCompany(data.getString("NAMECOMPANY"));
				tableData.setDateBirth(data.getDate("DATEBIRTH"));
				tableData.setPlaceBirth(data.getString("PLACEBIRTH"));

				if (StringUtils.isEmpty(data.getString("COUNTRYBIRTH")))
					tableData.setCountryBirthId("NOT_FOUND");
				else
					tableData.setCountryBirthId(data.getString("COUNTRYBIRTH"));

				if (StringUtils.isEmpty(data.getString("NATIONALITY")))
					tableData.setNationalityId("NOT_FOUND");
				else
					tableData.setNationalityId(data.getString("NATIONALITY"));
				tableData.setNationalityDesc(data.getString("DESCNATION"));

				if (StringUtils.isEmpty(data.getString("MARITALSTATUS")))
					tableData.setMaritalStatusId("NOT_FOUND");
				else
					tableData.setMaritalStatusId(data.getString("MARITALSTATUS"));
				tableData.setMaritalStatusDesc(data.getString("DESCMARITALST"));
				tableData.setEmail(data.getString("EMAIL"));
				tableData.setLegalEntity(data.getString("LEGALENTITY"));
				tableData.setGender(data.getString("GENDER"));// M Masculino/F
																// Femenino

				if (StringUtils.isEmpty(data.getString("LEVELSTUDIES")))
					tableData.setLevelStudiesId("NOT_FOUND");
				else
					tableData.setLevelStudiesId(data.getString("LEVELSTUDIES"));
				tableData.setLevelStudiesDesc(data.getString("DESCLEVESTUD"));

				tableData.setDateCreate(data.getDate("DATECREATE"));
				tableData.setFIEL(data.getString("FIEL"));
				tableData.setClient( "1".equalsIgnoreCase(data.getString("ES_CLIENTE")) ? true : false );
				tableData.setNumDependientesEconomicos(data.getString("DEP_ECONOMIC"));
				tableData.setEdadesDependientesEconomicos(data.getString("EDADES_HIJOS"));
				tableData.setNumHabitantesHogar(data.getString("HABIT_HOGAR"));
				tableData.setLocked(data.getString("BLOCK").equals("X") ? true : false);
				tableData.setResidenceCountry(data.getString("RESIDENCECOUNTRY"));
				tableData.setIdentificationType(data.getString("IDENTIFICATIONTYPE"));
				tableData.setIdentificationNumber(data.getString("IDENTIFICATIONNUMBER"));
				tableData.setAssignedCountryIdentificationNumber(data.getString("COUNTRY_ASSFISC"));
				tableData.setIdentificationType2(data.getString("IDENTIFICATIONTYPE2"));
				tableData.setIdentificationNumber2(data.getString("IDENTIFICATIONNUMBER2"));
				tableData.setIdRegimenFiscal(data.getString("IDREGIMENFISCAL"));
				tableData.setDescRegimenFiscal(data.getString("DESCREGIMENFISCAL"));				
				
				GenericModel customerType = new GenericModel();
				customerType.setKey(data.getString("ID_TIPOCLIENTE_CAV"));
				customerType.setDescription( data.getString("TIPOCLIENTECAV"));
				tableData.setCustomerType(customerType);
				
				tableData.setPromotorNFO(data.getString("NFO").equals("X") ? true : false);				
				tableData.setEmployeeNumber(data.getString("EMPLOYEE_NUMBER"));				

				returnList.add(tableData);
			}

		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMCSB_E002_BUSCABP", e);
			throw e;
		} finally {

		}

		return (returnList);
	}

}
