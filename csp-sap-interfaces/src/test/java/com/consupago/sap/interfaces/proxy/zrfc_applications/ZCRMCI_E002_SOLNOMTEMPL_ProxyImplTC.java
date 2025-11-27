/**
 * 
 */
package com.consupago.sap.interfaces.proxy.zrfc_applications;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.ProxyInputParameterWithTable;
import com.consupago.sap.interfaces.proxy.applications.ZCRMCI_E002_SOLNOMTEMPL_ProxyImpl;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author haydee.sanchez
 *
 */
public class ZCRMCI_E002_SOLNOMTEMPL_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMCI_E002_SOLNOMTEMPL_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMCI_E002_SOLNOMTEMPL_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMCI_E002_SOLNOMTEMPL_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMCI_E002_SOLNOMTEMPL_ProxyImpl proxy = new ZCRMCI_E002_SOLNOMTEMPL_ProxyImpl();
        
        ProxyInputParameterWithTable inputParams = new ProxyInputParameterWithTable();
        inputParams.setGeneralParam( new ArrayList<ProxyInputParameter>() );
        inputParams.setRecordParam( new ArrayList<Object>() );
        // general Params
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_ACCION");
        input.setValue( "C" ); //'C' = Crear; 'D' = Borrar; 'V' = Visualizar
        inputParams.getGeneralParam().add( input );
        
        // tableParams - record1
        ArrayList<ProxyInputParameter> recordParams1 = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter inputRecord = new ProxyInputParameter();
        inputRecord.setKey("MANDT");
        inputRecord.setValue( "" ); 
        recordParams1.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("ZSOL_NOMINA");
        inputRecord.setValue( "0050004856" );
        recordParams1.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("ZTIPO_EMPL");
        inputRecord.setValue( "BASE" );
        recordParams1.add( inputRecord );
        
        
        inputParams.getRecordParam().add( recordParams1 );
        
           
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
