package com.consubanco.sap.interfaces.cxn.loans;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.cxn.loans.model.GENERIC_CATALOG_Model;
import com.consubanco.sap.interfaces.cxn.loans.model.I_FILES_Model;
import com.consubanco.sap.interfaces.cxn.loans.model.I_LOANS_Model;
import com.consubanco.sap.interfaces.cxn.loans.model.PRODUCT_CATALOG_Model;
import com.consubanco.sap.interfaces.cxn.loans.model.ZCRMORI_E004_GETACCOUNT_Model;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoStructure;
import com.sap.conn.jco.JCoTable;

public class ZCRMORI_E004_GETACCOUNT_ProxyImpl {

	private static Log log = LogFactory.getLog(ZCRMORI_E004_GETACCOUNT_ProxyImpl.class);
	private static String RFC = "ZCRMORI_E004_GETACCOUNT";
	
	public List<IProxyOutputData> executeRemoteFunction(JCoDestination destination,
			ZCRMORI_E004_GETACCOUNT_Model inputParamsModel) throws Exception {
		
		ZCRMORI_E004_GETACCOUNT_OutputData outputData = new ZCRMORI_E004_GETACCOUNT_OutputData();
		List<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		List<I_FILES_Model> files = new ArrayList<I_FILES_Model>();
		List<I_LOANS_Model> loans = new ArrayList<I_LOANS_Model>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			ft = destination.getRepository().getFunctionTemplate( RFC );
			if( ft == null ) {
				throw new RuntimeException(RFC + " not found in SAP.");
			}
			
			function = ft.getFunction();
			
			if( inputParamsModel != null ) {
				function.getImportParameterList().setValue("I_ACCOUNT", inputParamsModel.getAccount());
				function.getImportParameterList().setValue("I_FOLIORELEASELETTER", inputParamsModel.getFolioReleaseLetter());
				function.getImportParameterList().setValue("I_TASKID", inputParamsModel.getTaskId());				
				function.getImportParameterList().setValue("I_FINDFILES", "");
				
				if(inputParamsModel.isFindFiles()) {
					function.getImportParameterList().setValue("I_FINDFILES", "X");
				}
				log.info(function.getImportParameterList().toString());

			}			
			
			function.execute(destination);
			
			log.info(function.getExportParameterList().toString());
			
			String message = function.getExportParameterList().getString("E_MESSAGE");			
			String success = function.getExportParameterList().getString("E_SUCCESS");
			
			JCoStructure outTask = function.getExportParameterList().getStructure("E_TASK");
			log.info(outTask.toString());
			outputData.setTaskId(outTask.getString("E_TASKID"));
			outputData.setCustomerBp(outTask.getString("E_CUSTOMERBP"));
			outputData.setNss(outTask.getString("E_NSS"));
			outputData.setPromotorBp(outTask.getString("E_PROMOTOR"));				
			
			GENERIC_CATALOG_Model enterprise = new GENERIC_CATALOG_Model();
			enterprise.setKey(outTask.getString("E_ENTERPRISEID"));
			enterprise.setDescription(outTask.getString("E_ENTERPRISEDESC"));
			outputData.setEnterprise(enterprise);
			
			GENERIC_CATALOG_Model distributor = new GENERIC_CATALOG_Model();
			distributor.setKey(outTask.getString("E_DISTRIBUTORID"));
			distributor.setDescription(outTask.getString("E_DISTRIBUTORDESC"));
			outputData.setDistributor(distributor);
			
			GENERIC_CATALOG_Model branch = new GENERIC_CATALOG_Model();
			branch.setKey(outTask.getString("E_BRANCHID"));
			branch.setDescription(outTask.getString("E_BRANCHDESC"));
			outputData.setBranch(branch);
			
			PRODUCT_CATALOG_Model product = new PRODUCT_CATALOG_Model();
			product.setId(outTask.getString("E_PRODUCTID"));
			product.setDescription(outTask.getString("E_PRODUCTDESC"));
			product.setCategory(outTask.getString("E_PRODUCTCATEGORY"));
			outputData.setProduct(product);
			
			outputData.setRequestAmount(outTask.getDouble("E_REQUESTAMOUNT"));
			outputData.setTerm(outTask.getInt("E_TERM"));			
			
			JCoTable outTableLoan = outTask.getTable("E_LOANS");	
			log.info(outTableLoan.toString());
			
			for (int i = 0; i < outTableLoan.getNumRows(); i++, outTableLoan.nextRow()) {
				I_LOANS_Model loan = new I_LOANS_Model();
				loan.setAccountId(outTableLoan.getString("E_ACCOUNTID"));
			
				GENERIC_CATALOG_Model status = new GENERIC_CATALOG_Model();
				status.setKey(outTableLoan.getString("E_STATUSSIPREID"));
				status.setDescription(outTableLoan.getString("E_STATUSDESC"));
				loan.setStatus(status);
				
				loan.setPortfolioOwner(outTableLoan.getString("E_PORTFOLIOOWNER"));				
				loan.setFormalizationDate(outTableLoan.getDate("E_FORMALIZATIONDATE"));
				loan.setEnterpriseOrigination(outTableLoan.getString("E_ENTERPRISEORIGINATION"));
				loan.setTotalOfPayments(outTableLoan.getInt("E_TOTALOFPAYMENTS"));
				loan.setPaymentNumber(outTableLoan.getInt("E_PAYMENTNUMBER"));				
				loan.setFrecuency(outTableLoan.getString("E_FRECUENCY"));
				loan.setDiscountAmount(outTableLoan.getDouble("E_DISCOUNTAMOUNT"));				
				loan.setLiquidAmount(outTableLoan.getDouble("E_LIQUIDAMOUNT"));
				loan.setInterestRate(outTableLoan.getDouble("E_INTERESTRATE"));
				loan.setCat(outTableLoan.getDouble("E_CAT"));				
				loan.setPensionType(outTableLoan.getString("E_PENSIONTYPE"));
				loan.setFolioReleaseLetter(outTableLoan.getString("E_FOLIORELEASELETTER"));
				loans.add(loan);
			}
			outputData.setLoans(loans);
						
			JCoTable outTableFile = outTask.getTable("E_FILES");
			log.info(outTableFile.toString());
						
			for (int i = 0; i < outTableFile.getNumRows(); i++, outTableFile.nextRow()) {
				I_FILES_Model file = new I_FILES_Model();
				file.setFileName(outTableFile.getString("I_FILENAME"));
				file.setBase64(outTableFile.getString("I_BINARY"));
				files.add(file);
			}
			
			outputData.setFiles(files);										
			outputData.setMessage(message);
			outputData.setSuccess(success);
			returnList.add(outputData);
			
			log.info( "RFC :: " + RFC );
			log.info( "Return data ---> " + returnList.toString());
	
		} catch (AbapException e) {
			log.error(" executing function " + RFC);
			log.error(e);
			throw e;
		} 
		
		return (returnList);
	}

}
