/**
 * 
 */
package com.consubanco.sap.interfaces.commons.attachments;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author <a href="mailto:juribe@consubanco.com">juribe</a>
 *
 */
public class ZCRMORI_P008_READ_FILESATTACH_ProxyImplTC extends TestCase {
	
	private static final Log log = LogFactory.getLog(ZCRMORI_P008_READ_FILESATTACH_ProxyImplTC.class);

	/**
	 * 
	 */
	public ZCRMORI_P008_READ_FILESATTACH_ProxyImplTC() {
		super();
	}

	public void testDestination( ) throws Exception{
		
		CRMLocalConfigEnvironmentData.instance();
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");

		ZCRMORI_P008_READ_FILESATTACH_ProxyImpl proxyImpl = new ZCRMORI_P008_READ_FILESATTACH_ProxyImpl();
		
		
		
		ArrayList<ProxyInputParameter> inputParamtersList = null;
		ProxyInputParameter inputParameter = null;
		
		inputParamtersList = new ArrayList<ProxyInputParameter>();
		
		inputParameter = new ProxyInputParameter();
		inputParameter.setKey("I_NUMDOC");
		inputParameter.setValue("0060073166");
		inputParamtersList.add(inputParameter);
		
		inputParameter = new ProxyInputParameter();
		inputParameter.setKey("I_TIPDOC");
		inputParameter.setValue("ZSTC");
		inputParamtersList.add(inputParameter);
		
		
		ArrayList<IProxyOutputData> returnData = proxyImpl.executeRemoteFunction(destination, inputParamtersList);
		
		log.info( returnData.toString() );
		
	}
	
	
	
	

}
