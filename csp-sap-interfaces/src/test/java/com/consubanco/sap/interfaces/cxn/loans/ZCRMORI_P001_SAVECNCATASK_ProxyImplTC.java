package com.consubanco.sap.interfaces.cxn.loans;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.cxn.loans.model.GENERIC_CATALOG_Model;
import com.consubanco.sap.interfaces.cxn.loans.model.I_FILES_Model;
import com.consubanco.sap.interfaces.cxn.loans.model.I_LOANS_Model;
import com.consubanco.sap.interfaces.cxn.loans.model.ZCRMORI_P001_SAVECNCATASK_Model;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

import junit.framework.TestCase;

public class ZCRMORI_P001_SAVECNCATASK_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog(ZCRMORI_P001_SAVECNCATASK_ProxyImplTC.class);
	
	public ZCRMORI_P001_SAVECNCATASK_ProxyImplTC() {
		super();
	}

	public void test() throws Exception {
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
		
        ZCRMORI_P001_SAVECNCATASK_ProxyImpl proxy = new ZCRMORI_P001_SAVECNCATASK_ProxyImpl();
        ZCRMORI_P001_SAVECNCATASK_Model inputParams = new ZCRMORI_P001_SAVECNCATASK_Model();
        
        inputParams.setTaskId("");
        inputParams.setCustomerBp("1143");
        inputParams.setPromotorBp("10002446");
		
        GENERIC_CATALOG_Model enterprise = new GENERIC_CATALOG_Model();
		enterprise.setKey("50000004");
		enterprise.setDescription("");		
		inputParams.setEnterprise(enterprise);
		
		GENERIC_CATALOG_Model distributor = new GENERIC_CATALOG_Model();
		distributor.setKey("50000033");
		distributor.setDescription("");		
		inputParams.setDistributor(distributor);
		
		GENERIC_CATALOG_Model branch = new GENERIC_CATALOG_Model();
		branch.setKey("50000036");
		branch.setDescription("");		
		inputParams.setBranch(branch);
		
		GENERIC_CATALOG_Model product = new GENERIC_CATALOG_Model();
		product.setKey("1542");
		product.setDescription("");		
		inputParams.setProduct(product);
		
		inputParams.setRequestAmount(50000.00);
		inputParams.setTerm(15);
		
		List<I_LOANS_Model> loans = new ArrayList<I_LOANS_Model>();
		I_LOANS_Model loansModel = new I_LOANS_Model();
		loansModel.setAccountId("324939393");
		
		loansModel.setPortfolioOwner("28374");
		loansModel.setFormalizationDate(new SimpleDateFormat("dd-MM-yyyy").parse("30-05-2024"));
		loansModel.setEnterpriseOrigination("53400999");
		loansModel.setTotalOfPayments(12);
		loansModel.setPaymentNumber(12);
		loansModel.setFrecuency("MENSUAL");
		loansModel.setDiscountAmount(334.00);
		loansModel.setLiquidAmount(222.00);
		loansModel.setInterestRate(300.00);
		loansModel.setCat(10.00);
		loansModel.setPensionType("NUEVO");
		loansModel.setFolioReleaseLetter("NUEVO");
		loans.add(loansModel);		
		inputParams.setLoans(loans);
		
		List<I_FILES_Model> files = new ArrayList<I_FILES_Model>();
		I_FILES_Model fileModel = new I_FILES_Model();
		fileModel.setFileName("PRUEBA.TXT");
		fileModel.setBase64("B0");
		files.add(fileModel);
		inputParams.setFiles(files);
		
		inputParams.setSolicitudId("0056348982");
		
        List<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( "Return data ---> " + returnData.toString() );
	}
}
