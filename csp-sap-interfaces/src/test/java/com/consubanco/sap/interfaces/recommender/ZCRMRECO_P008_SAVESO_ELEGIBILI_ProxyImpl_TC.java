/**
 * 
 */
package com.consubanco.sap.interfaces.recommender;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.recommender.model.ElegibilityModel;
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
public class ZCRMRECO_P008_SAVESO_ELEGIBILI_ProxyImpl_TC extends TestCase {

	private static Log log = LogFactory.getLog(ZCRMRECO_P008_SAVESO_ELEGIBILI_ProxyImpl_TC.class);

	/**
	 * 
	 */
	public ZCRMRECO_P008_SAVESO_ELEGIBILI_ProxyImpl_TC() {

	}

	/**
	 * @param name
	 */
	public ZCRMRECO_P008_SAVESO_ELEGIBILI_ProxyImpl_TC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination() throws Exception {

		CRMLocalConfigEnvironmentData.instance();

		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");

		ZCRMRECO_P008_SAVESO_ELEGIBILI_ProxyImpl proxy = new ZCRMRECO_P008_SAVESO_ELEGIBILI_ProxyImpl();
		ElegibilityModel elegibilityRequest = new ElegibilityModel();
		elegibilityRequest.setServiceOrderId("1525000139");
		elegibilityRequest.setRecommenderBp("1142");
		elegibilityRequest.setRecommendedBp("1143");
		elegibilityRequest.setSolCotRecomended("50384736");
		elegibilityRequest.setAmount(267.00);
		elegibilityRequest.setElegibility(true);
		List<String> motives = new ArrayList<String>();
		motives.add("001");
		elegibilityRequest.setStatus("002");
		elegibilityRequest.setMotives(motives );
		elegibilityRequest.setRecommendedNumber(5);
		elegibilityRequest.setElegibilityDate(new Date());
		elegibilityRequest.setPeriodStartDate(new Date());
		elegibilityRequest.setPeriodEndDate(new Date());
		
		ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, elegibilityRequest );

		log.info("Resurn Data :: " + returnData.toString());

	}
}
