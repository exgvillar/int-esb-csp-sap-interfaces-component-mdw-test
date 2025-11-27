package com.consubanco.sap.interfaces.cxn.loans;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.cxn.loans.model.I_FILES_Model;
import com.consubanco.sap.interfaces.cxn.loans.model.ZCRMORI_P003_SAVECNCASIPRE_Model;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

import junit.framework.TestCase;

public class ZCRMORI_P003_SAVECNCASIPRE_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog(ZCRMORI_P003_SAVECNCASIPRE_ProxyImplTC.class);
	
	public ZCRMORI_P003_SAVECNCASIPRE_ProxyImplTC() {
		super();
	}

	public void test() throws Exception {
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
		
        ZCRMORI_P003_SAVECNCASIPRE_ProxyImpl proxy = new ZCRMORI_P003_SAVECNCASIPRE_ProxyImpl();
        ZCRMORI_P003_SAVECNCASIPRE_Model inputParams = new ZCRMORI_P003_SAVECNCASIPRE_Model();
        
        inputParams.setTaskId("2400000008");
        inputParams.setAccountId("000324939393");
        
        /*GENERIC_CATALOG_Model statusSipre = new GENERIC_CATALOG_Model();
        statusSipre.setKey("");
        statusSipre.setDescription("");*/
        
    	List<I_FILES_Model> fileEvidences = new ArrayList<I_FILES_Model>();
    	I_FILES_Model fileModel= new I_FILES_Model();
    	fileModel.setFileName("PRUEBA.TXT");
    	fileModel.setBase64("B0");
    	fileEvidences.add(fileModel);        
        inputParams.setFileEvidences(fileEvidences);
		
        List<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( "Return data ---> " + returnData.toString() );
	}
}
