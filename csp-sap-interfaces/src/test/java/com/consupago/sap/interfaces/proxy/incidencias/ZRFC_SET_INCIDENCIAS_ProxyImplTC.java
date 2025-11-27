/**
 * 
 */
package com.consupago.sap.interfaces.proxy.incidencias;

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
public class ZRFC_SET_INCIDENCIAS_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZRFC_SET_INCIDENCIAS_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZRFC_SET_INCIDENCIAS_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZRFC_SET_INCIDENCIAS_ProxyImplTC(String name) {
		super(name);
	}

	public void testExecute( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZRFC_SET_INCIDENCIAS_ProxyImpl proxy = new ZRFC_SET_INCIDENCIAS_ProxyImpl();
        ProxyInputParameterWithTable inputParams = new ProxyInputParameterWithTable();
        inputParams.setRecordParam( new ArrayList<Object>() );
        
        ArrayList<ProxyInputParameter> recordParams1 = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter inputRecord = new ProxyInputParameter();
        inputRecord.setKey("Z_SOLICITUD");
        inputRecord.setValue( "0050453943" );
        recordParams1.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("Z_CAUSA");
        inputRecord.setValue( "15" );
        recordParams1.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("Z_MOTIVO");
        inputRecord.setValue( "54" );
        recordParams1.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("Z_CONTADOR_BPM");
        inputRecord.setValue( "2" );
        recordParams1.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("Z_DESC_INT");
        inputRecord.setValue( "" );
        recordParams1.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("Z_DESC_EXT");
        inputRecord.setValue( "" );
        recordParams1.add( inputRecord );
        
        
        inputParams.getRecordParam().add( recordParams1 );
        
        Long inicio = System.currentTimeMillis();
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        Long fin = System.currentTimeMillis();
        System.out.println("returnData: " + returnData.toString() );

	}
}
