/**
 * 
 */
package com.consubanco.sap.interfaces.bpm.queues.mantto;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.bpm.queues.models.ZWRKQUEUE_UNASIGN_SOLS_Model;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author <a href="mailto:juribe@consubanco.com">juribe</a>
 * 
 */
public class ZCRMWKQUE_P010_UNASIGN_SOL_ProxyImpl_TC extends TestCase {

	private static Log log = LogFactory
			.getLog(ZCRMWKQUE_P010_UNASIGN_SOL_ProxyImpl_TC.class);

	public void testDestination() throws Exception {

		CRMLocalConfigEnvironmentData.instance();

		JCoDestination destination = JCoDestinationManager
				.getDestination("CSPSAPCRM");

		ZCRMWKQUE_P010_UNASIGN_SOL_ProxyImpl proxy = new ZCRMWKQUE_P010_UNASIGN_SOL_ProxyImpl();

		ArrayList<ZWRKQUEUE_UNASIGN_SOLS_Model> dataList = new ArrayList<ZWRKQUEUE_UNASIGN_SOLS_Model>();
		
		ZWRKQUEUE_UNASIGN_SOLS_Model model = new ZWRKQUEUE_UNASIGN_SOLS_Model();
		model.setBpId("0010001942");
		model.setNumSol(1);
		dataList.add(model);
		
		model = new ZWRKQUEUE_UNASIGN_SOLS_Model();
		model.setBpId("0010001950");
		model.setNumSol(2);
		dataList.add(model);
		
		model = new ZWRKQUEUE_UNASIGN_SOLS_Model();
		model.setBpId("0010002295");
		model.setNumSol(3);
		dataList.add(model);
		
		model = new ZWRKQUEUE_UNASIGN_SOLS_Model();
		model.setBpId("0010004651");
		model.setNumSol(4);
		dataList.add(model);
		
		model = new ZWRKQUEUE_UNASIGN_SOLS_Model();
		model.setBpId("0010006632");
		model.setNumSol(5);
		dataList.add(model);
		
		model = new ZWRKQUEUE_UNASIGN_SOLS_Model();
		model.setBpId("0010006633");
		model.setNumSol(6);
		dataList.add(model);
		
		ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, dataList);

		log.info("Resurn Data :: " + returnData.toString());

	}
}
