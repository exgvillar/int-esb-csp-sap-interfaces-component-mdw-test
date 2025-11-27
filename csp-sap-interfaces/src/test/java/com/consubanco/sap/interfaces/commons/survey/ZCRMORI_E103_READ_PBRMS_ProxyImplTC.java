/**
 * 
 */
package com.consubanco.sap.interfaces.commons.survey;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.common.survey.ZCRMORI_E103_READ_PBRMS_ProxyImpl;
import com.consubanco.sap.interfaces.common.survey.models.ZTE_SURVEY_Model;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author haydee.sanchez
 *
 */
public class ZCRMORI_E103_READ_PBRMS_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMORI_E103_READ_PBRMS_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMORI_E103_READ_PBRMS_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMORI_E103_READ_PBRMS_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMORI_E103_READ_PBRMS_ProxyImpl proxy = new ZCRMORI_E103_READ_PBRMS_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_SOLICITUD");
        input.setValue( "0070000836" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_TIPDOC");
        input.setValue( "ZCAP" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_SURVEYID");
        input.setValue( "" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_BP");
        input.setValue( "0000578020" );
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("I_ONLYBRMS");
        input.setValue( "X" );
        inputParams.add( input );
        
        ZTE_SURVEY_Model survey = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( survey.toString() );
        
        
        
	}
}
