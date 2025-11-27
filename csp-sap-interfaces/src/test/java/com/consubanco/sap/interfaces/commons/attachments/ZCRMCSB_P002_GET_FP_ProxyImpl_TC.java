package com.consubanco.sap.interfaces.commons.attachments;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.commons.ZCRMCSB_P002_ADDUPDGET_FP_ProxyImpl;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * Test Case para adjuntar la huella digital
 * 
 * @author <a href="mailto:juribe@consubanco.com">juribe</a>
 *
 */
public class ZCRMCSB_P002_GET_FP_ProxyImpl_TC extends TestCase{

	private static Log log = LogFactory.getLog(ZCRMCSB_P002_GET_FP_ProxyImpl_TC.class);
	
	public ZCRMCSB_P002_GET_FP_ProxyImpl_TC() {
		super();
	}

	public void testDestination() throws Exception {

		CRMLocalConfigEnvironmentData.instance();

		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");

		ZCRMCSB_P002_ADDUPDGET_FP_ProxyImpl proxyImpl = new ZCRMCSB_P002_ADDUPDGET_FP_ProxyImpl();

		ArrayList<ProxyInputParameter> inputParamtersList = null;
		ProxyInputParameter inputParameter = null;

		inputParamtersList = new ArrayList<ProxyInputParameter>();

		inputParameter = new ProxyInputParameter();
		inputParameter.setKey("I_MODE");
		inputParameter.setValue("R");
		inputParamtersList.add(inputParameter);
		
		inputParameter = new ProxyInputParameter();
		inputParameter.setKey("I_PARTNER");
		inputParameter.setValue("0002600768");
		inputParamtersList.add(inputParameter);

		
		int descarga = 3;//Descarga Ambos
//		int descarga = 2;//Descarga solo la foto 
//		int descarga = 1;//Descarga solo la huella digital
		
		ArrayList<IProxyOutputData> returnData = proxyImpl.executeRemoteFunction(destination, inputParamtersList, descarga );
		
		log.info(returnData.toString());
		
	}
}
