/**
 * 
 */
package com.consubanco.sap.interfaces.bpm.externalPortal;

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
 * @author consubanco
 *
 */
public class ZCRMORI_E053_GETPORTBYACCOUNT_ProxyImpl_TC extends TestCase {

	
	private static Log log = LogFactory.getLog(ZCRMORI_E053_GETPORTBYACCOUNT_ProxyImpl.class);

	/**
	 * 
	 */
	public ZCRMORI_E053_GETPORTBYACCOUNT_ProxyImpl_TC() {
		super();
	}

	/**
	 * @param name
	 */
	public ZCRMORI_E053_GETPORTBYACCOUNT_ProxyImpl_TC(String name) {
		super(name);
	}

	public void testDestination() throws Exception {

		CRMLocalConfigEnvironmentData.instance();

		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");

		ZCRMORI_E053_GETPORTBYACCOUNT_ProxyImpl proxy = new ZCRMORI_E053_GETPORTBYACCOUNT_ProxyImpl();

		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
		ProxyInputParameter input = null;
		
		input = new ProxyInputParameter();
		input.setKey("I_ACCOUNTID");
		input.setValue("34567890");
		inputParams.add(input);
		
		input = new ProxyInputParameter();
		input.setKey("I_ACCOUNTID");
		input.setValue("123918739812");
		inputParams.add(input);
		
		ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams);

		log.info(returnData.toString());

	}
}
