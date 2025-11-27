/**
 * 
 */
package com.consupago.sap.interfaces.proxy.lcom.dispersion;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.ProxyInputParameterWithTable;
import com.consupago.sap.interfaces.proxy.imss.pensionados.ZCRMORI_E003_GET_PRODSIMSSPENS_ProxyImpl;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author ramon.becerra
 *
 */
public class ZCRMLCOM_P001_PROCESA_LCOM_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMLCOM_P001_PROCESA_LCOM_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMLCOM_P001_PROCESA_LCOM_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMLCOM_P001_PROCESA_LCOM_ProxyImplTC(String name) {
		super(name);
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMLCOM_P001_PROCESA_LCOM_ProxyImpl proxy = new ZCRMLCOM_P001_PROCESA_LCOM_ProxyImpl();
        ProxyInputParameterWithTable inputParams = new ProxyInputParameterWithTable();
        inputParams.setRecordParam( new ArrayList<Object>() );

        // tableParams - record1
        // probar con solicitdues con estatus E0033, E0034 Y E0037.
        ArrayList<ProxyInputParameter> recordParams1 = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter inputRecord = new ProxyInputParameter();
        inputRecord.setKey("ZOBJECT_ID");
        inputRecord.setValue( "0050096561" ); // justificar ceros a la izq
        recordParams1.add( inputRecord );
//        inputParams.getRecordParam().add( recordParams1 );
//        inputRecord = new ProxyInputParameter();
//        inputRecord.setKey("ZOBJECT_ID");
//        inputRecord.setValue( "0050096294" ); // justificar ceros a la izq
//        recordParams1.add( inputRecord );

        inputParams.getRecordParam().add( recordParams1 );

        
//        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
//        log.info(returnData.isEmpty() + "::"+ returnData.toString() );
        
        
	}
}
