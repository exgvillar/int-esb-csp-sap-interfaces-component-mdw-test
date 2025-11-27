/**
 * 
 */
package com.consubanco.sap.interfaces.bpm.queues.mantto;

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
public class ZCRMWKQUE_E004_GTPRI_CONV_CATP_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMWKQUE_E004_GTPRI_CONV_CATP_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMWKQUE_E004_GTPRI_CONV_CATP_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMWKQUE_E004_GTPRI_CONV_CATP_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMWKQUE_E004_GTPRI_CONV_CATP_ProxyImpl proxy = new ZCRMWKQUE_E004_GTPRI_CONV_CATP_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_CONVENIO");
        input.setValue( "" ); //10000027
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_DESCCONV");
        input.setValue( "" );//SEP
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_PRODUCTO");
        input.setValue( "" ); //1641
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_DESCPROD");
        input.setValue( "" ); //SEP_EFEC
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_CATEGORIA");
        input.setValue( "" );//
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_DESCCAT");
        input.setValue( "COMPE" );//
        inputParams.add( input );
                
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
       
        log.info( "Resurn Data :: " + returnData.toString() );
        
	}
}
