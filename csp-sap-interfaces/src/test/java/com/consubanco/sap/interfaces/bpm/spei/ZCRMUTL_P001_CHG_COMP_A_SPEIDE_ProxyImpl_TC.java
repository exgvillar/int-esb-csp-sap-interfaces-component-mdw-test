/**
 * 
 */
package com.consubanco.sap.interfaces.bpm.spei;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.bpm.spei.ZCRMUTL_P001_CHG_COMP_A_SPEIDE_ProxyImpl;
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
public class ZCRMUTL_P001_CHG_COMP_A_SPEIDE_ProxyImpl_TC extends TestCase {

	private static Log log = LogFactory
			.getLog(ZCRMUTL_P001_CHG_COMP_A_SPEIDE_ProxyImpl_TC.class);

	/**
	 * 
	 */
	public ZCRMUTL_P001_CHG_COMP_A_SPEIDE_ProxyImpl_TC() {
		super();
	}

	/**
	 * @param name
	 */
	public ZCRMUTL_P001_CHG_COMP_A_SPEIDE_ProxyImpl_TC(String name) {
		super(name);
	}

	public void testDestination() throws Exception {

		CRMLocalConfigEnvironmentData.instance();

		JCoDestination destination = JCoDestinationManager
				.getDestination("CSPSAPCRM");

		ZCRMUTL_P001_CHG_COMP_A_SPEIDE_ProxyImpl proxy = new ZCRMUTL_P001_CHG_COMP_A_SPEIDE_ProxyImpl();

		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
		ProxyInputParameter input = new ProxyInputParameter();
		input.setKey("I_NUMDOC");
		input.setValue("0050069010");
		inputParams.add(input);

		ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(
				destination, inputParams);

		log.info(returnData.toString());

	}

}
