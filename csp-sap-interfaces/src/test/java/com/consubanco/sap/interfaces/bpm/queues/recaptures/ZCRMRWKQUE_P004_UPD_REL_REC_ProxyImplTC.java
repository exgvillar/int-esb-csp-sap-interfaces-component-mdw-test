/**
 * 
 */
package com.consubanco.sap.interfaces.bpm.queues.recaptures;

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
public class ZCRMRWKQUE_P004_UPD_REL_REC_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMRWKQUE_P004_UPD_REL_REC_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMRWKQUE_P004_UPD_REL_REC_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMRWKQUE_P004_UPD_REL_REC_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMRWKQUE_P004_UPD_REL_REC_ProxyImpl proxy = new ZCRMRWKQUE_P004_UPD_REL_REC_ProxyImpl();
                                      
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_NUM_SOLICITUD");
        input.setValue( "0050385535" ); 
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_NUM_RECAPTURA");
        input.setValue( "001" ); 
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_NUM_INCIDENCIA");
        input.setValue( "1" );  
        inputParams.add( input );
                
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
       
        log.info( "Resurn Data :: " + returnData.toString() );
        
	}
}
