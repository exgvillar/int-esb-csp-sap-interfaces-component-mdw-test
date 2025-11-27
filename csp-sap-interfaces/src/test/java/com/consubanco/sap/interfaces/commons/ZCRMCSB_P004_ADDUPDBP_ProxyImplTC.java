/**
 * 
 */
package com.consubanco.sap.interfaces.commons;

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
public class ZCRMCSB_P004_ADDUPDBP_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMCSB_P004_ADDUPDBP_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMCSB_P004_ADDUPDBP_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMCSB_P004_ADDUPDBP_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMCSB_P004_ADDUPDBP_ProxyImpl proxy = new ZCRMCSB_P004_ADDUPDBP_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("BP_ID");
        input.setValue( "0002602935" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("CLIENTID");
        input.setValue( "0005070781" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("ROLLID");
        input.setValue( "ZFS005" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("GROUPID");
        input.setValue( "Z01" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("RFC");
        input.setValue( "JOSE720520M32" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("CURP");
        input.setValue( "JOSE720520MDFSNT03" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("NAME1");
        input.setValue( "ANDRES" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("NAME2");
        input.setValue( "MANUEL" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("LASTNAME1");
        input.setValue( "RAMME" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("LASTNAME2");
        input.setValue( "CRUZAT" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("NAMECOMPANY");
        input.setValue( "" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("DATEBIRTH");
        input.setValue( "" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("PLACEBIRTH");
        input.setValue( "Hidalgo" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("COUNTRYBIRTH");
        input.setValue( "" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("NATIONALITY");
        input.setValue( "MX" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("DESCNATION");
        input.setValue( "MEXICANA" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("MARITALSTATUS");
        input.setValue( "1" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("DESCMARITALST");
        input.setValue( "SOLTERO" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("EMAIL");
        input.setValue( "" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("LEGALENTITY");
        input.setValue( "" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("GENDER");
        input.setValue( "M" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("LEVELSTUDIES");
        input.setValue( "0001" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("DESCLEVESTUD");
        input.setValue( "Doctor" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("DATECREATE");
        input.setValue( "" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("FIEL");
        input.setValue( "" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("ES_CLIENTE");
        input.setValue( "X" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("DEP_ECONOMIC");
        input.setValue( "0" );
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("EDADES_HIJOS");
        input.setValue( "" );
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("HABIT_HOGAR");
        input.setValue( "0" );
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("RESIDENCECOUNTRY");
        input.setValue( "MX" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("IDENTIFICATIONTYPE");
        input.setValue( "ZCPRO" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("IDENTIFICATIONNUMBER");
        input.setValue( "9517563" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("COUNTRY_ASSFISC");
        input.setValue( "AR" );
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("IDENTIFICATIONTYPE2");
        input.setValue( "FS0002" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("IDENTIFICATIONNUMBER2");
        input.setValue( "34567890345678" );
        inputParams.add( input );

        input = new ProxyInputParameter();
        input.setKey("IDREGIMENFISCAL");
        input.setValue( "612" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("DESCREGIMENFISCAL");
        input.setValue( "Personas Físicas con Actividades Empresariales y Profesionales" );
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams, false );
       
        log.info( "Resurn Data :: " + returnData.toString() );
        
	}
}
