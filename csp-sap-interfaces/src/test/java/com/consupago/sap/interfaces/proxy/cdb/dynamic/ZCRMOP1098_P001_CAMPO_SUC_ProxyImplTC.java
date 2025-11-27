/**
 * 
 */
package com.consupago.sap.interfaces.proxy.cdb.dynamic;

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
 * @author ramon.becerra
 *
 */
public class ZCRMOP1098_P001_CAMPO_SUC_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMOP1098_P001_CAMPO_SUC_ProxyImplTC.class );
	
	
	/**
	 * 
	 */
	public ZCRMOP1098_P001_CAMPO_SUC_ProxyImplTC() {
	}

	/**
	 * @param name
	 */
	public ZCRMOP1098_P001_CAMPO_SUC_ProxyImplTC(String name) {
		super(name);
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMOP1098_P001_CAMPO_SUC_ProxyImpl proxy = new ZCRMOP1098_P001_CAMPO_SUC_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("ZID_CONVENIO");
        input.setValue( "10000041" );
        inputParams.add( input );
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
