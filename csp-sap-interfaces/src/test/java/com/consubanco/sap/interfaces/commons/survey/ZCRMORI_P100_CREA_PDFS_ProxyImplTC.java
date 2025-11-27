/**
 * 
 */
package com.consubanco.sap.interfaces.commons.survey;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.common.survey.ZCRMORI_P100_CREA_PDFS_ProxyImpl;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author haydee.sanchez
 *
 */
public class ZCRMORI_P100_CREA_PDFS_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMORI_P100_CREA_PDFS_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMORI_P100_CREA_PDFS_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMORI_P100_CREA_PDFS_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMORI_P100_CREA_PDFS_ProxyImpl proxy = new ZCRMORI_P100_CREA_PDFS_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_SOLICITUD");
        input.setValue( "0070000063" );
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
        input.setValue( "0010002444" );
        inputParams.add( input );
        
        proxy.executeRemoteFunction(destination, inputParams );
        
        
        
	}
}
