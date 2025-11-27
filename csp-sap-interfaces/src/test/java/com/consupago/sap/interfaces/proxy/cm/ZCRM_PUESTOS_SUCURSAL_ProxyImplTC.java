/**
 * 
 */
package com.consupago.sap.interfaces.proxy.cm;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.lang.StringUtils;
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
public class ZCRM_PUESTOS_SUCURSAL_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRM_PUESTOS_SUCURSAL_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRM_PUESTOS_SUCURSAL_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRM_PUESTOS_SUCURSAL_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRM_PUESTOS_SUCURSAL_ProxyImpl proxy = new ZCRM_PUESTOS_SUCURSAL_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("IDEMPLEADO");
        input.setValue( "314501	" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("IDPUESTO");
        input.setValue( StringUtils.trim( "PROMO" ) );
        inputParams.add( input );
        
        ArrayList<String> sucursalesList = new ArrayList<String>();
        sucursalesList.add( "112" );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams, sucursalesList );
        
        log.info( returnData.toString() );
        
        
	}
}
