/**
 * 
 */
package com.consubanco.sap.interfaces.common.terminados;

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
public class ZCRMCRT_P001_SAVE_CONYUGE_ProxyImplTC extends TestCase {
	private static Log log = LogFactory.getLog(ZCRMCRT_P001_SAVE_CONYUGE_ProxyImplTC.class);

	public void testDestination() throws Exception {

		CRMLocalConfigEnvironmentData.instance();

		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");

		ZCRMCRT_P001_SAVE_CONYUGE_ProxyImpl proxy = new ZCRMCRT_P001_SAVE_CONYUGE_ProxyImpl();

		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
		ProxyInputParameter input = new ProxyInputParameter();

		input.setKey("I_ID_CLIENTE");
		input.setValue("0000045434");
		inputParams.add(input);
		input = new ProxyInputParameter();
		input.setKey("I_NOM1_CONYUGE");
		input.setValue("JULIA");
		inputParams.add(input);
		input = new ProxyInputParameter();
		input.setKey("I_NOM2_CONYUGE");
		input.setValue("ANA");
		inputParams.add(input);
		input = new ProxyInputParameter();
		input.setKey("I_APEPAT_CONYUGE");
		input.setValue("TORRES");
		inputParams.add(input);
		input = new ProxyInputParameter();
		input.setKey("I_APEMAT_CONYUGE");
		input.setValue("MESA");
		inputParams.add(input);

		ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams);

		log.info(" Data :: " + returnData.toString());

	}
}
