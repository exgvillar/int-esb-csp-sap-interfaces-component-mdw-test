/**
 * 
 */
package com.consubanco.sap.interfaces.commons;

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
public class ZCRMCSB_E002_BUSCABP_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMCSB_E002_BUSCABP_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMCSB_E002_BUSCABP_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMCSB_E002_BUSCABP_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMCSB_E002_BUSCABP_ProxyImpl proxy = new ZCRMCSB_E002_BUSCABP_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_BP");
        input.setValue( "0002610212" );
        //input.setValue( "0000577987" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_CLIENT");
        input.setValue( "" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_RFC");
        input.setValue( "" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_NAME1");
        input.setValue( "" );
        //input.setValue( "MANUEL" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_NAME2");
        input.setValue( "" );
        //input.setValue( "ALEJANDRO" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_APEPAT");
        input.setValue( "" );
        //input.setValue( "LOPEZ" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_APEMAT");
        input.setValue( "" );
        //input.setValue( "CASTILLO" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_COMPANY");
        input.setValue( "" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_FIND_BASIC");
        input.setValue( "" );
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("I_CURP");
        input.setValue( "" ); //RACA720520HNEMRN03
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
