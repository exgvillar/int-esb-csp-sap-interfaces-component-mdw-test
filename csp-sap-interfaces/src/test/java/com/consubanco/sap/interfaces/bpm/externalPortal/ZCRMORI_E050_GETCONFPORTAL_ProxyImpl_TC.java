/**
 * 
 */
package com.consubanco.sap.interfaces.bpm.externalPortal;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author jruribes
 *
 */
public class ZCRMORI_E050_GETCONFPORTAL_ProxyImpl_TC extends TestCase {

	
	private static Log log = LogFactory.getLog(ZCRMORI_E050_GETCONFPORTAL_ProxyImpl_TC.class);

	/**
	 * 
	 */
	public ZCRMORI_E050_GETCONFPORTAL_ProxyImpl_TC() {
		super();
	}

	/**
	 * @param name
	 */
	public ZCRMORI_E050_GETCONFPORTAL_ProxyImpl_TC(String name) {
		super(name);
	}

	public void testDestination() throws Exception {

		CRMLocalConfigEnvironmentData.instance();

		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");

		ZCRMORI_E050_GETCONFPORTAL_ProxyImpl proxy = new ZCRMORI_E050_GETCONFPORTAL_ProxyImpl();

		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
		ProxyInputParameter input = null;
		
		input = new ProxyInputParameter();
		input.setKey("I_SIGLAEMPRESA");
		input.setValue("271");
		inputParams.add(input);
		
		input = new ProxyInputParameter();
		input.setKey("I_CONVENIOID");
		input.setValue("10000030");
		inputParams.add(input);
		
		input = new ProxyInputParameter();
		input.setKey("I_SOLICITUD");
		input.setValue("50389182");
		inputParams.add(input);

		ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams);

		log.info(returnData.toString());

	}
}
