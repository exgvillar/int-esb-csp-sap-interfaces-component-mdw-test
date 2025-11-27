package com.consubanco.sap.interfaces.cxn.loans;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.cxn.loans.model.ZCRMORI_E002_GETCNCATASK_Model;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

import junit.framework.TestCase;

public class ZCRMORI_E002_GETCNCATASK_ProxyImplTC extends TestCase {
	
private static Log log = LogFactory.getLog(ZCRMORI_E002_GETCNCATASK_ProxyImplTC.class);
	
	public ZCRMORI_E002_GETCNCATASK_ProxyImplTC() {
		super();
	}

	public void test() throws Exception {
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
		
        ZCRMORI_E002_GETCNCATASK_ProxyImpl proxy = new ZCRMORI_E002_GETCNCATASK_ProxyImpl();
        ZCRMORI_E002_GETCNCATASK_Model inputParams = new ZCRMORI_E002_GETCNCATASK_Model();
        
        inputParams.setTaskId("2400000025");
        inputParams.setFindFiles(false);
  		
        List<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( "Return data ---> " + returnData.toString() );
	}

}
