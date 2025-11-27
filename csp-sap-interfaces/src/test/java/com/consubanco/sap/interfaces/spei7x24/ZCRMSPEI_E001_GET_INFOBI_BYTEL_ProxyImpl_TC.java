/**
 * 
 */
package com.consubanco.sap.interfaces.spei7x24;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.spei7x24.ZCRMSPEI_E001_GET_INFOBI_BYTEL_ProxyImpl;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * 
 * @author <a href="mailto:juribe@consubanco.com">juribe</a>
 * 
 */
public class ZCRMSPEI_E001_GET_INFOBI_BYTEL_ProxyImpl_TC extends TestCase {

	private static Log log = LogFactory.getLog(ZCRMSPEI_E001_GET_INFOBI_BYTEL_ProxyImpl_TC.class);

	/**
	 * 
	 */
	public ZCRMSPEI_E001_GET_INFOBI_BYTEL_ProxyImpl_TC() {
		super();
	}

	/**
	 * @param name
	 */
	public ZCRMSPEI_E001_GET_INFOBI_BYTEL_ProxyImpl_TC(String name) {
		super(name);
	}

	public void testDestination() throws Exception {

		CRMLocalConfigEnvironmentData.instance();

		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");

		ZCRMSPEI_E001_GET_INFOBI_BYTEL_ProxyImpl proxy = new ZCRMSPEI_E001_GET_INFOBI_BYTEL_ProxyImpl();

		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
		ProxyInputParameter input = new ProxyInputParameter();
		input.setKey("I_NUMTEL");
		input.setValue("1111111111");
		inputParams.add(input);

		ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams);

		log.info(returnData.toString());

	}

}
