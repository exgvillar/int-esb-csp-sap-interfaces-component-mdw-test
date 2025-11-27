package com.consubanco.sap.interfaces.ine;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.consubanco.sap.interfaces.ine.model.ZMValidINERequest;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;

import junit.framework.TestCase;

public class ZCRMBIO_E006_VALIDATEINE_ProxyImplTC extends TestCase{

	private static Log log = LogFactory.getLog( ZCRMBIO_E006_VALIDATEINE_ProxyImplTC.class );
	private JCoDestination destination;
	@Override
	protected void setUp() throws Exception {
		CRMLocalConfigEnvironmentData.instance();        
		destination = JCoDestinationManager.getDestination("CSPSAPCRM");
		super.setUp();
	}
	
	@Override
	protected void tearDown() throws Exception {
		destination = null;
		super.tearDown();
	}
	
	public void testSuccess() {
		ZMValidINERequest request = new ZMValidINERequest();
		request.setCustomerBp("1149");
		executeOperation(request, "testSuccess");
	}
	
	
	private void executeOperation(ZMValidINERequest request, String message){     
        JCoDestination destination;
		try {
			destination = JCoDestinationManager.getDestination("CSPSAPCRM");
			ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
			ProxyInputParameter input = new ProxyInputParameter();
			input.setKey("I_CUSTOMERBP");
			input.setValue("0000001144");
			inputParams.add(input);

			ZCRMBIO_E006_VALIDATEINE_ProxyImpl proxy = new ZCRMBIO_E006_VALIDATEINE_ProxyImpl();
	        ArrayList<IProxyOutputData> outputDataList = proxy.executeRemoteFunction(destination, inputParams );
       
	        ZCRMBIO_E006_VALIDATEINE_OutputData outputData = (ZCRMBIO_E006_VALIDATEINE_OutputData) outputDataList.get(0);
			log.info("Result Data :: " + outputData.toString());

		} catch (JCoException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
