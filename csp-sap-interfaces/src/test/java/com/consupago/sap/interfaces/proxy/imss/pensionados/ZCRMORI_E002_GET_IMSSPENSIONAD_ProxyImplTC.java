/**
 * 
 */
package com.consupago.sap.interfaces.proxy.imss.pensionados;

import java.text.DecimalFormat;
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
public class ZCRMORI_E002_GET_IMSSPENSIONAD_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMORI_E002_GET_IMSSPENSIONAD_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMORI_E002_GET_IMSSPENSIONAD_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMORI_E002_GET_IMSSPENSIONAD_ProxyImplTC(String name) {
		super(name);
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMORI_E002_GET_IMSSPENSIONAD_ProxyImpl proxy = new ZCRMORI_E002_GET_IMSSPENSIONAD_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
//        input.setKey("I_NUMDOC");
//        input.setValue( "0050094980" );
//        inputParams.add( input );
        input.setKey("I_NUMACC");
        input.setValue( new DecimalFormat("0000000000").format(new Integer("2267514")) );
        inputParams.add( input );
        
        System.out.println(new DecimalFormat("0000000000").format(new Integer("2267514")));
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
