/**
 * 
 */
package com.consupago.sap.interfaces.proxy.cotizador;

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
 * @author juribe
 *
 */
public class ZCRMTESO_TASA_AMORT_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMTESO_TASA_AMORT_ProxyImplTC.class );

	/**
	 * 
	 */
	public ZCRMTESO_TASA_AMORT_ProxyImplTC() {
		super();
	}

	/**
	 * @param name
	 */
	public ZCRMTESO_TASA_AMORT_ProxyImplTC(String name) {
		super(name);
	}
	
	
	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMTESO_TASA_AMORT_ProxyImpl proxy = new ZCRMTESO_TASA_AMORT_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_PROD");
//        input.setValue( "1701" );
        input.setValue( "487" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_MONTO");
        input.setValue( "40000.0" );
//        input.setValue( "14000.18" );
        input.setType("java.lang.Double");
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_NUMPAG");
//        input.setValue( "48" );
        input.setValue( "120" );
        input.setType("java.lang.Integer");
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("I_FREC");
        input.setValue( "Q" );
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("I_SOL");
        input.setValue( fillStringWithZerosOnLeft("12345",10) );
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
	
		public static String fillStringWithZerosOnLeft(String str, int toLength) {
			StringBuffer buffer = new StringBuffer();
			if (str.length() >= toLength)
				buffer.append(str);
			else {
				int j = str.length();
				for (int i = j; i < toLength; i++) {
					buffer.append("0");
				}
				buffer.append(str);
			}
			return (buffer.toString());
		}
	
}
