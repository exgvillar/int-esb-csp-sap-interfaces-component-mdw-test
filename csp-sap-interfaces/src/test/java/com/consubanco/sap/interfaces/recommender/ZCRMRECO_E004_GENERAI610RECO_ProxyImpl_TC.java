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
public class ZCRMRECO_E004_GENERAI610RECO_ProxyImpl_TC extends TestCase {

	private static Log log = LogFactory
			.getLog(ZCRMRECO_E004_GENERAI610RECO_ProxyImpl_TC.class);

	/**
	 * 
	 */
	public ZCRMRECO_E004_GENERAI610RECO_ProxyImpl_TC() {

	}

	/**
	 * @param name
	 */
	public ZCRMRECO_E004_GENERAI610RECO_ProxyImpl_TC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination() throws Exception {

		CRMLocalConfigEnvironmentData.instance();
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");

		ZCRMRECO_E004_GENERAI610RECO_ProxyImpl proxy = new ZCRMRECO_E004_GENERAI610RECO_ProxyImpl();
		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
		
		ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction( destination, inputParams );
		log.info("Return Data :: " + returnData.toString());

	}
}
