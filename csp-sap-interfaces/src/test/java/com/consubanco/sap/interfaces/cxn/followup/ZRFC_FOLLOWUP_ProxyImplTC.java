/**
 * 
 */
package com.consubanco.sap.interfaces.cxn.followup;

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
public class ZRFC_FOLLOWUP_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZRFC_FOLLOWUP_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZRFC_FOLLOWUP_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZRFC_FOLLOWUP_ProxyImplTC(String name) {
		super(name);
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZRFC_FOLLOWUP_ProxyImpl proxy = new ZRFC_FOLLOWUP_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("ZID_PROMOTOR");
        input.setValue( "17107026" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("ZID_CLIENTE");
        input.setValue( "283118" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("ZID_CONVENIO");
        input.setValue( "10000380" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("ZID_PRODUCTO");
        input.setValue( "1021" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("ZMONTO");
        input.setValue( "5000.00" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("ZDESCRIPCION");
        input.setValue( "XXX" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("ZID_EMPRESA");
        input.setValue( "900" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("ZID_CANAL");
        input.setValue( "01" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("ZID_SUCURSAL");
        input.setValue( "51114339" );
        inputParams.add( input );
       
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
