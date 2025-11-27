/**
 * 
 */
package com.consupago.sap.interfaces.proxy.formaliza;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.formalizacion.ZCRMTESO_GENERIC_OutputData;
import com.consupago.sap.interfaces.proxy.formalizacion.ZCRMTESO_P003_UPDATE_TABLE_ProxyImpl;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author ramon.becerra
 *
 */
public class ZCRMTESO_P003_UPDATE_TABLE_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMTESO_P003_UPDATE_TABLE_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMTESO_P003_UPDATE_TABLE_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMTESO_P003_UPDATE_TABLE_ProxyImplTC(String name) {
		super(name);
	}

	public void testProxy( ) throws Exception {	
		CRMLocalConfigEnvironmentData.instance();
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        ZCRMTESO_P003_UPDATE_TABLE_ProxyImpl proxy = new ZCRMTESO_P003_UPDATE_TABLE_ProxyImpl();

        String[] arrSolic = 
        	"0050449952|0050449953|0050449956|0050449957|0050449960|0050449962|0050449964|0050449965|0050449985|0050450107|0050449970|0050449971|0050449973|0050449974|0050450069"
    .split("\\|");

        for (String lasolic : arrSolic) {
        	ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        	ProxyInputParameter input = new ProxyInputParameter();
        	input.setKey("IV_OBJECTID");
        	input.setValue( lasolic );
        	inputParams.add( input );
        	input = new ProxyInputParameter();
        	input.setKey("IV_ESTATUS");
        	input.setValue( "T" );
        	inputParams.add( input );
        	input = new ProxyInputParameter();
        	input.setKey("IV_MENSAJE");
        	input.setValue( "" );
        	inputParams.add( input );
        	
        	ZCRMTESO_GENERIC_OutputData output = proxy.executeRemoteFunction(destination, inputParams );
        	System.out.println("output::" + output.geteMessage() );
        	
        }
        
	}
}
