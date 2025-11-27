/**
 * 
 */
package com.consubanco.sap.interfaces.dispersion;

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
public class ZCRMTESO_DISPERSION_DUP_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMTESO_DISPERSION_DUP_ProxyImplTC.class );
	
	String sol[] = {
			"0051044035",
			"0051043415",
			"0051043497",
			"0051043387",
			"0051043536",	
			"0051043354",
			"0051043779",
			"0051043811",
			"0051043785",
			"0051043342",
			"0051043705",
			"0051043622",
			"0051043701",
			"0051043885",
			"0051043812",
			"0051043848",
			"0051043753",
			"0051042745",
			"0051043507",
			"0051043150",
			"0051043808",
			"0051043813",
			"0051043405",
			"0051043676",
			"0051043335",
			"0051043934",
			"0051043163",
			"0051043903",
			"0051043651",
			"0051043630",
			"0051043561",
			"0051043834",
			"0051043802",
			"0051043771",
			"0051043943",
			"0051043959",
			"0051043653",
			"0051044025",
			"0051043836",
			"0051043863",
			"0051043926",
			"0051043386",
			"0051044015",
			"0051043823",
			"0051043888",
			"0051043240",
			"0051044056",
			"0051043842",
			"0051043877",
			"0051043953",
			"0051043696",
			"0051043893",
			"0051043849",
			"0051043397",
			"0051043798",
			"0051043917",
			"0051042908",
			"0051043166",
			"0051043780",
			"0051034255",
			"0051043781",
			"0051043955",
			"0051043314",
			"0051043417",
			"0051044144",
			"0051043828",
			"0051043873",
			"0051043913",
			"0051043962",
			"0051043830",
			"0051043814",
			"0051043899",
			"0051043769",
			"0051043797",
			"0051043409",
			"0051043366",
			"0051043786",
			"0051043901",
			"0051043554",
			"0051043634",
			"0051043393",
			"0051043861",
			"0051043990",
			"0051043568",
			"0051043394",
			"0051043788",
			"0051043789",
			"0051043875",
			"0051043936",
			"0051043904",
			"0051044009",
			"0051043777",
			"0051043876",
			"0051043919",
			"0051043816",
			"0051044016",
			"0051044156",
			"0051044197",
			"0051043822"
	};
	
	/**
	 * 
	 */
	public ZCRMTESO_DISPERSION_DUP_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMTESO_DISPERSION_DUP_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        for(int i=0; i<sol.length; i++){
        	ZCRMTESO_DISPERSION_DUP_ProxyImpl proxy = new ZCRMTESO_DISPERSION_DUP_ProxyImpl();
            
            ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
            ProxyInputParameter input = new ProxyInputParameter();
            input.setKey("I_ID_DOCUMENTO");
            input.setValue( sol[i] );
            inputParams.add( input );
            input = new ProxyInputParameter();
            input.setKey("I_EVENTO");
            input.setValue( "DISPERSION_CLIENTE" );
            inputParams.add( input );
            input = new ProxyInputParameter();
            input.setKey("I_DELETE");
            input.setValue( "X" );
            inputParams.add( input );
            
            ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
            
            log.info( returnData.toString() );
        }
        
        
        
        
	}
}
