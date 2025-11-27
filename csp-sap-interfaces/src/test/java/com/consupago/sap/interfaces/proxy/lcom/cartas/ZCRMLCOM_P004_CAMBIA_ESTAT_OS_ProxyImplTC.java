/**
 * 
 */
package com.consupago.sap.interfaces.proxy.lcom.cartas;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.ProxyInputParameterWithTable;
import com.consupago.sap.interfaces.proxy.formalizacion.ZCRMGEM_FORMALIZA_ProxyImpl;
import com.consupago.sap.interfaces.proxy.formalizacion.ZCRMTESO_E001_INFO_FORMALIZA_OutputData;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author ramon.becerra
 *
 */
public class ZCRMLCOM_P004_CAMBIA_ESTAT_OS_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMLCOM_P004_CAMBIA_ESTAT_OS_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMLCOM_P004_CAMBIA_ESTAT_OS_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMLCOM_P004_CAMBIA_ESTAT_OS_ProxyImplTC(String name) {
		super(name);
	}

	public void testDestination( ) throws Exception {	

		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMLCOM_P004_CAMBIA_ESTAT_OS_ProxyImpl proxy = new ZCRMLCOM_P004_CAMBIA_ESTAT_OS_ProxyImpl();

        ProxyInputParameterWithTable inputParams = new ProxyInputParameterWithTable();
        inputParams.setRecordParam( new ArrayList<Object>() );
        ArrayList<String> arrSolic = new ArrayList<String>();
        // aqui se adiciona al arreglo las solicitudes a ser cambiadas.
        arrSolic.add("0050604394");

        //        arrSolic.add("");
        log.info("tamano Arreglo::" + arrSolic.size() );
        
        for (String solicitud : arrSolic) {
        	ArrayList<ProxyInputParameter> recordParams1 = new ArrayList<ProxyInputParameter>();
            ProxyInputParameter inputRecord = new ProxyInputParameter();
            inputRecord.setKey("ZOBJECT_ID");
            inputRecord.setValue( solicitud ); // justificar ceros a la izq
            recordParams1.add( inputRecord );
            inputParams.getRecordParam().add( recordParams1 );
		}
        System.out.println(destination.getClient() );
        ArrayList<ZCRMLCOM_P004_CAMBIA_ESTAT_OS_OutputData> arrRet = proxy.executeRemoteFunction(destination, inputParams );
        
        for (ZCRMLCOM_P004_CAMBIA_ESTAT_OS_OutputData zcrmlcomP004CAMBIAESTATOSOutputData : arrRet) {
			System.out.println( zcrmlcomP004CAMBIAESTATOSOutputData.toString() );
		}

	}
}
