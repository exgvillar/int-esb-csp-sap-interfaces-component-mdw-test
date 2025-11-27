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
public class ZCRMRECO_P002_UPDSTS_ENROLREC_ProxyImpl_TC extends TestCase {

	private static Log log = LogFactory
			.getLog(ZCRMRECO_P002_UPDSTS_ENROLREC_ProxyImpl_TC.class);

	/**
	 * 
	 */
	public ZCRMRECO_P002_UPDSTS_ENROLREC_ProxyImpl_TC() {

	}

	/**
	 * @param name
	 */
	public ZCRMRECO_P002_UPDSTS_ENROLREC_ProxyImpl_TC(String name) {
		super(name);
	}

	public void testDestination() throws Exception {

		CRMLocalConfigEnvironmentData.instance();

		JCoDestination destination = JCoDestinationManager
				.getDestination("CSPSAPCRM");

		ZCRMRECO_P002_UPDSTS_ENROLREC_ProxyImpl proxy = new ZCRMRECO_P002_UPDSTS_ENROLREC_ProxyImpl();

		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
		ProxyInputParameter input = new ProxyInputParameter();
		input.setKey("I_ID_TAREA_ENROL");
		input.setValue("0000123938");
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("I_CLAVE_ESTATUS");
		input.setValue("E002");
		inputParams.add(input);

		ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction( destination, inputParams );

		log.info("Resurn Data :: " + returnData.toString());

	}
}
