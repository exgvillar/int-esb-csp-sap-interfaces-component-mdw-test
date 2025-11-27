/**
 * 
 */
package com.consubanco.sap.interfaces.cxn.forms;

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
 * @author haydee.sanchez
 *
 */
public class ZCRMCV_E007_EXTRACTDATA_AB3_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMCV_E007_EXTRACTDATA_AB3_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMCV_E007_EXTRACTDATA_AB3_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMCV_E007_EXTRACTDATA_AB3_ProxyImplTC(String name) {
		super(name);
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMCV_E007_EXTRACTDATA_AB3_ProxyImpl proxy = new ZCRMCV_E007_EXTRACTDATA_AB3_ProxyImpl();
        
//        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
//        ProxyInputParameter input = new ProxyInputParameter();
//        input.setKey("ID_SOLICITUD");
//        input.setValue( "0040001122" );
//        inputParams.add( input );
        
        
        ProxyInputParameterWithTable inputParams = new ProxyInputParameterWithTable();
        inputParams.setGeneralParam( new ArrayList<ProxyInputParameter>() );
        inputParams.setRecordParam( new ArrayList<Object>() );
        
        // general Params
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_ID_SOLICITUD");
        input.setValue( "0040001122" );
        inputParams.getGeneralParam().add( input );
        
        // tableParams - record1
        ArrayList<ProxyInputParameter> recordParams1 = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter inputRecord = new ProxyInputParameter();

        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("ID_DOCTO");
        inputRecord.setValue( "72" );
        recordParams1.add( inputRecord );
        
//        inputRecord = new ProxyInputParameter();
//        inputRecord.setKey("ID_DOCTO");
//        inputRecord.setValue( "170" );
//        recordParams1.add( inputRecord );
        
        inputParams.getRecordParam().add( recordParams1 );
        
     // tableParams - record2
        ArrayList<ProxyInputParameter> recordParams2 = new ArrayList<ProxyInputParameter>();
//        ProxyInputParameter inputRecord2 = new ProxyInputParameter();

        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("ID_DOCTO");
        inputRecord.setValue( "71" );
        recordParams2.add( inputRecord );
        inputParams.getRecordParam().add( recordParams2 );
        
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
