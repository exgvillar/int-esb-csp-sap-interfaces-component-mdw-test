package com.consubanco.sap.interfaces.commons.sipre;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.ProxyInputParameterWithTable;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

import junit.framework.TestCase;

public class ZCRMADS_P001_TASKSIPRE_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog(ZCRMADS_P001_TASKSIPRE_ProxyImplTC.class);

	public ZCRMADS_P001_TASKSIPRE_ProxyImplTC() {
		super();
	}
	
	public void testDestination() throws Exception {
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMADS_P001_TASKSIPRE_ProxyImpl proxy = new ZCRMADS_P001_TASKSIPRE_ProxyImpl();
        
        ProxyInputParameterWithTable inputParams = new ProxyInputParameterWithTable();
        inputParams.setGeneralParam( new ArrayList<ProxyInputParameter>() );
        inputParams.setRecordParam( new ArrayList<Object>() );
        
        ProxyInputParameter input = new ProxyInputParameter();
        //input.setKey("I_PROMOTOR");
        input.setKey("I_AUXILIAR");
        input.setValue( "0010001934" );
        inputParams.getGeneralParam().add( input );
        input = new ProxyInputParameter();
        input.setKey("I_CLIENT");
        input.setValue( "0000001198" );
        inputParams.getGeneralParam().add( input );
        input = new ProxyInputParameter();
        input.setKey("I_DESCRIPTION");
        input.setValue( "TAREA SIPRE" );
        inputParams.getGeneralParam().add( input );   
        input = new ProxyInputParameter();
        input.setKey("I_FOLIO_BIO");
        input.setValue( "6715524331587" );
        inputParams.getGeneralParam().add( input );
        input = new ProxyInputParameter();
        input.setKey("I_ID_BRANCH");
        input.setValue( "0050000416" );
        inputParams.getGeneralParam().add( input );
        input = new ProxyInputParameter();
        input.setKey("I_NSS");
        input.setValue( "4589632584" );
        inputParams.getGeneralParam().add( input );
        input = new ProxyInputParameter();
        input.setKey("I_EMAIL");
        input.setValue( "MATUJIUI@GMAIL.COM" );
        inputParams.getGeneralParam().add( input );
        input = new ProxyInputParameter();
        input.setKey("I_TELEPHONE");
        input.setValue( "7896521485" );
        inputParams.getGeneralParam().add( input );

		List<ProxyInputParameter> inputDocs = new ArrayList<ProxyInputParameter>();
		ProxyInputParameter inputDoc = new ProxyInputParameter();
		inputDoc.setKey("FILENAME"); 
		inputDoc.setValue( "TEST.XLS" );
		inputDocs.add( inputDoc );
		inputDoc = new ProxyInputParameter();
		inputDoc.setKey("BIN"); 
		inputDoc.setValue( "70702E786D6C504B01022D001400060008000000210" );
		inputDocs.add( inputDoc );
		
		inputParams.getRecordParam().add( inputDocs );
        
        List<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( "Return data ---> " + returnData.toString() );
	}
		
}
