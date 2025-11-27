/**
 * 
 */
package com.consupago.sap.interfaces.proxy.ivr;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import junit.framework.TestCase;


import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author juribe
 * 
 */
public class ZRFC_IVR_GET_INFO_TICKETS_ProxyImplTC extends TestCase {
	
	private static Log log = LogFactory.getLog( ZRFC_IVR_GET_INFO_TICKETS_ProxyImplTC.class );

	/**
	 * 
	 */
	public ZRFC_IVR_GET_INFO_TICKETS_ProxyImplTC() {
		super();
	}

	/**
	 * @param name
	 */
	public ZRFC_IVR_GET_INFO_TICKETS_ProxyImplTC(String name) {
		super(name);
	}

	public void testDeberiaObtenerInfoTicket() throws Exception {

		CRMLocalConfigEnvironmentData.instance();

		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");

		ZRFC_IVR_GET_INFO_TICKETS_ProxyImpl impl = new ZRFC_IVR_GET_INFO_TICKETS_ProxyImpl();
		
		ArrayList<ProxyInputParameter> inputParamtersList = new ArrayList<ProxyInputParameter>();
		ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_TICKET");
        input.setValue( StringUtils.trimToEmpty( fillStringWithZerosOnLeft("100038614", 10) ) );
        inputParamtersList.add( input );
		
		ArrayList<IProxyOutputData> returnData = impl.executeRemoteFunction(destination, inputParamtersList );
		
        log.info( returnData.toString() );

	}
	
	public static String fillStringWithZerosOnLeft(String str, int toLength) {
		StringBuffer buffer = new StringBuffer();
		if (str.length() >= toLength)
			buffer.append(str);
		else {
			int j = str.length();
			for (int i = j; i < toLength; i++) {
				buffer.append("0");
			}
			buffer.append(str);
		}
		return (buffer.toString());
	}
}
