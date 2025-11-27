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
public class ZCRMRECO_P011_PDSO_I610_ProxyImpl_TC extends TestCase {
	
	private static Log log = LogFactory.getLog(ZCRMRECO_P011_PDSO_I610_ProxyImpl_TC.class);

	public void testDestination() throws Exception {

		CRMLocalConfigEnvironmentData.instance();

		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");

		ZCRMRECO_P011_PDSO_I610_ProxyImpl proxy = new ZCRMRECO_P011_PDSO_I610_ProxyImpl();

		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
		ProxyInputParameter input = new ProxyInputParameter();
		input.setKey("I_ID_ORDER");
		input.setValue("1525000047");
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("I_ID_ESTATUS");
		input.setValue("E0010");
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("I_LOTE_I610");
		input.setValue("1");
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("I_CONCEPTO_P_RSTM");
		input.setValue("00055124811250300003");
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("I_CODIGO_S_RSTM");
		input.setValue("1125000000000001525000047");
		inputParams.add(input);
 
		ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams);

		log.info("Resurn Data :: " + returnData.toString());

	}
}
