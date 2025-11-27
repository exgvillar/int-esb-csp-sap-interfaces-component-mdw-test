package com.consubanco.sap.interfaces.cxn.loans;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.cxn.loans.model.I_FILES_Model;
import com.consubanco.sap.interfaces.cxn.loans.model.I_LOANS_Model;
import com.consubanco.sap.interfaces.cxn.loans.model.ZCRMORI_P001_SAVEREQLETTER_Model;
import com.consupago.sap.interfaces.format.SAPFormatter;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoTable;

public class ZCRMORI_P001_SAVEREQLETTER_ProxyImpl {
	
	private static Log log = LogFactory.getLog(ZCRMORI_P001_SAVEREQLETTER_ProxyImpl.class);
	private final String rfc = "ZCRMORI_P001_SAVEREQLETTER";

	public List<IProxyOutputData> executeRemoteFunction(JCoDestination destination,
			ZCRMORI_P001_SAVEREQLETTER_Model inputParamsModel) throws Exception {
		
		ZCRMORI_P001_SAVEREQLETTER_OutputData outputData = new ZCRMORI_P001_SAVEREQLETTER_OutputData();
		List<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			ft = destination.getRepository().getFunctionTemplate( rfc );
			if( ft == null ) {
				throw new RuntimeException(rfc + " not found in SAP.");
			}
			
			function = ft.getFunction();
			
			if( inputParamsModel != null ) {
				function.getImportParameterList().setValue("I_TASKID", inputParamsModel.getTaskId());				
				function.getImportParameterList().setValue("I_CUSTOMERBP", inputParamsModel.getCustomerBp());
				function.getImportParameterList().setValue("I_PROMOTORBP", inputParamsModel.getPromotorBp());
				function.getImportParameterList().setValue("I_ENTERPRISEID", inputParamsModel.getEnterprise().getKey());
				function.getImportParameterList().setValue("I_DISTRIBUTORID", inputParamsModel.getDistributor().getKey());
				function.getImportParameterList().setValue("I_BRANCHID", inputParamsModel.getBranch().getKey());
				function.getImportParameterList().setValue("I_PRODUCTID", inputParamsModel.getProduct().getKey());
				function.getImportParameterList().setValue("I_REQUESTAMOUNT", inputParamsModel.getRequestAmount());
				function.getImportParameterList().setValue("I_TERM", inputParamsModel.getTerm());
				
				
				JCoTable tableLoan = function.getImportParameterList().getTable("I_LOANS");
				for(I_LOANS_Model loanModel: inputParamsModel.getLoans()){
					tableLoan.appendRow();
					tableLoan.setValue("I_ACCOUNTID", loanModel.getAccountId());					
					tableLoan.setValue("I_PORTFOLIOOWNER", loanModel.getPortfolioOwner());	
					tableLoan.setValue("I_FORMALIZATIONDATE", loanModel.getFormalizationDate());	
					tableLoan.setValue("I_ENTERPRISEORIGINATION", loanModel.getEnterpriseOrigination());	
					tableLoan.setValue("I_TOTALOFPAYMENTS", loanModel.getTotalOfPayments());	
					tableLoan.setValue("I_PAYMENTNUMBER", loanModel.getPaymentNumber());	
					tableLoan.setValue("I_FRECUENCY", loanModel.getFrecuency());	
					tableLoan.setValue("I_DISCOUNTAMOUNT", loanModel.getDiscountAmount());	
					tableLoan.setValue("I_LIQUIDAMOUNT", loanModel.getLiquidAmount());					
					tableLoan.setValue("I_INTERESTRATE", loanModel.getInterestRate());	
					tableLoan.setValue("I_CAT", loanModel.getCat());	
					tableLoan.setValue("I_PENSIONTYPE", loanModel.getPensionType());	
					tableLoan.setValue("I_FOLIORELEASELETTER", loanModel.getFolioReleaseLetter());	
				}
				log.info(tableLoan.toString());
				
				function.getImportParameterList().setValue("I_LCOM", inputParamsModel.getIsLcom().equals("true") ? "X" : "" );
				function.getImportParameterList().setValue("I_CNCA", inputParamsModel.getIsCnca().equals("true") ? "X" : "" );
				function.getImportParameterList().setValue("I_INTER", inputParamsModel.getIsInter().equals("true") ? "X" : "" );
				log.info(function.getImportParameterList().toString());
				JCoTable tableFile = function.getImportParameterList().getTable("I_FILES");
				for(I_FILES_Model fileModel: inputParamsModel.getFiles()){
					tableFile.appendRow();
					tableFile.setValue("I_FILENAME", fileModel.getFileName());	
					
					byte[] value = SAPFormatter.convertFileBinario( fileModel.getBase64());
					tableFile.setValue("I_BINARY", value);
				}
				log.info(tableFile.toString());
			}			
			
			function.execute(destination);
				
			String message = function.getExportParameterList().getString("E_MESSAGE");			
			String success = function.getExportParameterList().getString("E_SUCCESS");
			String taskId = function.getExportParameterList().getString("E_TASKID");
			
			log.info(function.getExportParameterList().toString());
									
			outputData.setMessage(message);
			outputData.setSuccess(success);
			outputData.setTaskId(taskId);
			returnList.add(outputData);
			
			log.info( "RFC :: " + rfc );
			log.info( "Return data ---> " + returnList.toString());
	
		} catch (AbapException e) {
			log.error(" executing function " + rfc);
			log.error(e);
			throw e;
		} 
		
		return (returnList);
	}
}
