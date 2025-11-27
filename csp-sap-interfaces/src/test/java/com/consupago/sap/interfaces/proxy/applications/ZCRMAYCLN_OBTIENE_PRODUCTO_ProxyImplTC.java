/**
 * 
 */
package com.consupago.sap.interfaces.proxy.applications;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.applications.model.ZTL_SOLICITUD_Model;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author omar.corona
 *
 */
public class ZCRMAYCLN_OBTIENE_PRODUCTO_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMAYCLN_OBTIENE_PRODUCTO_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMAYCLN_OBTIENE_PRODUCTO_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMAYCLN_OBTIENE_PRODUCTO_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMAYCLN_OBTIENE_PRODUCTO_ProxyImpl proxy = new ZCRMAYCLN_OBTIENE_PRODUCTO_ProxyImpl();
        
        ArrayList<ZTL_SOLICITUD_Model> inputParams = new ArrayList<ZTL_SOLICITUD_Model>();

        ZTL_SOLICITUD_Model data = new ZTL_SOLICITUD_Model();
        data.setApplicationId("0050000430");
        inputParams.add( data );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
