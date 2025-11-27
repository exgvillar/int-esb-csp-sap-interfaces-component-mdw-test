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
public class ZCRMORI_P012_ADDUPDATTRMKTG_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMORI_P012_ADDUPDATTRMKTG_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMORI_P012_ADDUPDATTRMKTG_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMORI_P012_ADDUPDATTRMKTG_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMORI_P012_ADDUPDATTRMKTG_ProxyImpl proxy = new ZCRMORI_P012_ADDUPDATTRMKTG_ProxyImpl();
        
        ProxyInputParameterWithTable inputParams = new ProxyInputParameterWithTable();
        inputParams.setGeneralParam( new ArrayList<ProxyInputParameter>() );
        inputParams.setRecordParam( new ArrayList<Object>() );
        // general Params
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_BP");
        input.setValue( "0000000142" );
        inputParams.getGeneralParam().add( input );
        
        // tableParams - record1
        ArrayList<ProxyInputParameter> recordParams1 = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter inputRecord = new ProxyInputParameter();
        inputRecord.setKey("PARTNER");
        inputRecord.setValue( "0000000142" );
        recordParams1.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("GRUPO_ATRIBUTOS");
        inputRecord.setValue( "Z_MKT_TIPO_PROP" );
        recordParams1.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("DESCR_GRUPOATT");
        inputRecord.setValue( "Tipo de Propiedad" );
        recordParams1.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("CLAVE_ATRIBUTO");
        inputRecord.setValue( "Z_MKT_ANIOS_RES" );
        recordParams1.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("VALOR_ATRIBUTO");
        inputRecord.setValue( "7" );
        recordParams1.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("DESCR_ATRIBUTO");
        inputRecord.setValue( "" );
        recordParams1.add( inputRecord );
        
        inputParams.getRecordParam().add( recordParams1 );
        
        
        boolean returnResult= proxy.executeRemoteFunction( destination, inputParams );
          
        log.info( "Resultado >>> " + returnResult );
        assertEquals(true, returnResult);
        
        
	}
}
