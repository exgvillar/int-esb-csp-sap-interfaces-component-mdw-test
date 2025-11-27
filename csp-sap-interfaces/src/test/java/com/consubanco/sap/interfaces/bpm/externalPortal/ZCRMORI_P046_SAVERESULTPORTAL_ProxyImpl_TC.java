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
public class ZCRMORI_P046_SAVERESULTPORTAL_ProxyImpl_TC extends TestCase {

	
	private static Log log = LogFactory.getLog(ZCRMORI_P046_SAVERESULTPORTAL_ProxyImpl_TC.class);

	/**
	 * 
	 */
	public ZCRMORI_P046_SAVERESULTPORTAL_ProxyImpl_TC() {
		super();
	}

	/**
	 * @param name
	 */
	public ZCRMORI_P046_SAVERESULTPORTAL_ProxyImpl_TC(String name) {
		super(name);
	}

	public void testDestination() throws Exception {

		CRMLocalConfigEnvironmentData.instance();

		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");

		ZCRMORI_P046_SAVERESULTPORTAL_ProxyImpl proxy = new ZCRMORI_P046_SAVERESULTPORTAL_ProxyImpl();

		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
		ProxyInputParameter input = null;
		
		input = new ProxyInputParameter();
		input.setKey("I_SOLICITUD");
		input.setValue("50386852");
		inputParams.add(input);
		
		input = new ProxyInputParameter();
		input.setKey("I_PORTALID");
		input.setValue("1");
		inputParams.add(input);
		
		input = new ProxyInputParameter();
		input.setKey("I_RESERVA");
		input.setValue("1823729");
		inputParams.add(input);
		
		input = new ProxyInputParameter();
		input.setKey("I_CONTRATO");
		input.setValue("94187191");
		inputParams.add(input);

		ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams);

		log.info(returnData.toString());

	}
}
