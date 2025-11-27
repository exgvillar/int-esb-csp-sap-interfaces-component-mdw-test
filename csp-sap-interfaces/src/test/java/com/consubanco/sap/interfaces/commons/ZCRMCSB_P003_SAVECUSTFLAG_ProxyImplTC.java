/**
 * 
 */
package com.consubanco.sap.interfaces.commons;

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
 * @author Ing. Adrian Alejo - Tw @adrixmnt
 *
 */
public class ZCRMCSB_P003_SAVECUSTFLAG_ProxyImplTC extends TestCase {

	private static Log logger = LogFactory.getLog(ZCRMCSB_P003_SAVECUSTFLAG_ProxyImplTC.class);

	public void testSaveCustomFlag() throws Exception {

		CRMLocalConfigEnvironmentData.instance();

		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");

		ZCRMCSB_P003_SAVECUSTFLAG_ProxyImpl proxy = new ZCRMCSB_P003_SAVECUSTFLAG_ProxyImpl();

		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
		ProxyInputParameter input = new ProxyInputParameter();
		input.setKey("I_BP");
		input.setValue("0000543723");
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("I_FLAG");
		input.setValue("X");
		inputParams.add(input);

		ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams);

		logger.info(returnData.toString());
	}

}
