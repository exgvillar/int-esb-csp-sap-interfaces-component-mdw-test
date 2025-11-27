package com.consubanco.sap.interfaces.ine;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.ine.model.ZMFile;
import com.consubanco.sap.interfaces.ine.model.ZMInfoINE;
import com.consubanco.sap.interfaces.ine.model.ZMGetInfoINERequest;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;

import junit.framework.TestCase;

public class ZCRMBIO_E007_GETINFOINE_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog(ZCRMBIO_E007_GETINFOINE_ProxyImplTC.class);

	public void testSuccess() throws Exception  {
		CRMLocalConfigEnvironmentData.instance();

		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");

		ZCRMBIO_E007_GETINFOINE_ProxyImpl proxy = new ZCRMBIO_E007_GETINFOINE_ProxyImpl();
		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
		ProxyInputParameter input = new ProxyInputParameter();
		input.setKey("I_CUSTOMERBP");
		input.setValue("0000001192");
		inputParams.add(input);

		ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams);
		ZCRMBIO_E007_GETINFOINE_OutputData outputData = (ZCRMBIO_E007_GETINFOINE_OutputData) returnData.get(0);

		log.info("Result Data :: " + outputData.toString());

	}

}
