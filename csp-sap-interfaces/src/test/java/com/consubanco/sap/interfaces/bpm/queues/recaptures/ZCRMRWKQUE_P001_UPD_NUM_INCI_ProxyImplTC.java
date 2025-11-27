/**
 * 
 */
package com.consubanco.sap.interfaces.bpm.queues.recaptures;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.bpm.queues.models.ZM_INC_RECAP_Model;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author haydee.sanchez
 *
 */
public class ZCRMRWKQUE_P001_UPD_NUM_INCI_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMRWKQUE_P001_UPD_NUM_INCI_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMRWKQUE_P001_UPD_NUM_INCI_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMRWKQUE_P001_UPD_NUM_INCI_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMRWKQUE_P001_UPD_NUM_INCI_ProxyImpl proxy = new ZCRMRWKQUE_P001_UPD_NUM_INCI_ProxyImpl();
        
        ZCRMRWKQUE_P001_UPD_NUM_INCI_OutputData inputParams = new ZCRMRWKQUE_P001_UPD_NUM_INCI_OutputData();
        ArrayList<ZM_INC_RECAP_Model> incidencesList = new ArrayList<ZM_INC_RECAP_Model>();
        
        ZM_INC_RECAP_Model incidence = new ZM_INC_RECAP_Model();
        incidence.setIncidenceNumber( 1 );
        incidence.setFolioApplication( "0050383985" );
        incidence.setCause( "OTROC" );
        incidence.setMotive( "OTROM" );
        incidence.setGeneralDescription("error la captura del RFC");
        incidence.setResolve( false );
        incidencesList.add( incidence );
                
        incidence = new ZM_INC_RECAP_Model();
        incidence.setIncidenceNumber( 2 );
        incidence.setFolioApplication( "0050383985" );
        incidence.setCause( "OTROC1" );
        incidence.setMotive( "OTROM2" );
        incidence.setGeneralDescription("error la captura del Nombre");
        incidence.setResolve( true );
        incidencesList.add( incidence );
        
        inputParams.setIncidences( incidencesList );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
       
        log.info( "Resurn Data :: " + returnData.toString() );
        
	}
}
