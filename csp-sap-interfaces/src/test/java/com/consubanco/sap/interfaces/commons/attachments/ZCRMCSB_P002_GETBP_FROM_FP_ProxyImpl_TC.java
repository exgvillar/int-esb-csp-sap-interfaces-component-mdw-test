/**
 * 
 */
package com.consubanco.sap.interfaces.commons.attachments;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.commons.ZCRMCSB_P002_GETBP_FROM_FP_ProxyImpl;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author user-admin
 *
 */
public class ZCRMCSB_P002_GETBP_FROM_FP_ProxyImpl_TC extends TestCase {
	
	private static Log log = LogFactory.getLog(ZCRMCSB_P002_GETBP_FROM_FP_ProxyImpl_TC.class);

	/**
	 * 
	 */
	public ZCRMCSB_P002_GETBP_FROM_FP_ProxyImpl_TC() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param name
	 */
	public ZCRMCSB_P002_GETBP_FROM_FP_ProxyImpl_TC(String name) {
		super(name);
	}

	public void testDestination() throws Exception {

		CRMLocalConfigEnvironmentData.instance();

		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");

		ZCRMCSB_P002_GETBP_FROM_FP_ProxyImpl proxyImpl = new ZCRMCSB_P002_GETBP_FROM_FP_ProxyImpl();

		ArrayList<ProxyInputParameter> inputParamtersList = null;
		ProxyInputParameter inputParameter = null;

		inputParamtersList = new ArrayList<ProxyInputParameter>();

		String fileName = "medioIzq.fpt";
		String pathOrigen = "C:/temp/enrollment/" + fileName;
		
		ArrayList<IProxyOutputData> returnData = null;
		byte[] contenidoArchivo = getContenidoArchivo(new File(pathOrigen));
		byte[] encodeBase64 = Base64.encodeBase64(contenidoArchivo);
		
		String fingerPrintB64 = new String(encodeBase64);
		
		inputParameter = new ProxyInputParameter();
		inputParameter.setKey("I_FP");
		inputParameter.setValue(fingerPrintB64);
		inputParamtersList.add(inputParameter);
		
		returnData = proxyImpl.executeRemoteFunction(destination, inputParamtersList);
		
		log.info(returnData.toString());
		
	}
	
	private byte[] getContenidoArchivo(File file) throws Exception {

		FileInputStream stream = new FileInputStream(file);
		byte[] data = new byte[stream.available()];
		stream.read(data);
		stream.close();

		return data;
	}

	

}
