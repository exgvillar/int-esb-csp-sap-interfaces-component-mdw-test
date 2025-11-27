/**
 * 
 */
package com.consubanco.sap.interfaces.cobranza.requests;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.cobranza.requests.ZCRMCOB_INFO_COMP_ProxyImpl;
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
public class ZCRMCOB_INFO_COMP_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMCOB_INFO_COMP_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMCOB_INFO_COMP_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMCOB_INFO_COMP_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMCOB_INFO_COMP_ProxyImpl proxy = new ZCRMCOB_INFO_COMP_ProxyImpl();
        
        ProxyInputParameterWithTable inputParams = new ProxyInputParameterWithTable();
        inputParams.setGeneralParam( new ArrayList<ProxyInputParameter>() );
        inputParams.setRecordParam( new ArrayList<Object>() );
        // general Params
        ProxyInputParameter input = new ProxyInputParameter();
//        input.setKey("I_BP");
//        input.setValue( "0000578005" );
        inputParams.getGeneralParam().add( input );
        
        // tableParams - record1
        ArrayList<ProxyInputParameter> recordParams1 = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter inputRecord = new ProxyInputParameter();

        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("ZCUENTA");
        inputRecord.setValue( "0004361024" );
        recordParams1.add( inputRecord );
        inputParams.getRecordParam().add( recordParams1 );
        
        recordParams1 = new ArrayList<ProxyInputParameter>();
		inputRecord = new ProxyInputParameter();
		inputRecord.setKey("ZCUENTA");
		inputRecord.setValue( "0001610893" );
//		recordParams1.add( inputRecord );

        inputParams.getRecordParam().add( recordParams1 );

        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
