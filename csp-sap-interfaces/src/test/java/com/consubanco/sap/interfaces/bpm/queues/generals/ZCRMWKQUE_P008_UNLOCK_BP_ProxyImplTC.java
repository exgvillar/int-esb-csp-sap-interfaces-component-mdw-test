/**
 * 
 */
package com.consubanco.sap.interfaces.bpm.queues.generals;

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
public class ZCRMWKQUE_P008_UNLOCK_BP_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMWKQUE_P008_UNLOCK_BP_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMWKQUE_P008_UNLOCK_BP_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMWKQUE_P008_UNLOCK_BP_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMWKQUE_P008_UNLOCK_BP_ProxyImpl proxy = new ZCRMWKQUE_P008_UNLOCK_BP_ProxyImpl();
        
        ProxyInputParameterWithTable inputParams = new ProxyInputParameterWithTable();
        inputParams.setGeneralParam( new ArrayList<ProxyInputParameter>() );
        inputParams.setRecordParam( new ArrayList<Object>() );
        
        // tableParams - record1
        ArrayList<ProxyInputParameter> recordParams1 = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter inputRecord = new ProxyInputParameter();
        inputRecord.setKey("ZBP");
        inputRecord.setValue( "0002600689" );
        recordParams1.add( inputRecord );
        inputParams.getRecordParam().add( recordParams1 );
        
        recordParams1 = new ArrayList<ProxyInputParameter>();
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("ZBP");
        inputRecord.setValue( "0002600686" );
        recordParams1.add( inputRecord );
        inputParams.getRecordParam().add( recordParams1 );

        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
