package com.consubanco.sap.interfaces.cxn.loans;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.cxn.loans.model.GENERIC_CATALOG_Model;
import com.consubanco.sap.interfaces.cxn.loans.model.ZCRMORI_E003_GETCNCATASKBYSTS_Model;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

import junit.framework.TestCase;

public class ZCRMORI_E003_GETCNCATASKBYSTS_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog(ZCRMORI_E003_GETCNCATASKBYSTS_ProxyImplTC.class);
	
	public ZCRMORI_E003_GETCNCATASKBYSTS_ProxyImplTC() {
		super();
	}

	public void test() throws Exception {
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
		
        ZCRMORI_E003_GETCNCATASKBYSTS_ProxyImpl proxy = new ZCRMORI_E003_GETCNCATASKBYSTS_ProxyImpl();
        ZCRMORI_E003_GETCNCATASKBYSTS_Model inputParams = new ZCRMORI_E003_GETCNCATASKBYSTS_Model();
                       
    	List<GENERIC_CATALOG_Model> status = new ArrayList<GENERIC_CATALOG_Model>();
    	
    	GENERIC_CATALOG_Model statusModel = new GENERIC_CATALOG_Model();
    	statusModel.setKey("E0002");
    	statusModel.setDescription("Biométrico válido");
    	status.add(statusModel);
    	
    	statusModel = new GENERIC_CATALOG_Model();
    	statusModel.setKey("E0001");
    	statusModel.setDescription("En espera de biométrico");
    	status.add(statusModel);
    	    	
        inputParams.setStatus(status);
    	inputParams.setPromotorBp("0010004456");
    	
		
        List<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );       
        log.info( "Return data ---> " + returnData.toString() );
	}	
	
}
