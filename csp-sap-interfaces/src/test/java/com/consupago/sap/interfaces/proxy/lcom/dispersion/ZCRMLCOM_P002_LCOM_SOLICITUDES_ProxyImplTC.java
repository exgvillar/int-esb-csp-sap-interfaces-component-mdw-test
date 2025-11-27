/**
 * 
 */
package com.consupago.sap.interfaces.proxy.lcom.dispersion;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.ProxyInputParameterWithTable;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author ramon.becerra
 *
 */
public class ZCRMLCOM_P002_LCOM_SOLICITUDES_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMLCOM_P002_LCOM_SOLICITUDES_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMLCOM_P002_LCOM_SOLICITUDES_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMLCOM_P002_LCOM_SOLICITUDES_ProxyImplTC(String name) {
		super(name);
	}

	public void testExecute( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMLCOM_P002_LCOM_SOLICITUDES_ProxyImpl proxy = new ZCRMLCOM_P002_LCOM_SOLICITUDES_ProxyImpl();
        ProxyInputParameterWithTable inputParams = new ProxyInputParameterWithTable();
        inputParams.setRecordParam( new ArrayList<Object>() );
         ArrayList<String> arrSolic = new ArrayList<String>();
//         arrSolic.add("0050383481");
         arrSolic.add("0050384049");
//         arrSolic.add("0050383974");
//         arrSolic.add("0050382865");
//         arrSolic.add("0050382228");
//         arrSolic.add("0050382090");
//         arrSolic.add("0050381029");
//         arrSolic.add("0050384715");
//         arrSolic.add("0050384714");
//         arrSolic.add("0050384692");
//         arrSolic.add("0050384680"); 

        for (String solicitud : arrSolic) {
        	ArrayList<ProxyInputParameter> recordParams1 = new ArrayList<ProxyInputParameter>();
            ProxyInputParameter inputRecord = new ProxyInputParameter();
            inputRecord.setKey("ZOBJECT_ID");
            inputRecord.setValue( solicitud ); // justificar ceros a la izq
            recordParams1.add( inputRecord );
            inputParams.getRecordParam().add( recordParams1 );
		}
        Long inicio = System.currentTimeMillis();
        System.out.println(destination.getClient() );
        ArrayList<ZCRMLCOM_P002_LCOM_SOLICITUDES_OutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        for (ZCRMLCOM_P002_LCOM_SOLICITUDES_OutputData zcrmlcomP002LCOMSOLICITUDESOutputData : returnData) {
        	System.out.println("=======================================");
			System.out.println(zcrmlcomP002LCOMSOLICITUDESOutputData.toString());
		}
        Long fin = System.currentTimeMillis();
//        System.out.println("returnData: " + returnData.size() );
        System.out.println("tiempo: "+ (fin-inicio)/1000 );
	}
}
