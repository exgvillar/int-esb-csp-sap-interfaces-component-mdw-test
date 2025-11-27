/**
 * 
 */
package com.consubanco.sap.interfaces.autoservice.forms;

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
 * 
 * @author <a href="mailto:juribe@consubanco.com">juribe</a>
 *
 */
public class ZCRMAUTO_E017_EXTRACTDATA_ProxyImpl_TC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMAUTO_E017_EXTRACTDATA_ProxyImpl_TC.class );
	
	
	/**
	 * 
	 */
	public ZCRMAUTO_E017_EXTRACTDATA_ProxyImpl_TC() {
	}

	/**
	 * @param name
	 */
	public ZCRMAUTO_E017_EXTRACTDATA_ProxyImpl_TC(String name) {
		super(name);
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMAUTO_E017_EXTRACTDATA_ProxyImpl proxy = new ZCRMAUTO_E017_EXTRACTDATA_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("ID_SOLICITUD");
        input.setValue( "0040000048" );
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}

}
