/**
 * 
 */
package com.consubanco.sap.interfaces.massiveLoad;

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
public class ZCRMORIG_P003_DELETE_OPP_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMORIG_P003_DELETE_OPP_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMORIG_P003_DELETE_OPP_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMORIG_P003_DELETE_OPP_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMORIG_P003_DELETE_OPP_ProxyImpl proxy = new ZCRMORIG_P003_DELETE_OPP_ProxyImpl();
        
        ProxyInputParameterWithTable inputParams = new ProxyInputParameterWithTable();
        inputParams.setGeneralParam( new ArrayList<ProxyInputParameter>() );
        inputParams.setRecordParam( new ArrayList<Object>() );
        
        // tableParams - record1
        ArrayList<ProxyInputParameter> recordParams1 = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter inputRecord = new ProxyInputParameter();

        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("ZOBJECT_ID");
        inputRecord.setValue( "0046000040" );
        recordParams1.add( inputRecord );
        
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("ZOBJECT_ID");
        inputRecord.setValue( "0046000041" );
        recordParams1.add( inputRecord );
        
        inputParams.getRecordParam().add( recordParams1 );

        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
