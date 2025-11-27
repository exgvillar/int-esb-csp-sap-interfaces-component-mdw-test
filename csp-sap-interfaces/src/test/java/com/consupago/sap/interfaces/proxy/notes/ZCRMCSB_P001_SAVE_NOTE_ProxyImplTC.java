/**
 * 
 */
package com.consupago.sap.interfaces.proxy.notes;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.ProxyInputParameterWithTable;
import com.consupago.sap.interfaces.proxy.common.utils.CRM_Notas_ID;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author ramon.becerra
 *
 */
public class ZCRMCSB_P001_SAVE_NOTE_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMCSB_P001_SAVE_NOTE_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMCSB_P001_SAVE_NOTE_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMCSB_P001_SAVE_NOTE_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

//	public void _testDestination( ) throws Exception {	
//		
//		
//        CRMLocalConfigEnvironmentData.instance();
//        
//        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
//        
//        ZCRMCSB_P001_SAVE_NOTE_ProxyImpl proxy = new ZCRMCSB_P001_SAVE_NOTE_ProxyImpl();
//        
//        ProxyInputParameterWithTable inputParams = new ProxyInputParameterWithTable();
//        inputParams.setGeneralParam( new ArrayList<ProxyInputParameter>() );
//        inputParams.setRecordParam( new ArrayList<Object>() );
//        // general Params
//        ProxyInputParameter input = new ProxyInputParameter();
//        input.setKey("I_DOCUMENT");
//        input.setValue( "50381640" );
//        inputParams.getGeneralParam().add( input );
//        
//        input = new ProxyInputParameter();
//        input.setKey("I_TEXT_ID");
//        input.setValue( CRM_Notas_ID.NOTA_CUENTA_DISPERSORA );
//        inputParams.getGeneralParam().add( input );
//        
//        
//        
//        // tableParams - record1
//        ArrayList<ProxyInputParameter> recordParams1 = new ArrayList<ProxyInputParameter>();
//        ProxyInputParameter inputRecord = new ProxyInputParameter();
//        inputRecord.setKey("TDFORMAT");
//        inputRecord.setValue( "0200002389" ); 
//        recordParams1.add( inputRecord );
//        inputParams.getRecordParam().add( recordParams1 );
//
//        recordParams1 = new ArrayList<ProxyInputParameter>();
//        inputRecord = new ProxyInputParameter();
//        inputRecord.setKey("TDLINE");
//        inputRecord.setValue( "0200002200" ); 
//        recordParams1.add( inputRecord );
//        inputParams.getRecordParam().add( recordParams1 );
//        
//           
//        proxy.executeRemoteFunction(destination, inputParams );
//	}


	public void testDestination()  throws Exception {
		CRMLocalConfigEnvironmentData.instance();

		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
		log.info("jco conection to server :"+ destination.getProperties().getProperty("jco.client.ashost")+ " at " + destination.getClient());

		ZCRMCSB_P001_SAVE_NOTE_ProxyImpl proxy = new ZCRMCSB_P001_SAVE_NOTE_ProxyImpl();
		
		ArrayList<String> notaValor = new ArrayList<String>();
		notaValor.add("0051088898|0007507823");
		notaValor.add("0051088906|0007507823");
		notaValor.add("0051088914|0007507823");
		notaValor.add("0051088920|0007507823");
		notaValor.add("0051088925|0007507823");
		notaValor.add("0051088938|0007507823");
		notaValor.add("0051088946|0007507823");
		notaValor.add("0051088955|0007507823");
		notaValor.add("0051088974|0007507823");
		notaValor.add("0051088987|0007507823");
		notaValor.add("0051089001|0007507823");
		notaValor.add("0051089011|0007507823");
		notaValor.add("0051089073|0007507823");
		notaValor.add("0051089080|0007507823");
		notaValor.add("0051089090|0007507823");
		notaValor.add("0051089150|0007507823");



		for (String cadena : notaValor) {
			String[] SolicCtaDisp = cadena.split("\\|");
			
	        ProxyInputParameterWithTable inputParams = new ProxyInputParameterWithTable();
	        inputParams.setGeneralParam( new ArrayList<ProxyInputParameter>() );
	        inputParams.setRecordParam( new ArrayList<Object>() );
	        // general Params
	        ProxyInputParameter input = new ProxyInputParameter();
	        input.setKey("I_DOCUMENT");
	        input.setValue( SolicCtaDisp[0] );
	        inputParams.getGeneralParam().add( input );
	        
	        input = new ProxyInputParameter();
	        input.setKey("I_TEXT_ID");
	        input.setValue( "ZS09" ); // cuenta dispersora 
	        inputParams.getGeneralParam().add( input );
	     
	        input = new ProxyInputParameter();
	        input.setKey("I_ACTIVITY");
	        input.setValue( "I" );
	        inputParams.getGeneralParam().add( input );
	        
	        // tableParams - record1
	        ArrayList<ProxyInputParameter> recordParams1 = new ArrayList<ProxyInputParameter>();
	        ProxyInputParameter inputRecord = new ProxyInputParameter();
	        inputRecord.setKey("TDLINE");
	        inputRecord.setValue( SolicCtaDisp[1] ); 
	        recordParams1.add( inputRecord );
//	        inputParams.getRecordParam().add( recordParams1 );

//	        recordParams1 = new ArrayList<ProxyInputParameter>();
	        inputRecord = new ProxyInputParameter();
	        inputRecord.setKey("TDFORMAT");
	        inputRecord.setValue( "1" ); 
	        recordParams1.add( inputRecord );
	        inputParams.getRecordParam().add( recordParams1 );

	        proxy.executeRemoteFunction(destination, inputParams );
		}
		
		

	
		
	}
}
