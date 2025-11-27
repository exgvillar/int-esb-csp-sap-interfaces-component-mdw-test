/**
 * 
 */
package com.consubanco.sap.interfaces.cxn.references;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author haydee.sanchez
 *
 */
public class ZCRMORI_P001_CREATE_BPRELACS_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMORI_P001_CREATE_BPRELACS_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMORI_P001_CREATE_BPRELACS_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMORI_P001_CREATE_BPRELACS_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMORI_P001_CREATE_BPRELACS_ProxyImpl proxy = new ZCRMORI_P001_CREATE_BPRELACS_ProxyImpl();
        
        ArrayList<ZTT_REFERENCIAS_OutputData> referenceList = new ArrayList<ZTT_REFERENCIAS_OutputData>();
        ZTT_REFERENCIAS_OutputData referenceData = new ZTT_REFERENCIAS_OutputData();
        referenceData.setClientId("1561228");
        referenceData.setReferenceId("12546");
        referenceData.setRelationshipType( "BUR001" );
        referenceData.setRelationshipCategory("ZC02");
        referenceData.setDescription("HERMANO (A)");
        referenceList.add( referenceData );
       
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, referenceList );
        
        log.info( returnData.toString() );
        
        
	}
}
