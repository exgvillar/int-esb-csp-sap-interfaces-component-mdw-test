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
public class ZCRMRECO_P004_SAVESERVICEORDER_ProxyImpl_TC extends TestCase {

	private static Log log = LogFactory
			.getLog(ZCRMRECO_P004_SAVESERVICEORDER_ProxyImpl_TC.class);

	/**
	 * 
	 */
	public ZCRMRECO_P004_SAVESERVICEORDER_ProxyImpl_TC() {

	}

	/**
	 * @param name
	 */
	public ZCRMRECO_P004_SAVESERVICEORDER_ProxyImpl_TC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination() throws Exception {

		CRMLocalConfigEnvironmentData.instance();

		JCoDestination destination = JCoDestinationManager
				.getDestination("CSPSAPCRM");

		ZCRMRECO_P004_SAVESERVICEORDER_ProxyImpl proxy = new ZCRMRECO_P004_SAVESERVICEORDER_ProxyImpl();

		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
		ProxyInputParameter input = new ProxyInputParameter();
		input.setKey("I_ID_ORDEN_SERVICIO");
		input.setValue("ABC");
		inputParams.add(input);

		input = new ProxyInputParameter();
		input.setKey("I_BP_RECOMENDADOR");
		input.setValue("A123123");
		inputParams.add(input);
		
		input = new ProxyInputParameter();
		input.setKey("I_EMP_RESPONSABLE");
		input.setValue("B123123");
		inputParams.add(input);
		
		input = new ProxyInputParameter();
		input.setKey("I_BP_RECOMENDADO");
		input.setValue("C123123");
		inputParams.add(input);
		
		input = new ProxyInputParameter();
		input.setKey("I_SOL_COT_RECOMENDADO");
		input.setValue("D5544");
		inputParams.add(input);
		
		input = new ProxyInputParameter();
		input.setKey("I_CANAL_ORIGEN");
		input.setValue("E123123");
		inputParams.add(input);
		
		input = new ProxyInputParameter();
		input.setKey("I_MONTO");
		input.setValue("00123120");
		inputParams.add(input);
		
		input = new ProxyInputParameter();
		input.setKey("I_OBSERVACIONES");
		input.setValue("F123123");
		inputParams.add(input);
		
		input = new ProxyInputParameter();
		input.setKey("I_MOTIVO");
		input.setValue("G123123");
		inputParams.add(input);		

		ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction( destination, inputParams );

		log.info("Resurn Data :: " + returnData.toString());

	}
}
