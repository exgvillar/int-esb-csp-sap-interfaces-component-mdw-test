/**
 * 
 */
package com.consupago.sap.interfaces.proxy.cdb.bp;

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
public class ZRFC_CREAR_BP_MOVIL_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZRFC_CREAR_BP_MOVIL_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZRFC_CREAR_BP_MOVIL_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZRFC_CREAR_BP_MOVIL_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZRFC_CREAR_BP_MOVIL_ProxyImpl proxy = new ZRFC_CREAR_BP_MOVIL_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("NAME_FIRST");
        input.setValue( "JUAN" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("NAMEMIDDLE");
        input.setValue( "ANDRES" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("NAME_LAST");
        input.setValue( "LARRANIAGA" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("NAME_LST2");
        input.setValue( "MARTINEZ" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("SALES_ORG");
        input.setValue( "50000004" ); // TODO Must be 271 for CSP
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("CHANNEL");
        input.setValue( "01" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_RFC");
        input.setValue( "LAMJ800101U76" );
        inputParams.add( input );
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
