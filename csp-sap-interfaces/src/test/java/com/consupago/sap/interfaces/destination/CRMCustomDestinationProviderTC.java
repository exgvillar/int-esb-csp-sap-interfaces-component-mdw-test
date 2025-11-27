/**
 * 
 */
package com.consupago.sap.interfaces.destination;

import java.util.Properties;

import junit.framework.TestCase;

import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.ext.DestinationDataProvider;

/**
 * @author ramon.becerra
 *
 */
public class CRMCustomDestinationProviderTC extends TestCase {

	public void testDestination( ) throws Exception {
		Properties connectProperties = new Properties();
        connectProperties.setProperty(DestinationDataProvider.JCO_ASHOST, "192.168.201.52");
        connectProperties.setProperty(DestinationDataProvider.JCO_SYSNR,  "00");
        connectProperties.setProperty(DestinationDataProvider.JCO_CLIENT, "150");
        connectProperties.setProperty(DestinationDataProvider.JCO_USER,   "RFCUSRCC");
        connectProperties.setProperty(DestinationDataProvider.JCO_PASSWD, "Santafe1");
        connectProperties.setProperty(DestinationDataProvider.JCO_LANG,   "en");
        connectProperties.setProperty(DestinationDataProvider.JCO_POOL_CAPACITY, "3");
        connectProperties.setProperty(DestinationDataProvider.JCO_PEAK_LIMIT,    "10");

//        CRMCustomDestinationProvider myProvider = new CRMCustomDestinationProvider();
        
//        com.sap.conn.jco.ext.Environment.registerDestinationDataProvider( myProvider );
//        myProvider.changePropertiesForABAP_AS(connectProperties);
        
        JCoDestination ABAP_AS = JCoDestinationManager.getDestination("CSPSAPCRM");
        ABAP_AS.ping();

        System.out.println("CSPSAPCRM destination is ok");
        
        System.out.println("Attributes:");
        System.out.println(ABAP_AS.getAttributes());
        System.out.println();
        
	}
	
}
