/**
 * 
 */
package com.consupago.sap.interfaces.proxy.dispersion.netcash;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.ProxyInputParameterWithTable;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author ramon.becerra
 *
 */
public class ZCRMTESO_P010_PROCESA600_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMTESO_P010_PROCESA600_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMTESO_P010_PROCESA600_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMTESO_P010_PROCESA600_ProxyImplTC(String name) {
		super(name);
	}

	public void testExecute( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMTESO_P010_PROCESA600_ProxyImpl proxy = new ZCRMTESO_P010_PROCESA600_ProxyImpl();

        Long inicio = System.currentTimeMillis();
        System.out.println(destination.getClient() );
        ArrayList<ZCRMTESO_P010_PROCESA600_OutputData> returnData = proxy.executeRemoteFunction(destination, null );
        
//        for (ZCRMTESO_P010_PROCESA600_OutputData outputData : returnData) {
//        	System.out.println("=======================================");
//			System.out.println(outputData.toString());
//		}
        Long fin = System.currentTimeMillis();
//        System.out.println("returnData: " + returnData.size() );
        System.out.println("tiempo: "+ (fin-inicio)/1000 );
	}
}
