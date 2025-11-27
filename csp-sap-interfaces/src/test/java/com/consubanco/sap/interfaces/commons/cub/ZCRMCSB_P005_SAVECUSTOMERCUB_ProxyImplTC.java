/**
 * 
 */
package com.consubanco.sap.interfaces.commons.cub;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

import junit.framework.TestCase;

/**
 * @author estefania.montoya
 *
 */
public class ZCRMCSB_P005_SAVECUSTOMERCUB_ProxyImplTC extends TestCase {
	private static Log logger = LogFactory.getLog(ZCRMCSB_P005_SAVECUSTOMERCUB_ProxyImplTC.class);
	
	public void testSaveCustomCub() throws Exception {

		CRMLocalConfigEnvironmentData.instance();

		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");

		ZCRMCSB_P005_SAVECUSTOMERCUB_ProxyImpl proxy = new ZCRMCSB_P005_SAVECUSTOMERCUB_ProxyImpl();

		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
		ProxyInputParameter input = new ProxyInputParameter();
		input.setKey("I_BP");
		input.setValue("1149");
		inputParams.add(input);
	
		input = new ProxyInputParameter();
		input.setKey("I_OPERATIOTYPE");
		input.setValue("ZCSP");
		inputParams.add(input);
	
		input = new ProxyInputParameter();
		input.setKey("I_SOURCE");
		input.setValue("PUC");
		inputParams.add(input);
	
		input = new ProxyInputParameter();
		input.setKey("I_FOLIOAPP");
		input.setValue("0050384743");
		inputParams.add(input);
		
		
		ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams);

		logger.info(returnData.toString());
	}
}
