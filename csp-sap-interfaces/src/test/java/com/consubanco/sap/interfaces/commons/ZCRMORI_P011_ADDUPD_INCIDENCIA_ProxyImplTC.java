/**
 * 
 */
package com.consubanco.sap.interfaces.commons;

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
 * @author haydee.sanchez
 *
 */
public class ZCRMORI_P011_ADDUPD_INCIDENCIA_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMORI_P011_ADDUPD_INCIDENCIA_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMORI_P011_ADDUPD_INCIDENCIA_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMORI_P011_ADDUPD_INCIDENCIA_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMORI_P011_ADDUPD_INCIDENCIA_ProxyImpl proxy = new ZCRMORI_P011_ADDUPD_INCIDENCIA_ProxyImpl();
        
        ProxyInputParameterWithTable inputParams = new ProxyInputParameterWithTable();
        
        inputParams.setRecordParam( new ArrayList<Object>() );
        // tableParams - record1 
        ArrayList<ProxyInputParameter> recordParams1 = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter inputRecord = new ProxyInputParameter();
        inputRecord.setKey("CVEUSO");
        inputRecord.setValue( "TC" ); // justificar ceros a la izq
        recordParams1.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("SOLICITUD");
        inputRecord.setValue( "0060000288" );
        recordParams1.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("CAUSA");
        inputRecord.setValue( "2" );
        recordParams1.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("MOTIVO");
        inputRecord.setValue( "1" );
        recordParams1.add( inputRecord );
        
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("INDREP");
        inputRecord.setValue( "X" );
        recordParams1.add( inputRecord );
        
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("FLG_RESUELTO");
        inputRecord.setValue( "" );
        recordParams1.add( inputRecord );
        
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("CONTADOR_BPM");
        inputRecord.setValue( "1" );
        recordParams1.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("DESC_INT");
        inputRecord.setValue( "INCONSISTENCIA EN FIRMA DEL IFE" );
        recordParams1.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("DESC_EXT"); 
        inputRecord.setValue( "INCONSISTENCIA EN FIRMAS" );
        recordParams1.add( inputRecord );
                
        inputParams.getRecordParam().add( recordParams1 );
      
        proxy.executeRemoteFunction( destination, inputParams );
        
                
	}
}
