/**
 * 
 */
package com.consupago.sap.interfaces.proxy.cm;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.format.SAPFormatter;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author ramon.becerra
 *
 */
public class ZCRM_SUCURSAL_TOTALES_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRM_SUCURSAL_TOTALES_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRM_SUCURSAL_TOTALES_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRM_SUCURSAL_TOTALES_ProxyImplTC(String name) {
		super(name);
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRM_SUCURSAL_TOTALES_ProxyImpl proxy = new ZCRM_SUCURSAL_TOTALES_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("IDSUCURSAL");
        input.setValue( "112" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("FECHA_INICIO");
        input.setDateValue( SAPFormatter.formatSAPDate( "01.09.2012" ) );
        input.setType("java.util.Date");
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("FECHA_FIN");
        input.setDateValue( SAPFormatter.formatSAPDate( "30.09.2012" ) );
        input.setType("java.util.Date");
        inputParams.add( input );
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
