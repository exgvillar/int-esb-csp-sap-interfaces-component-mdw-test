package com.consubanco.sap.interfaces.recomendados;

import java.util.ArrayList;
import java.sql.Date;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author omar.corona
 *
 */
public class ZCRMRECO_P004_UPD_OS_X_REFEREN_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMRECO_P004_UPD_OS_X_REFEREN_ProxyImplTC.class );
	


	/**
	 * 
	 */
	public ZCRMRECO_P004_UPD_OS_X_REFEREN_ProxyImplTC() {
		
	}


	
	/**
	 * @param name
	 */
	public ZCRMRECO_P004_UPD_OS_X_REFEREN_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}


	
	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMRECO_P004_UPD_OS_X_REFEREN_ProxyImpl proxy = new ZCRMRECO_P004_UPD_OS_X_REFEREN_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_REFERE");
        input.setValue( "201506091525000108" );
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("I_STATUS");
        input.setValue( "E0010" );
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("I_FECOBR");
        input.setType("java.util.date");
        input.setDateValue(Date.valueOf("2015-06-09"));
        inputParams.add( input );

        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );

	}
}
