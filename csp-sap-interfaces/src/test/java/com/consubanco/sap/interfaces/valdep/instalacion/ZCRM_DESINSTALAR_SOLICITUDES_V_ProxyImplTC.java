/**
 * 
 */
package com.consubanco.sap.interfaces.valdep.instalacion;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author ramon.becerra
 *
 */
public class ZCRM_DESINSTALAR_SOLICITUDES_V_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRM_DESINSTALAR_SOLICITUDES_V_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRM_DESINSTALAR_SOLICITUDES_V_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRM_DESINSTALAR_SOLICITUDES_V_ProxyImplTC(String name) {
		super(name);
	}

	public void testExecute( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        System.out.println("INFO::" + destination.getClient());
        ZCRM_DESINSTALAR_SOLICITUDES_V_ProxyImpl proxy = new ZCRM_DESINSTALAR_SOLICITUDES_V_ProxyImpl();
        

        ArrayList<ZCRM_DESINSTALAR_SOLICITUDES_V_OutputData> arrDesintalar = proxy.executeRemoteFunction(destination );
        log.info(arrDesintalar.toString() );
	}
}
