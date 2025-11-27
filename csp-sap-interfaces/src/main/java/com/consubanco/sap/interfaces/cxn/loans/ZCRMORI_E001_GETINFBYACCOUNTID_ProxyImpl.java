package com.consubanco.sap.interfaces.cxn.loans;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.cxn.loans.model.E_CUSTOMER_Model;
import com.consubanco.sap.interfaces.cxn.loans.model.E_LOANS_Model;
import com.consubanco.sap.interfaces.cxn.loans.model.I_LOANDS_Model;
import com.consubanco.sap.interfaces.cxn.loans.model.ZCRMORI_E001_GETINFBYACCOUNTID_Model;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoStructure;
import com.sap.conn.jco.JCoTable;

public class ZCRMORI_E001_GETINFBYACCOUNTID_ProxyImpl {

	private static Log log = LogFactory.getLog(ZCRMORI_E001_GETINFBYACCOUNTID_ProxyImpl.class);
	private final String rfc = "ZCRMORI_E001_GETINFBYACCOUNTID";

	public List<IProxyOutputData> executeRemoteFunction(JCoDestination destination,
			ZCRMORI_E001_GETINFBYACCOUNTID_Model inputParamsModel) throws Exception {
		
		ZCRMORI_E001_GETINFBYACCOUNTID_OutputData outputData = new ZCRMORI_E001_GETINFBYACCOUNTID_OutputData();
		List<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		List<E_LOANS_Model> loans = new ArrayList<E_LOANS_Model>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			ft = destination.getRepository().getFunctionTemplate( rfc );
			if( ft == null ) {
				throw new RuntimeException(rfc + " not found in SAP.");
			}
			
			function = ft.getFunction();
			
			if( inputParamsModel != null ) {
				function.getImportParameterList().setValue("I_CUSTOMERBP", inputParamsModel.getCustomerBp());
				log.info(function.getImportParameterList().toString());
				
				JCoTable tableLoan = function.getImportParameterList().getTable("I_LOANDS");
				for(I_LOANDS_Model loanModel: inputParamsModel.getLoans()){
					tableLoan.appendRow();
					tableLoan.setValue("I_ACCOUNTID", loanModel.getAccountId());					
				}
				log.info(tableLoan.toString());
			}			
			
			function.execute(destination);			
			
			String message = function.getExportParameterList().getString("E_MESSAGE");			
			String success = function.getExportParameterList().getString("E_SUCCESS");
			log.info(function.getExportParameterList().toString());
			
			JCoStructure outCustomer = function.getExportParameterList().getStructure("E_CUSTOMER");
			log.info(outCustomer.toString());
			E_CUSTOMER_Model customer = new E_CUSTOMER_Model();
			customer.setGender(outCustomer.getString("E_GENDER"));
			customer.setBirthday(outCustomer.getDate("E_BIRTHDAY"));
						
			JCoTable outTableLoan = function.getExportParameterList().getTable("E_LOANS");	
			log.info(outTableLoan.toString());
						
			for (int i = 0; i < outTableLoan.getNumRows(); i++, outTableLoan.nextRow()) {
				E_LOANS_Model loan = new E_LOANS_Model();
				loan.setAccountId(outTableLoan.getString("E_ACCOUNTID"));
				loan.setFolioApplication(outTableLoan.getString("E_FOLIOAPPLICATION"));
				loan.setFolioCartaLibranza(outTableLoan.getString("E_FOLIOCARTALIBRANZA"));
				loan.setTipoPension(outTableLoan.getString("E_PENSIONTYPE"));
				loans.add(loan);
			}
			
			outputData.setMessage(message);
			outputData.setSuccess(success);
			outputData.setCustomer(customer);
			outputData.setLoans(loans);
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
