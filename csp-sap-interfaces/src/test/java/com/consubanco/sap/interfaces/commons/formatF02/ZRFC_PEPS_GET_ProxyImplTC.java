/**
 * 
 */
package com.consubanco.sap.interfaces.commons.formatF02;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.common.formatF02.ZRFC_PEPS_GET_ProxyImpl;
import com.consubanco.sap.interfaces.common.formatF02.model.ZTL_PEPS_Model;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author haydee.sanchez
 *
 */
public class ZRFC_PEPS_GET_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZRFC_PEPS_GET_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZRFC_PEPS_GET_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZRFC_PEPS_GET_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZRFC_PEPS_GET_ProxyImpl proxy = new ZRFC_PEPS_GET_ProxyImpl();
        
		//DEV I_CLIENT: 2606635, I_NUMDOC: 70000280
		//QA I_CLIENT: 94772, I_NUMDOC: 50244288
		//QA I_CLIENT: 4010128, I_NUMDOC: 50547446
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_CLIENT");
        input.setValue( "0002606635" ); //0002606635 0000000142
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_NUMDOC");
        input.setValue( "0070000280" );// 0070000280 0060000257
        inputParams.add( input );

        
        ZTL_PEPS_Model pepData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( pepData.toString() );
        
        
        
	}
}
