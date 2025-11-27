/**
 * 
 */
package com.consubanco.sap.interfaces.bpm.queues.generals;

import java.sql.Date;
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
public class ZCRMWKQUE_E011_MONITOR_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMWKQUE_E011_MONITOR_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMWKQUE_E011_MONITOR_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMWKQUE_E011_MONITOR_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMWKQUE_E011_MONITOR_ProxyImpl proxy = new ZCRMWKQUE_E011_MONITOR_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        //50384960
        input.setKey("I_FECHAINI");
        input.setDateValue( Date.valueOf("2017-10-16") ); //2016-12-01
        input.setType("java.util.Date");
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_FECHAFIN");
        input.setDateValue( Date.valueOf("2017-10-16") ); //2016-12-21
        input.setType("java.util.Date");
        inputParams.add( input );  
        input = new ProxyInputParameter();
        input.setKey("I_CONVENIO"); 
        input.setValue( "" ); //10000252
        inputParams.add( input );  
        input = new ProxyInputParameter();
        input.setKey("I_USUARIO");
        input.setValue( "" ); //BRANGEL
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_PRIORIDAD");
        input.setValue( "" ); //2
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_DESCPRIORI");
        input.setValue( "" ); //MEDIO
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
       
        log.info( "Resurn Data :: " + returnData.toString() );
        
	}
}
