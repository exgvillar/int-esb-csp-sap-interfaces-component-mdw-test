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
import com.consupago.sap.interfaces.proxy.ProxyInputParameterWithTable;
import com.consupago.sap.interfaces.proxy.formalizacion.ZCRMGEM_FORMALIZA2_ProxyImpl;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author ramon.becerra
 *
 */
public class ZCRMGEM_FORMALIZA2_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMGEM_FORMALIZA2_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMGEM_FORMALIZA2_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMGEM_FORMALIZA2_ProxyImplTC(String name) {
		super(name);
	}

	public void testDestination( ) throws Exception {	

		CRMLocalConfigEnvironmentData.instance();

		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");

		ZCRMGEM_FORMALIZA2_ProxyImpl proxy = new ZCRMGEM_FORMALIZA2_ProxyImpl();

		ProxyInputParameterWithTable inputParams = new ProxyInputParameterWithTable();
		inputParams.setRecordParam( new ArrayList<Object>() );
		ArrayList<String> arrSolic = new ArrayList<String>();

        arrSolic.add("0050668246");

		log.info("tamano Arreglo::" + arrSolic.size() );

		for (String solicitud : arrSolic) {
			ArrayList<ProxyInputParameter> recordParams1 = new ArrayList<ProxyInputParameter>();
			ProxyInputParameter inputRecord = new ProxyInputParameter();
			inputRecord.setKey("ZOBJECT_ID");
			inputRecord.setValue( solicitud ); // justificar ceros a la izq
			recordParams1.add( inputRecord );
			inputParams.getRecordParam().add( recordParams1 );
		}
		//        Long inicio = System.currentTimeMillis();
		System.out.println(destination.getClient() );
		proxy.executeRemoteFunction(destination, inputParams );

		//        ArrayList<Customizables> arrcust = returnData.getArrCustomizables();
		//        for (Customizables customizables : arrcust) {
		//            log.info( customizables.getCustomfieldValue()+ "\t" + customizables.getCustomfieldKey() );
		//		}


	}
}
