/**
 * 
 */
package com.consupago.sap.interfaces.proxy.formaliza;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.common.utils.CRM_Estatus_Solicitudes;
import com.consupago.sap.interfaces.proxy.formalizacion.ZCRMCTEM_E001_SOLBYESTAT_ProxyImpl;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author ramon.becerra
 *
 */
public class ZCRMCTEM_E001_SOLBYESTAT_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMCTEM_E001_SOLBYESTAT_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMCTEM_E001_SOLBYESTAT_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMCTEM_E001_SOLBYESTAT_ProxyImplTC(String name) {
		super(name);
	}

	public void testDestination( ) throws Exception {	

		CRMLocalConfigEnvironmentData.instance();

		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");

		ZCRMCTEM_E001_SOLBYESTAT_ProxyImpl proxy = new ZCRMCTEM_E001_SOLBYESTAT_ProxyImpl();


		ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_ESTATUS");
        input.setValue(  CRM_Estatus_Solicitudes.ZCSP_CON_INCIDENCIA_DE_DISPERSION );
        inputParams.add( input );
        
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );


	}
}
