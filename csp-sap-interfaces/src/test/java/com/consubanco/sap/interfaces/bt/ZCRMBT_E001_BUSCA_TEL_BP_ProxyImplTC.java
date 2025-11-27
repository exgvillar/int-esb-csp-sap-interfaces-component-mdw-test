/**
 * 
 */
package com.consubanco.sap.interfaces.bt;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author haydee.sanchez
 *
 */
public class ZCRMBT_E001_BUSCA_TEL_BP_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMBT_E001_BUSCA_TEL_BP_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMBT_E001_BUSCA_TEL_BP_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMBT_E001_BUSCA_TEL_BP_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMBT_E001_BUSCA_TEL_BP_ProxyImpl proxy = new ZCRMBT_E001_BUSCA_TEL_BP_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_BP");
        input.setValue( "0000123938" ); //0000123938
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("I_RFC");
        input.setValue( "" ); //FOVY8208054I7
        inputParams.add( input );
        
        input = new ProxyInputParameter();//FOVY820805MTLLLN07
        input.setKey("I_CURP");
        input.setValue( "" ); 
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("I_PRIMER_NOMBRE");
        input.setValue( "" );  //YENITZE
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("I_SEGUNDO_NOMBRE");
        input.setValue( "" ); //ANALLELY
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("I_APELLIDO_PATERNO");
        input.setValue( "" );  //FLORES
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("I_APELLIDO_MATERNO");
        input.setValue( "" ); //VILLANUEVA
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
       
        log.info( "Resurn Data :: " + returnData.toString() );
        
	}
}
