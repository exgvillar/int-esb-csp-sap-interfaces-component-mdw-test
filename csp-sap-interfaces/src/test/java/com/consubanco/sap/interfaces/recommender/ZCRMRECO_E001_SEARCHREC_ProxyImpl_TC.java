/**
 * 
 */
package com.consubanco.sap.interfaces.recommender;

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
 * 
 * @author <a href="mailto:juribe@consubanco.com">juribe</a>
 * 
 */
public class ZCRMRECO_E001_SEARCHREC_ProxyImpl_TC extends TestCase {

	private static Log log = LogFactory
			.getLog(ZCRMRECO_E001_SEARCHREC_ProxyImpl_TC.class);

	/**
	 * 
	 */
	public ZCRMRECO_E001_SEARCHREC_ProxyImpl_TC() {

	}

	/**
	 * @param name
	 */
	public ZCRMRECO_E001_SEARCHREC_ProxyImpl_TC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination() throws Exception {

		CRMLocalConfigEnvironmentData.instance();

		JCoDestination destination = JCoDestinationManager
				.getDestination("CSPSAPCRM");

		ZCRMRECO_E001_SEARCHREC_ProxyImpl proxy = new ZCRMRECO_E001_SEARCHREC_ProxyImpl();

		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
		ProxyInputParameter input = new ProxyInputParameter();
		input.setKey("I_BP");
		input.setValue("2606553");
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("I_CLIENT");
		input.setValue("");
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("I_RFC");
		input.setValue("");
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("I_CURP");
		input.setValue("");
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("I_NAME1");
		input.setValue("");
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("I_NAME2");
		input.setValue("");
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("I_APEPAT");
		input.setValue("");
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("I_APEMAT");
		input.setValue("");
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("I_COMPANY");
		input.setValue("");
		inputParams.add(input);

		ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction( destination, inputParams );

		log.info("Resurn Data :: " + returnData.toString());

	}
}
