/**
 * 
 */
package com.consubanco.sap.interfaces.commons;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.ProxyInputParameterWithTable;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author omar.corona
 *
 */
public class ZCRMCSB_P001_UPDTADDRBP_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMCSB_P001_UPDTADDRBP_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMCSB_P001_UPDTADDRBP_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMCSB_P001_UPDTADDRBP_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMCSB_P001_UPDTADDRBP_ProxyImpl proxy = new ZCRMCSB_P001_UPDTADDRBP_ProxyImpl();
        
        ProxyInputParameterWithTable inputParams = new ProxyInputParameterWithTable();
        inputParams.setGeneralParam( new ArrayList<ProxyInputParameter>() );
        inputParams.setRecordParam( new ArrayList<Object>() );
        // general Params
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_BP");
        input.setValue( "0000578005" );
        inputParams.getGeneralParam().add( input );
        
        // tableParams - record1
        ArrayList<ProxyInputParameter> recordParams1 = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter inputRecord = new ProxyInputParameter();

        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("ADDRESS_TYPE");
        inputRecord.setValue( "ZDIRBAD" );
        recordParams1.add( inputRecord );
        
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("TELCELU");
        inputRecord.setValue( "5556713245" );
        recordParams1.add( inputRecord );

        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("EMAIL");
        inputRecord.setValue( "julius.rugeiro@gmail.com.mx" );
        recordParams1.add( inputRecord );
        
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("COUNTRY");
        inputRecord.setValue( "MX" );
        recordParams1.add( inputRecord );
        
        inputParams.getRecordParam().add( recordParams1 );

        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
