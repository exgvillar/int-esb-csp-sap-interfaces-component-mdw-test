/**
 * 
 */
package com.consupago.sap.interfaces.proxy.imss.pensionados;

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
 * @author ramon.becerra
 *
 */
public class ZCRMORI_E003_GET_PRODSIMSSPENS_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMORI_E003_GET_PRODSIMSSPENS_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMORI_E003_GET_PRODSIMSSPENS_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMORI_E003_GET_PRODSIMSSPENS_ProxyImplTC(String name) {
		super(name);
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMORI_E003_GET_PRODSIMSSPENS_ProxyImpl proxy = new ZCRMORI_E003_GET_PRODSIMSSPENS_ProxyImpl();
        ProxyInputParameterWithTable inputParams = new ProxyInputParameterWithTable();
        inputParams.setRecordParam( new ArrayList<Object>() );

        // tableParams - record1
        ArrayList<ProxyInputParameter> recordParams1 = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter inputRecord = new ProxyInputParameter();
        inputRecord.setKey("PRODUCT_ID");
        inputRecord.setValue( "1027" ); // justificar ceros a la izq
        recordParams1.add( inputRecord );
        inputParams.getRecordParam().add( recordParams1 );

        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info(returnData.isEmpty() + "::"+ returnData.toString() );
        
        
	}
}
