package com.consubanco.sap.interfaces.commons.survey;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.common.survey.ZCRMORI_E103_READ_PBRMS1_ProxyImpl;
import com.consubanco.sap.interfaces.common.survey.models.ZTE_SURVEY_Model;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

import junit.framework.TestCase;

public class ZCRMORI_E103_READ_PBRMS1_ProxyImplTC extends TestCase{

	private static Log log = LogFactory.getLog( ZCRMORI_E103_READ_PBRMS1_ProxyImplTC.class );
	
	/**
	 * @param name
	 */
	public ZCRMORI_E103_READ_PBRMS1_ProxyImplTC(String name) {
		super(name);
	}
	
	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMORI_E103_READ_PBRMS1_ProxyImpl proxy = new ZCRMORI_E103_READ_PBRMS1_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input = new ProxyInputParameter();
        input.setKey("I_SURVEYID");
        input.setValue( "CUESTIONARIO PERSONA VULNERABLE" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_BP");
        input.setValue( "0000001144" );
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("I_ONLYBRMS");
        input.setValue( "" );
        inputParams.add( input );
        
        ZTE_SURVEY_Model survey = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( survey.toString() );
        
        
        
	}
}
