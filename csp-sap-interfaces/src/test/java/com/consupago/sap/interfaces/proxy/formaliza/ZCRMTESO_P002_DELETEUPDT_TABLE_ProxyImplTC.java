/**
 * 
 */
package com.consupago.sap.interfaces.proxy.formaliza;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.formalizacion.ZCRMTESO_GENERIC_OutputData;
import com.consupago.sap.interfaces.proxy.formalizacion.ZCRMTESO_P002_DELETEUPDT_TABLE_ProxyImpl;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author ramon.becerra
 *
 */
public class ZCRMTESO_P002_DELETEUPDT_TABLE_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMTESO_P002_DELETEUPDT_TABLE_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMTESO_P002_DELETEUPDT_TABLE_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMTESO_P002_DELETEUPDT_TABLE_ProxyImplTC(String name) {
		super(name);
	}

	public void testProxy( ) throws Exception {	
		CRMLocalConfigEnvironmentData.instance();
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        ZCRMTESO_P002_DELETEUPDT_TABLE_ProxyImpl proxy = new ZCRMTESO_P002_DELETEUPDT_TABLE_ProxyImpl();

        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("IV_OBJECTID");
        input.setValue( "0050362073" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("IV_ACCOUNTID");
        input.setValue( "0000009999" );
        inputParams.add( input );
       
        ZCRMTESO_GENERIC_OutputData output = proxy.executeRemoteFunction(destination, inputParams );
        System.out.println("output::" + output.geteMessage() );
	}
}
