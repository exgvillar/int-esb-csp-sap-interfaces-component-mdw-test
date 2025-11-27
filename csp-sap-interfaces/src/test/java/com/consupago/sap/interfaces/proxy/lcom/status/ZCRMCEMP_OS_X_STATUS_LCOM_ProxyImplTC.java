/**
 * 
 */
package com.consupago.sap.interfaces.proxy.lcom.status;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.common.utils.CRM_Estatus_Solicitudes;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author ramon.becerra
 *
 */
public class ZCRMCEMP_OS_X_STATUS_LCOM_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMCEMP_OS_X_STATUS_LCOM_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMCEMP_OS_X_STATUS_LCOM_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMCEMP_OS_X_STATUS_LCOM_ProxyImplTC(String name) {
		super(name);
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMCEMP_OS_X_STATUS_LCOM_ProxyImpl proxy = new ZCRMCEMP_OS_X_STATUS_LCOM_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_STATUS");
        input.setValue( CRM_Estatus_Solicitudes.ZLIQCOMP_CON_INCIDENCIA_DISPERSION );
        inputParams.add( input );
               
        
        ArrayList<ZCRMCEMP_OS_X_STATUS_LCOM_OutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
