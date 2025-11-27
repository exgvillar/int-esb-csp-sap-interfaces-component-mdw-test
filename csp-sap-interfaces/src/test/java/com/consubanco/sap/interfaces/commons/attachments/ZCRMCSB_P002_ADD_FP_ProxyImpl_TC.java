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
public class ZCRMCSB_P002_ADD_FP_ProxyImpl_TC extends TestCase {

	private static Log log = LogFactory.getLog(ZCRMCSB_P002_ADD_FP_ProxyImpl_TC.class);

	
	/**
	 * 
	 */
	public ZCRMCSB_P002_ADD_FP_ProxyImpl_TC() {
	}

	/**
	 * @param name
	 */
	public ZCRMCSB_P002_ADD_FP_ProxyImpl_TC(String name) {
		super(name);
	}

	/*
	 * Al menos uno de los dos parámetros debe contener información (foto o huella digital)
	 */
	public void testDestination() throws Exception {
		log.info("IN Testing Attach FingerPrint");
		CRMLocalConfigEnvironmentData.instance();

		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
		
		ZCRMCSB_P002_ADDUPDGET_FP_ProxyImpl proxy = new ZCRMCSB_P002_ADDUPDGET_FP_ProxyImpl();

		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
		ProxyInputParameter input = new ProxyInputParameter();
		input.setKey("I_PARTNER");
		input.setValue("0002600771");
		inputParams.add(input);
		
		input = new ProxyInputParameter();
		input.setKey("I_MODE");
		input.setValue("U");
		inputParams.add(input);

		String fileName = "medioIzq.fpt";
		String pathOrigen = "C:/temp/enrollment/" + fileName;
		
		ArrayList<IProxyOutputData> returnData = null;
		byte[] contenidoArchivo = getContenidoArchivo(pathOrigen);
		byte[] encodeBase64 = Base64.encodeBase64(contenidoArchivo);
		
		String finalContent = new String(encodeBase64);
		
			
		File photo = null;
		photo = new File("c:/tmp/prueba.jpg");
		
		returnData = proxy.executeRemoteFunction(destination, inputParams, finalContent, getContenidoArchivo(photo) );

            
		log.info(returnData.toString());
		
		log.info("OUT Testing Attach FingerPrint");
	}
	
	private byte[] getContenidoArchivo(String path) throws Exception {

		FileInputStream stream = new FileInputStream(new File(path));
		byte[] data = new byte[stream.available()];
		stream.read(data);
		stream.close();

		return data;
	}
	
	private byte[] getContenidoArchivo(File file) throws Exception {

		FileInputStream stream = new FileInputStream(file);
		byte[] data = new byte[stream.available()];
		stream.read(data);
		stream.close();

		return data;
	}
}
