/**
 * 
 */
package com.consupago.sap.interfaces.proxy.lcom.cartas;

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
public class ZCRMLCOM_P007_SET_INCIDENCES_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMLCOM_P007_SET_INCIDENCES_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMLCOM_P007_SET_INCIDENCES_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMLCOM_P007_SET_INCIDENCES_ProxyImplTC(String name) {
		super(name);
	}

	public void testExecute( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMLCOM_P007_SET_INCIDENCES_ProxyImpl proxy = new ZCRMLCOM_P007_SET_INCIDENCES_ProxyImpl();
        ProxyInputParameterWithTable inputParams = new ProxyInputParameterWithTable();
        inputParams.setRecordParam( new ArrayList<Object>() );
        
        ArrayList<ProxyInputParameter> recordParams1 = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter inputRecord = new ProxyInputParameter();
        inputRecord.setKey("ID_NUMDOC");
        inputRecord.setValue( "0050096561" );
        recordParams1.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("ID_TIPDOC");
        inputRecord.setValue( "0050096561" );
        recordParams1.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("ID_CAUSA");
        inputRecord.setValue( "0050096561" );
        recordParams1.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("ID_MOTIVO");
        inputRecord.setValue( "0050096561" );
        recordParams1.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("CONTADOR_BPM");
        inputRecord.setValue( "0050096561" );
        recordParams1.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("DESC_INT");
        inputRecord.setValue( "0050096561" );
        recordParams1.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("DESC_EXT");
        inputRecord.setValue( "0050096561" );
        recordParams1.add( inputRecord );
        
        inputParams.getRecordParam().add( recordParams1 );
        
        Long inicio = System.currentTimeMillis();
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        Long fin = System.currentTimeMillis();
        System.out.println("returnData: " + returnData.toString() );
        System.out.println("tiempo: "+ (fin-inicio)/1000 );
	}
}
