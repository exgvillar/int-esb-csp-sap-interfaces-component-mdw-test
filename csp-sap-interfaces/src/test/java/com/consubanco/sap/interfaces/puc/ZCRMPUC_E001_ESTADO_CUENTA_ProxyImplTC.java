/**
 * 
 */
package com.consubanco.sap.interfaces.puc;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.commons.cub.ZCRMCAP_E001_GETINFOFORCUB_ProxyImpl;
import com.consubanco.sap.interfaces.commons.cub.ZCRMCAP_E001_GETINFOFORCUB_ProxyImplTC;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

import junit.framework.TestCase;

/**
 * @author estefania.montoya
 *
 */
public class ZCRMPUC_E001_ESTADO_CUENTA_ProxyImplTC extends TestCase  {

private static Log logger = LogFactory.getLog(ZCRMCAP_E001_GETINFOFORCUB_ProxyImplTC.class);
	
	public void testGetAccountStatus() throws Exception {

		CRMLocalConfigEnvironmentData.instance();

		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");

		ZCRMPUC_E001_ESTADO_CUENTA_ProxyImpl proxy = new ZCRMPUC_E001_ESTADO_CUENTA_ProxyImpl();

		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
		ProxyInputParameter input = new ProxyInputParameter();
		input.setKey("I_ACCOUNT_ID");
		input.setValue("000007775579")	/*dev 000007689358*/;
		inputParams.add(input);
		
	
		ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams);

		logger.info("Estado de cuenta: "+returnData.toString());
	}
}
