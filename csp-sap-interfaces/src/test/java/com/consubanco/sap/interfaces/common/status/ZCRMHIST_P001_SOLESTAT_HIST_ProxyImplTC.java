package com.consubanco.sap.interfaces.common.status;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

public class ZCRMHIST_P001_SOLESTAT_HIST_ProxyImplTC extends TestCase {
	private static Log log = LogFactory.getLog( ZCRMHIST_P001_SOLESTAT_HIST_ProxyImplTC.class );
	
	
	public ZCRMHIST_P001_SOLESTAT_HIST_ProxyImplTC(String name) {
		super(name);
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMHIST_P001_SOLESTAT_HIST_ProxyImpl proxy = new ZCRMHIST_P001_SOLESTAT_HIST_ProxyImpl();
        ArrayList<String> arrSolic = new ArrayList<String>();
        /*arrSolic.add("0050609760");
        arrSolic.add("00506115195");*/

        arrSolic.add("0050623450");
        arrSolic.add("0050623648");
        arrSolic.add("0050623758");
        arrSolic.add("0050623758");
        arrSolic.add("0050623912");
        arrSolic.add("0050623963");
        arrSolic.add("0050624257");
        arrSolic.add("0050624462");
        arrSolic.add("0050624672");
        arrSolic.add("0050624695");
        arrSolic.add("0050624695");
        arrSolic.add("0050624701");
        arrSolic.add("0050624755");
        arrSolic.add("0050624813");
        arrSolic.add("0050624827");
        arrSolic.add("0050624962");
        arrSolic.add("0050624968");
        arrSolic.add("0050624974");
        arrSolic.add("0050624976");
        arrSolic.add("0050625004");
        arrSolic.add("0050625017");
        arrSolic.add("0050625026");
        arrSolic.add("0050625036");
        arrSolic.add("0050625041");
        arrSolic.add("0050625087");
        arrSolic.add("0050625093");
        arrSolic.add("0050625106");
        arrSolic.add("0050625140");
        arrSolic.add("0050625148");
        arrSolic.add("0050625165");
        arrSolic.add("0050625172");
        arrSolic.add("0050625195");
        arrSolic.add("0050625238");
        arrSolic.add("0050625301");
        arrSolic.add("0050625303");
        arrSolic.add("0050625330");

        
        
        for (String lasolic : arrSolic) {
        	ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        	ProxyInputParameter input = new ProxyInputParameter();
        	input.setKey("I_OBJECT");
        	input.setValue( lasolic );
        	inputParams.add( input );
        	System.out.println(lasolic+"\t"+  proxy.executeRemoteFunction(destination, inputParams ) );
        	
        }
	}


}
