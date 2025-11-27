/**
 * 
 */
package com.consubanco.sap.interfaces.commons;

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
 * @author <a href="mailto:juribe@consubanco.com">juribe</a>
 *
 */
public class ZCRMCSB_P002_LOCK_BP_ProxyImpl_TC extends TestCase {
	
	private static Log log = LogFactory.getLog(ZCRMCSB_P002_LOCK_BP_ProxyImpl_TC.class);
	
	/**
	 * 
	 */
	public ZCRMCSB_P002_LOCK_BP_ProxyImpl_TC() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name
	 */
	public ZCRMCSB_P002_LOCK_BP_ProxyImpl_TC(String name) {
		super(name);
	}

	public void testDestination() throws Exception {
		CRMLocalConfigEnvironmentData.instance();

		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");

		ZCRMCSB_P002_LOCK_BP_ProxyImpl proxyImpl = new ZCRMCSB_P002_LOCK_BP_ProxyImpl();
		
		
		ArrayList<ProxyInputParameter> inputParamtersList = null;
		ProxyInputParameter inputParameter = null;

		inputParamtersList = new ArrayList<ProxyInputParameter>();

		
		inputParameter = new ProxyInputParameter();
		inputParameter.setKey("I_PARTNER");
		inputParameter.setValue("0002600768");
		inputParamtersList.add(inputParameter);

		inputParameter = new ProxyInputParameter();
		inputParameter.setKey("I_BLOCK");
		inputParameter.setValue("");
		inputParamtersList.add(inputParameter);
		
		ArrayList<IProxyOutputData> returnData = proxyImpl.executeRemoteFunction(destination, inputParamtersList);
		
		log.info(returnData.toString());
		
	}
}
