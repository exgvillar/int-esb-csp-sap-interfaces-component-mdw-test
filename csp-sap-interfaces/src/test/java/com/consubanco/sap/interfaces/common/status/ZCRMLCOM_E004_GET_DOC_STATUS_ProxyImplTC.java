package com.consubanco.sap.interfaces.common.status;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

public class ZCRMLCOM_E004_GET_DOC_STATUS_ProxyImplTC extends TestCase {
	private static Log log = LogFactory.getLog( ZCRMLCOM_E004_GET_DOC_STATUS_ProxyImplTC.class );
	
	
	public ZCRMLCOM_E004_GET_DOC_STATUS_ProxyImplTC(String name) {
		super(name);
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMLCOM_E004_GET_DOC_STATUS_ProxyImpl proxy = new ZCRMLCOM_E004_GET_DOC_STATUS_ProxyImpl();
        ArrayList<String> arrSolic = new ArrayList<String>();
        arrSolic.add("0200075778");
        arrSolic.add("0200075809");
        arrSolic.add("0200075828");
        arrSolic.add("0200075827");
        arrSolic.add("0200075849");
        arrSolic.add("0200075856");
        arrSolic.add("0200075908");
        arrSolic.add("0200075933");
        arrSolic.add("0200075957");
        arrSolic.add("0200075991");
        arrSolic.add("0200075962");
        arrSolic.add("0200075963");
        arrSolic.add("0200075979");
        arrSolic.add("0200075984");
        arrSolic.add("0200075992");
        arrSolic.add("0200076010");
        arrSolic.add("0200076012");
        arrSolic.add("0200076014");
        arrSolic.add("0200076015");
        arrSolic.add("0200076021");
        arrSolic.add("0200076024");
        arrSolic.add("0200076025");
        arrSolic.add("0200076027");
        arrSolic.add("0200076029");
        arrSolic.add("0200076034");
        arrSolic.add("0200076035");
        arrSolic.add("0200076038");
        arrSolic.add("0200076045");
        arrSolic.add("0200076046");
        arrSolic.add("0200076049");
        arrSolic.add("0200076052");
        arrSolic.add("0200076053");
        arrSolic.add("0200076065");
        arrSolic.add("0200076071");
        arrSolic.add("0200076072");
        arrSolic.add("0200076075");

        for (String lasolic : arrSolic) {
        	ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        	ProxyInputParameter input = new ProxyInputParameter();
        	input.setKey("I_NUMDOC");
        	input.setValue( lasolic );
        	inputParams.add( input );

        	input = new ProxyInputParameter();
        	input.setKey("I_TIPDOC");
//        	input.setValue( "ZCSP" );
        	input.setValue( "ZCOM" );
        	
        	inputParams.add( input );

        	ZCRMLCOM_E004_GET_DOC_STATUS_OutputData dataOut = proxy.executeRemoteFunction(destination, inputParams );
        	System.out.println(lasolic + "\t" + dataOut.getDescrip() );
        	
        }
	}


}
