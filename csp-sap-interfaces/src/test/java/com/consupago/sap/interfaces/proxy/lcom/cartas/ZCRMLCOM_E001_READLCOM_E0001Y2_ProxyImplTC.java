/**
 * 
 */
package com.consupago.sap.interfaces.proxy.lcom.cartas;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.ProxyInputParameterWithTable;
import com.consupago.sap.interfaces.proxy.lcom.cartas.ZCRMLCOM_E001_READLCOM_XSTATUS_OutputData.OrdenesServicio;
import com.consupago.sap.interfaces.proxy.lcom.dispersion.ZCRMLCOM_P002_LCOM_SOLICITUDES_OutputData;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author ramon.becerra
 *
 */
public class ZCRMLCOM_E001_READLCOM_E0001Y2_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMLCOM_E001_READLCOM_E0001Y2_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMLCOM_E001_READLCOM_E0001Y2_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMLCOM_E001_READLCOM_E0001Y2_ProxyImplTC(String name) {
		super(name);
	}

	public void testExecute( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        log.info("jco conection to server :" + destination.getProperties().getProperty("jco.client.ashost") + " at " + destination.getClient() );         
        
        ZCRMLCOM_E001_READLCOM_E0001Y2_ProxyImpl proxy = new ZCRMLCOM_E001_READLCOM_E0001Y2_ProxyImpl();
         ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
         ProxyInputParameter input = new ProxyInputParameter();
         input.setKey("I_STATUS");
         input.setValue( "E0031" );
         inputParams.add( input );

        Long inicio = System.currentTimeMillis();
        ArrayList<ZCRMLCOM_E001_READLCOM_XSTATUS_OutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        Long fin = System.currentTimeMillis();
        log.info("SIZE ARRAY::" + returnData.size() );
        for (ZCRMLCOM_E001_READLCOM_XSTATUS_OutputData zcrmlcomE001READLCOMXSTATUSOutputData : returnData) {
        	log.info("==============");
        	log.info(zcrmlcomE001READLCOMXSTATUSOutputData.toString() );
//        	ArrayList<OrdenesServicio> arrOs = zcrmlcomE001READLCOMXSTATUSOutputData.getOrdenesServicio();
//        	for (OrdenesServicio ordenesServicio : arrOs) {
//				log.info(ordenesServicio.toString());
//			}
		}
        
//        System.out.println("returnData: " + returnData.toString() );
        System.out.println("tiempo: "+ (fin-inicio)/1000 );
	}
}
