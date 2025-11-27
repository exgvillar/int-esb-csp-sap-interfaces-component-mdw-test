/**
 * 
 */
package com.consubanco.sap.interfaces.cxn.forms;

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
 * @author haydee.sanchez
 *
 */
public class ZCRMCV_E007_EXTRACTDATA_AB_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMCV_E007_EXTRACTDATA_AB_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMCV_E007_EXTRACTDATA_AB_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMCV_E007_EXTRACTDATA_AB_ProxyImplTC(String name) {
		super(name);
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMCV_E007_EXTRACTDATA_AB_ProxyImpl proxy = new ZCRMCV_E007_EXTRACTDATA_AB_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("ID_SOLICITUD");
        input.setValue( "0050225902" );
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
