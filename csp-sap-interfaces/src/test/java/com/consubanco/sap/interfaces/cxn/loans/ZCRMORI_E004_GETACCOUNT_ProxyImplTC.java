package com.consubanco.sap.interfaces.cxn.loans;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.cxn.loans.model.ZCRMORI_E004_GETACCOUNT_Model;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

import junit.framework.TestCase;

public class ZCRMORI_E004_GETACCOUNT_ProxyImplTC extends TestCase {
	
	private static Log log = LogFactory.getLog(ZCRMORI_E004_GETACCOUNT_ProxyImplTC.class);
	
	public ZCRMORI_E004_GETACCOUNT_ProxyImplTC() {
		super();
	}

	public void test() throws Exception {
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
		
        ZCRMORI_E004_GETACCOUNT_ProxyImpl proxy = new ZCRMORI_E004_GETACCOUNT_ProxyImpl();
        ZCRMORI_E004_GETACCOUNT_Model inputParams = new ZCRMORI_E004_GETACCOUNT_Model();
        
        inputParams.setFolioReleaseLetter("FOL123456789");
        inputParams.setFindFiles(true);
  		
        List<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( "Return data ---> " + returnData.toString() );
	}

}
