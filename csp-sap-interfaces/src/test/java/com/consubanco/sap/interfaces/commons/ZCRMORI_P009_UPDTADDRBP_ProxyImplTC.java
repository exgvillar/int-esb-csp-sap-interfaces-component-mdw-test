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
import com.consupago.sap.interfaces.proxy.ProxyInputParameterWithTable;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author haydee.sanchez
 *
 */
public class ZCRMORI_P009_UPDTADDRBP_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMORI_P009_UPDTADDRBP_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMORI_P009_UPDTADDRBP_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMORI_P009_UPDTADDRBP_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMORI_P009_UPDTADDRBP_ProxyImpl proxy = new ZCRMORI_P009_UPDTADDRBP_ProxyImpl();
        
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
        inputRecord.setKey("ADDRESS_ID");
        inputRecord.setValue( "5360068" ); // justificar ceros a la izq
        recordParams1.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("ADDRESS_TYPE");
        inputRecord.setValue( "XXDEFAULT" );
        recordParams1.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("ADDTYPE_DESC");
        inputRecord.setValue( "Direc.pral." );
        recordParams1.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("ADDRESS_TYPEVIA");
        inputRecord.setValue( "AV" );
        recordParams1.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("ADDTVIA_DESC");
        inputRecord.setValue( "AVENIDA" );
        recordParams1.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("STREET");
        inputRecord.setValue( "PASEO DE LA REFORMA" );
        recordParams1.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("INTERNALNUMBER"); 
        inputRecord.setValue( "PISO 12" );
        recordParams1.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("EXTERNALNUMBER");
        inputRecord.setValue( "2654" );
        recordParams1.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("ZIPCODE");
        inputRecord.setValue( "11950" );
        recordParams1.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("SUBURB");
        inputRecord.setValue( "LOMAS ALTAS" );
        recordParams1.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("SETTLEMENTTYPE");
        inputRecord.setValue( "CAL" );
        recordParams1.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("SETLTYPE_DESC");
        inputRecord.setValue( "Colonia" );
        recordParams1.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("TOWN");
        inputRecord.setValue( "MÉX. POB." );
        recordParams1.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("TOWNSHIP");
        inputRecord.setValue( "MIGUEL HIDALGO" );
        recordParams1.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("CITY");
        inputRecord.setValue( "DISTRITO FEDERAL" );
        recordParams1.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("STATE");
        inputRecord.setValue( "DF" );
        recordParams1.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("COUNTRY");
        inputRecord.setValue( "MX" );
        recordParams1.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("BETWEENSTREET");
        inputRecord.setValue( "CONSTITUYENTES" );
        recordParams1.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("ANDSTREET");
        inputRecord.setValue( "REFORMA" );
        recordParams1.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("TELFIJO");
        inputRecord.setValue( "50813390" );
        recordParams1.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("EXTENCI");
        inputRecord.setValue( "7615" );
        recordParams1.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("TELCELU");
        inputRecord.setValue( "5512345678" );
        recordParams1.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("TELFAX");
        inputRecord.setValue( "50813390" );
        recordParams1.add( inputRecord );
        inputRecord = new ProxyInputParameter();
        inputRecord.setKey("EXTFAX");
        inputRecord.setValue( "7616" );
        recordParams1.add( inputRecord );
        
        inputParams.getRecordParam().add( recordParams1 );
        

     // tableParams - record2
        ArrayList<ProxyInputParameter> recordParams2 = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter inputRecord2 = new ProxyInputParameter();
        inputRecord2.setKey("ADDRESS_ID");
        inputRecord2.setValue( "" ); 
        recordParams2.add( inputRecord2 );
        inputRecord2 = new ProxyInputParameter();
        inputRecord2.setKey("ADDRESS_TYPE");
        inputRecord2.setValue( "ALTER_TO" );
        recordParams2.add( inputRecord2 );
        inputRecord2 = new ProxyInputParameter();
        inputRecord2.setKey("ADDTYPE_DESC");
        inputRecord2.setValue( "Dirección Alter" );
        recordParams2.add( inputRecord2 );
        inputRecord2 = new ProxyInputParameter();
        inputRecord2.setKey("ADDRESS_TYPEVIA");
        inputRecord2.setValue( "AV" );
        recordParams2.add( inputRecord2 );
        inputRecord2 = new ProxyInputParameter();
        inputRecord2.setKey("ADDTVIA_DESC");
        inputRecord2.setValue( "AVENIDA" );
        recordParams2.add( inputRecord2 );
        inputRecord2 = new ProxyInputParameter();
        inputRecord2.setKey("STREET");
        inputRecord2.setValue( "SANTA FE" );
        recordParams2.add( inputRecord2 );
        inputRecord2 = new ProxyInputParameter();
        inputRecord2.setKey("INTERNALNUMBER"); 
        inputRecord2.setValue( "PISO 16" );
        recordParams2.add( inputRecord2 );
        inputRecord2 = new ProxyInputParameter();
        inputRecord2.setKey("EXTERNALNUMBER");
        inputRecord2.setValue( "241" );
        recordParams2.add( inputRecord2 );
        inputRecord2 = new ProxyInputParameter();
        inputRecord2.setKey("ZIPCODE");
        inputRecord2.setValue( "01190" );
        recordParams2.add( inputRecord2 );
        inputRecord2 = new ProxyInputParameter();
        inputRecord2.setKey("SUBURB");
        inputRecord2.setValue( "SANTA FE" );
        recordParams2.add( inputRecord2 );
        inputRecord2 = new ProxyInputParameter();
        inputRecord2.setKey("SETTLEMENTTYPE");
        inputRecord2.setValue( "CAL" );
        recordParams2.add( inputRecord2 );
        inputRecord2 = new ProxyInputParameter();
        inputRecord2.setKey("SETLTYPE_DESC");
        inputRecord2.setValue( "Colonia" );
        recordParams2.add( inputRecord2 );
        inputRecord2 = new ProxyInputParameter();
        inputRecord2.setKey("TOWN");
        inputRecord2.setValue( "MÉXICO, POB." );
        recordParams2.add( inputRecord2 );
        inputRecord2 = new ProxyInputParameter();
        inputRecord2.setKey("TOWNSHIP");
        inputRecord2.setValue( "CUAJIMALPA" );
        recordParams2.add( inputRecord2 );
        inputRecord2 = new ProxyInputParameter();
        inputRecord2.setKey("CITY");
        inputRecord2.setValue( "DISTRITO FEDERAL" );
        recordParams2.add( inputRecord2 );
        inputRecord2 = new ProxyInputParameter();
        inputRecord2.setKey("STATE");
        inputRecord2.setValue( "DF" );
        recordParams2.add( inputRecord2 );
        inputRecord2 = new ProxyInputParameter();
        inputRecord2.setKey("COUNTRY");
        inputRecord2.setValue( "MX" );
        recordParams2.add( inputRecord2 );
        inputRecord2 = new ProxyInputParameter();
        inputRecord2.setKey("BETWEENSTREET");
        inputRecord2.setValue( "CONSTITUYENTES" );
        recordParams2.add( inputRecord2 );
        inputRecord2 = new ProxyInputParameter();
        inputRecord2.setKey("ANDSTREET");
        inputRecord2.setValue( "REFORMA" );
        recordParams2.add( inputRecord2 );
        inputRecord2 = new ProxyInputParameter();
        inputRecord2.setKey("TELFIJO");
        inputRecord2.setValue( "91777928" );
        recordParams2.add( inputRecord2 );
        inputRecord2 = new ProxyInputParameter();
        inputRecord2.setKey("EXTENCI");
        inputRecord2.setValue( "7924" );
        recordParams2.add( inputRecord2 );
        inputRecord2 = new ProxyInputParameter();
        inputRecord2.setKey("TELCELU");
        inputRecord2.setValue( "5512345678" );
        recordParams2.add( inputRecord2 );
        inputRecord2 = new ProxyInputParameter();
        inputRecord2.setKey("TELFAX");
        inputRecord2.setValue( "50813390" );
        recordParams2.add( inputRecord2 );
        inputRecord2 = new ProxyInputParameter();
        inputRecord2.setKey("EXTFAX");
        inputRecord2.setValue( "7616" );
        recordParams2.add( inputRecord2 );
        
        inputParams.getRecordParam().add( recordParams2 );

        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams );
        
        log.info( returnData.toString() );
        
        
	}
}
