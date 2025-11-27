/**
 * 
 */
package com.consubanco.sap.interfaces.common.geolocalization;

import java.sql.Date;
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
public class ZGEO_P001_SAVEGEOLOCALIZATION_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZGEO_P001_SAVEGEOLOCALIZATION_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZGEO_P001_SAVEGEOLOCALIZATION_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZGEO_P001_SAVEGEOLOCALIZATION_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZGEO_P001_SAVEGEOLOCALIZATION_ProxyImpl proxy = new  ZGEO_P001_SAVEGEOLOCALIZATION_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        
        input.setKey("I_BP");
        input.setValue( "0000000142" ); 
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_TIPOOPERACIONID");
        input.setValue( "1001" );
        inputParams.add( input );  
        input = new ProxyInputParameter();
        input.setKey("I_CANALID");
        input.setValue( "BKY" );
        inputParams.add( input );  
        input = new ProxyInputParameter();
        input.setKey("I_GEODATE");
        input.setType("java.util.Date");
        input.setDateValue(  Date.valueOf("2021-07-03")  );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_GEOHOUR");
        input.setValue( "16:17:21" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_LATITUD");
        input.setValue( "345.4567890" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_LONGITUD");
        input.setValue( "8.234567" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_IPADDRESS");
        input.setValue( "172.0.0.1" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_DEVICEINFO");
        input.setValue( "IOS" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_CUSTOMNAME1");
        input.setValue( "folio-solicitud" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_CUSTOMVALUE1");
        input.setValue( "0090102569" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_CUSTOMNAME2");
        input.setValue( "session-id" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_CUSTOMVALUE2");
        input.setValue( "005056B325DB1EEBB6BD9C7EFD1582ED" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_CUSTOMNAME3");
        input.setValue( "clave-rastreo" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("I_CUSTOMVALUE3");
        input.setValue( "2021063012565" );
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
       
        log.info( "Resurn Data :: " + returnData.toString() );
        
	}
}
