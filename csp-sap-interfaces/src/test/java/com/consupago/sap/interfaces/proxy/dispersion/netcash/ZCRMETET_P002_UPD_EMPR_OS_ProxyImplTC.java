/**
 * 
 */
package com.consupago.sap.interfaces.proxy.dispersion.netcash;

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
public class ZCRMETET_P002_UPD_EMPR_OS_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMETET_P002_UPD_EMPR_OS_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMETET_P002_UPD_EMPR_OS_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMETET_P002_UPD_EMPR_OS_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMETET_P002_UPD_EMPR_OS_ProxyImpl proxy = new ZCRMETET_P002_UPD_EMPR_OS_ProxyImpl();
        
        ProxyInputParameterWithTable inputParams = new ProxyInputParameterWithTable();
        inputParams.setGeneralParam( new ArrayList<ProxyInputParameter>() );
        inputParams.setRecordParam( new ArrayList<Object>() );
        // general Params
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_EMP_RESP");
        input.setValue( "10002448" ); // BP para empleado responsable
        inputParams.getGeneralParam().add( input );
        
        // tableParams - record1
        ArrayList<ProxyInputParameter> recordParams1 = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter inputRecord = new ProxyInputParameter();
        inputRecord.setKey("ORDEN_SERV");
        inputRecord.setValue( "0200002389" ); 
        recordParams1.add( inputRecord );
        inputParams.getRecordParam().add( recordParams1 );

        recordParams1 = new ArrayList<ProxyInputParameter>();
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("ORDEN_SERV");
        inputRecord.setValue( "0200002200" ); 
        recordParams1.add( inputRecord );
        inputParams.getRecordParam().add( recordParams1 );
        
           
        ArrayList<ZCRMETET_P002_UPD_EMPR_OS_OutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
