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
import com.consupago.sap.interfaces.format.SAPFormatter;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author ramon.becerra
 *
 */
public class ZCRM_BP_TOTAL_SEGURO_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRM_BP_TOTAL_SEGURO_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRM_BP_TOTAL_SEGURO_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRM_BP_TOTAL_SEGURO_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRM_BP_TOTAL_SEGURO_ProxyImpl proxy = new ZCRM_BP_TOTAL_SEGURO_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("IDBP");
        input.setValue( "314061" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("PUESTO");
        input.setValue( StringUtils.trim( "PROMO" ) );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("FECHA_INICIO");
        input.setDateValue( SAPFormatter.formatSAPDate( "01.10.2012" ) );
        input.setType("java.util.date");
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("FECHA_FIN");
        input.setDateValue( SAPFormatter.formatSAPDate( "30.10.2012" ) );
        input.setType("java.util.date");
        inputParams.add( input );
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
