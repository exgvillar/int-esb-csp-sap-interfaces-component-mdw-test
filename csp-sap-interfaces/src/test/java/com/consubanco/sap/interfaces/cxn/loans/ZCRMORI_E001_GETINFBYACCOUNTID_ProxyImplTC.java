package com.consubanco.sap.interfaces.cxn.loans;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.cxn.loans.model.I_LOANDS_Model;
import com.consubanco.sap.interfaces.cxn.loans.model.ZCRMORI_E001_GETINFBYACCOUNTID_Model;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

import junit.framework.TestCase;

public class ZCRMORI_E001_GETINFBYACCOUNTID_ProxyImplTC extends TestCase {
	
	private static Log log = LogFactory.getLog(ZCRMORI_E001_GETINFBYACCOUNTID_ProxyImplTC.class);
		
	public ZCRMORI_E001_GETINFBYACCOUNTID_ProxyImplTC() {
		super();
	}

	public void testDestination() throws Exception {
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
		
        ZCRMORI_E001_GETINFBYACCOUNTID_ProxyImpl proxy = new ZCRMORI_E001_GETINFBYACCOUNTID_ProxyImpl();
        ZCRMORI_E001_GETINFBYACCOUNTID_Model inputParams = new ZCRMORI_E001_GETINFBYACCOUNTID_Model();
        
        inputParams.setCustomerBp("0004460289");
        
        List<I_LOANDS_Model> loans = new ArrayList<I_LOANDS_Model>();
        I_LOANDS_Model loan = new I_LOANDS_Model();
        loan.setAccountId("000007693528");
        loans.add(loan);
        
        inputParams.setLoans(loans);
		
        List<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( "Return data ---> " + returnData.toString() );
	}
}
