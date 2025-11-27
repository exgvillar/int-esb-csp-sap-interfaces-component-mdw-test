/**
 * 
 */
package com.consubanco.sap.interfaces.applications;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.applications.ZCRMORI_GETSOLICITUDES_RESERVA_ProxyImpl;
import com.consupago.sap.interfaces.proxy.applications.model.ZTT_ESTATUS_Model;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author
 * 
 */
public class ZCRMORI_GETSOLICITUDES_RESERVA_ProxyImpl_TC extends TestCase {

	private static Log log = LogFactory.getLog(ZCRMORI_GETSOLICITUDES_RESERVA_ProxyImpl_TC.class);

	public ZCRMORI_GETSOLICITUDES_RESERVA_ProxyImpl_TC() {
		super();
	}

	public ZCRMORI_GETSOLICITUDES_RESERVA_ProxyImpl_TC(String name) {
		super(name);
	}

	public void testDestination() throws Exception {

		CRMLocalConfigEnvironmentData.instance();
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
		
		ZCRMORI_GETSOLICITUDES_RESERVA_ProxyImpl proxyImpl = new ZCRMORI_GETSOLICITUDES_RESERVA_ProxyImpl();

		ArrayList<ZTT_ESTATUS_Model> inputParams = new ArrayList<ZTT_ESTATUS_Model>();
		ZTT_ESTATUS_Model input = new ZTT_ESTATUS_Model();

		input.setStatus("E0030");

		inputParams.add(input);
		

		long currentTimeMillis = System.currentTimeMillis();
		ArrayList<IProxyOutputData> returnData = proxyImpl.executeRemoteFunction( destination, inputParams );
		long finalCurrentTimeMillis = System.currentTimeMillis();
		
		log.info(returnData.toString());

		System.out.println( (finalCurrentTimeMillis - currentTimeMillis)/1000);
	}

}
