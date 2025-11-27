/**
 * 
 */
package com.consubanco.sap.interfaces.commons.survey;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.common.survey.ZCRMORI_P102_GET_QUEST_ProxyImpl;
import com.consubanco.sap.interfaces.common.survey.models.ZTE_SURVEY_Model;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author haydee.sanchez
 *
 */
public class ZCRMORI_P102_GET_QUEST_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMORI_P102_GET_QUEST_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMORI_P102_GET_QUEST_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMORI_P102_GET_QUEST_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMORI_P102_GET_QUEST_ProxyImpl proxy = new ZCRMORI_P102_GET_QUEST_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_SURVEYID");
        input.setValue( "CUESTIONARIO CTC" );
        inputParams.add( input );
        
        ZTE_SURVEY_Model returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
