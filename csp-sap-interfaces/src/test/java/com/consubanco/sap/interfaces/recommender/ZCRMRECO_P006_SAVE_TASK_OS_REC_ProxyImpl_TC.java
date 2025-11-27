/**
 * 
 */
package com.consubanco.sap.interfaces.recommender;

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
 * 
 * @author Ing. Adrian Alejo
 * 
 */
public class ZCRMRECO_P006_SAVE_TASK_OS_REC_ProxyImpl_TC extends TestCase {

	private static Log log = LogFactory
			.getLog(ZCRMRECO_P006_SAVE_TASK_OS_REC_ProxyImpl_TC.class);

	/**
	 * 
	 */
	public ZCRMRECO_P006_SAVE_TASK_OS_REC_ProxyImpl_TC() {

	}

	/**
	 * @param name
	 */
	public ZCRMRECO_P006_SAVE_TASK_OS_REC_ProxyImpl_TC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination() throws Exception {

		CRMLocalConfigEnvironmentData.instance();

		JCoDestination destination = JCoDestinationManager
				.getDestination("CSPSAPCRM");

		ZCRMRECO_P006_SAVE_TASK_OS_REC_ProxyImpl proxy = new ZCRMRECO_P006_SAVE_TASK_OS_REC_ProxyImpl();

		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
		ProxyInputParameter input = new ProxyInputParameter();
		input.setKey("I_NUM_TAREA_ENROL");
		input.setValue("1750000005");
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("I_ID_ORDEN_SERVICIO");
		input.setValue("0");
		inputParams.add(input);
		
		input = new ProxyInputParameter();
		input.setKey("I_BP_RECOMENDADOR");
		input.setValue("0");
		inputParams.add(input);
		
		ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction( destination, inputParams );

		log.info("Resurn Data :: " + returnData.toString());

	}
}
