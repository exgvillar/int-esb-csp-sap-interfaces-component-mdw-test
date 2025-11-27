package com.consubanco.sap.interfaces.cav;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

public class ZCRMTTO_P001_CARGA_MASIVA_CAV_ProxyImpl_TC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMTTO_P001_CARGA_MASIVA_CAV_ProxyImpl_TC.class );
	
	/**
	 * 
	 */
	public ZCRMTTO_P001_CARGA_MASIVA_CAV_ProxyImpl_TC() {

	}

	/**
	 * @param name
	 */
	public ZCRMTTO_P001_CARGA_MASIVA_CAV_ProxyImpl_TC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMTTO_P001_CARGA_MASIVA_CAV_ProxyImpl proxy = new ZCRMTTO_P001_CARGA_MASIVA_CAV_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_BP");
        input.setValue( "0000123938" ); //0000123938
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("I_VALOR");
        input.setValue( "1" ); //1 NIVEL AZUL
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
       
        log.info( "Resurn Data :: " + returnData.toString() );
        
	}
}
