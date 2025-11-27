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
public class ZCRMCAP_E001_GETINFOFORCUB_ProxyImplTC extends TestCase {
	private static Log logger = LogFactory.getLog(ZCRMCAP_E001_GETINFOFORCUB_ProxyImplTC.class);
	
	public void testGetCustomerSurvey() throws Exception {

		CRMLocalConfigEnvironmentData.instance();

		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");

		ZCRMCAP_E001_GETINFOFORCUB_ProxyImpl proxy = new ZCRMCAP_E001_GETINFOFORCUB_ProxyImpl();

		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
		ProxyInputParameter input = new ProxyInputParameter();
		input.setKey("I_BIOTASKID");
		input.setValue("1740023900");
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("I_CUSTOMERBP");
		input.setValue("0002612817");
		inputParams.add(input);
	
		ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams);

		logger.info(returnData.toString());
	}
}
