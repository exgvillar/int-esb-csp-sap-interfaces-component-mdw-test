/**
 * 
 */
package com.consubanco.sap.interfaces.bt;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.bt.model.ZESCRMBT_E002_INCIDENCIAS_Model;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author jrauluribes
 *
 */
public class ZCRMBT_P004_SAVE_INCIDENCIAS_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMBT_P004_SAVE_INCIDENCIAS_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMBT_P004_SAVE_INCIDENCIAS_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMBT_P004_SAVE_INCIDENCIAS_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMBT_P004_SAVE_INCIDENCIAS_ProxyImpl proxy = new ZCRMBT_P004_SAVE_INCIDENCIAS_ProxyImpl();
        
        List<ZESCRMBT_E002_INCIDENCIAS_Model> inputParams = new ArrayList<ZESCRMBT_E002_INCIDENCIAS_Model>();
        
        ZESCRMBT_E002_INCIDENCIAS_Model model = new ZESCRMBT_E002_INCIDENCIAS_Model();
       
        model.setDescExt("descExt");
        model.setDescInt("descInterna");
        model.setIdCausa("1");
        model.setIdIncidencia(1);
        model.setIdMotivo("20");
        model.setIdSolicitud("0000787122");
        model.setPhone("5554545478");
		inputParams.add( model );
		
		ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams  );
       
        log.info( "Resurn Data :: " + returnData.toString() );
        
	}
}
