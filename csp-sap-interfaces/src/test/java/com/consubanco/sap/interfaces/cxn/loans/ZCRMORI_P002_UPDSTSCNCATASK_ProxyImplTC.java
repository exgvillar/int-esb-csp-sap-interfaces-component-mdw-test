package com.consubanco.sap.interfaces.cxn.loans;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.cxn.loans.model.GENERIC_CATALOG_Model;
import com.consubanco.sap.interfaces.cxn.loans.model.ZCRMORI_P002_UPDSTSCNCATASK_Model;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

import junit.framework.TestCase;

public class ZCRMORI_P002_UPDSTSCNCATASK_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMORI_P002_UPDSTSCNCATASK_ProxyImplTC.class ); 
	
	public void testDestination() throws Exception {
		
		CRMLocalConfigEnvironmentData.instance();
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
		
		ZCRMORI_P002_UPDSTSCNCATASK_ProxyImpl proxy = new ZCRMORI_P002_UPDSTSCNCATASK_ProxyImpl();
		ZCRMORI_P002_UPDSTSCNCATASK_Model inputParams = new ZCRMORI_P002_UPDSTSCNCATASK_Model();

		inputParams.setTaskId("2400000022");
		
		GENERIC_CATALOG_Model status = new GENERIC_CATALOG_Model();
		status.setKey("E0002");
		status.setDescription("");	
		inputParams.setStatus(status);
		
		inputParams.setComments("NOTA DE TEXTO 1");
					
		List<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams);
		log.info( "Return data ---> " + returnData.toString() );
	}
}
