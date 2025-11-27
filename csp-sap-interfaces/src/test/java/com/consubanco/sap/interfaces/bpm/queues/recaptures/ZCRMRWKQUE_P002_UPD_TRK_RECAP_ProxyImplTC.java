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
public class ZCRMRWKQUE_P002_UPD_TRK_RECAP_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMRWKQUE_P002_UPD_TRK_RECAP_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMRWKQUE_P002_UPD_TRK_RECAP_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMRWKQUE_P002_UPD_TRK_RECAP_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMRWKQUE_P002_UPD_TRK_RECAP_ProxyImpl proxy = new ZCRMRWKQUE_P002_UPD_TRK_RECAP_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_INDICE");
        input.setValue( "" ); 
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_NUM_SOLICITUD");
        input.setValue( "0050385535" ); 
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_USER_CAP_ERROR");
        input.setValue( "" ); //marroyo 
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_USER_REPORT");
        input.setValue( "" ); //authcoxpol 
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_ROL_REPORT");
        input.setValue( "" ); //AUTORIZACION 
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_USER_CAP_RESOL");
        input.setValue( "brasso" ); //brasso
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
       
        log.info( "Resurn Data :: " + returnData.toString() );
        
	}
}
