/**
 * 
 */
package com.consupago.sap.interfaces.proxy.commons.utils;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.common.utils.ZGET_DISTRIBUIDOR_OutputData;
import com.consupago.sap.interfaces.proxy.common.utils.ZGET_DISTRIBUIDOR_ProxyImpl;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author ramon.becerra
 *
 */
public class ZGET_DISTRIBUIDOR_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZGET_DISTRIBUIDOR_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZGET_DISTRIBUIDOR_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZGET_DISTRIBUIDOR_ProxyImplTC(String name) {
		super(name);
	}

	public void testExecute( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZGET_DISTRIBUIDOR_ProxyImpl proxy = new ZGET_DISTRIBUIDOR_ProxyImpl();
        
        String idSolic = "0050366299";
        String tipoDoc = "ZCSP";
        
        Long inicio = System.currentTimeMillis();

        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_SOLICITUD");
        input.setValue(idSolic );
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("I_TIPDOC");
        input.setValue( tipoDoc );
        inputParams.add( input );
            
        ArrayList<ZGET_DISTRIBUIDOR_OutputData> arrSalida = proxy.executeRemoteFunction(destination, inputParams );
			

        Long fin = System.currentTimeMillis();
        log.info(arrSalida.size() +":\n"+ arrSalida.toString());
        System.out.println("tiempo: "+ (fin-inicio)/1000 );
	}
}
