/**
 * 
 */
package com.consupago.sap.interfaces.proxy.formaliza;

import java.util.ArrayList;

import junit.framework.TestCase;


import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.ProxyInputParameterWithTable;
import com.consupago.sap.interfaces.proxy.formalizacion.Contact;
import com.consupago.sap.interfaces.proxy.formalizacion.Credit;
import com.consupago.sap.interfaces.proxy.formalizacion.Customer;
import com.consupago.sap.interfaces.proxy.formalizacion.Customizables;
import com.consupago.sap.interfaces.proxy.formalizacion.Reference;
import com.consupago.sap.interfaces.proxy.formalizacion.ZCRMTESO_E001_INFO_FORMALIZA_OutputData;
import com.consupago.sap.interfaces.proxy.formalizacion.ZCRMTESO_E001_INFO_FORMALIZA_ProxyImpl;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author ramon.becerra
 *
 */
public class ZCRMTESO_E001_INFO_FORMALIZA_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMTESO_E001_INFO_FORMALIZA_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMTESO_E001_INFO_FORMALIZA_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMTESO_E001_INFO_FORMALIZA_ProxyImplTC(String name) {
		super(name);
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        ZCRMTESO_E001_INFO_FORMALIZA_ProxyImpl proxy = new ZCRMTESO_E001_INFO_FORMALIZA_ProxyImpl();

        ArrayList<String> arrSolic = new ArrayList<String>();
        arrSolic.add("0050465202");

        System.out.println("SOLICITUD\tBP CLIENTE\tBP REFERENCIA\tAP PATERNO\tAP MATERNO\tNOMBRE 1\tNOMBRE 2\tRELACION\tTELEFONO\tTIPO TELEFONO");

        for (String solicitud : arrSolic) {
            ProxyInputParameterWithTable inputParams = new ProxyInputParameterWithTable();
            inputParams.setRecordParam( new ArrayList<Object>() );
        	ArrayList<ProxyInputParameter> recordParams1 = new ArrayList<ProxyInputParameter>();
            ProxyInputParameter inputRecord = new ProxyInputParameter();
            inputRecord.setKey("ZOBJECT_ID");
            inputRecord.setValue( solicitud ); // justificar ceros a la izq
            recordParams1.add( inputRecord );
            inputParams.getRecordParam().add( recordParams1 );
//        Long inicio = System.currentTimeMillis();
//        System.out.println(destination.getClient() );
        ZCRMTESO_E001_INFO_FORMALIZA_OutputData returnData = proxy.executeRemoteFunction(destination, inputParams );
        Credit credito = returnData.getCredit();
        Customer cliente = returnData.getCustomer();
        ArrayList<Reference> arrReferencias = returnData.getArrReference();
        String idCredito = credito.getCreditCrm();
        String idCliente = cliente.getCustomercustomerCrm();
        for (Reference reference : arrReferencias) {
            System.out.print( idCredito + "\t" + idCliente + "\t" + reference.getRefpersonalRelationCrm() + "\t" + 
            		StringUtils.trimToEmpty(reference.getRefpaternalNm() ) + "\t" +
            		StringUtils.trimToEmpty(reference.getRefmaternalNm() ) + "\t" +
            		StringUtils.trimToEmpty(reference.getReffirstNm() ) + "\t" +
            		StringUtils.trimToEmpty(reference.getRefmiddleNm() ) + "\t" +
            		StringUtils.trimToEmpty(reference.getRefpersonalRelationTypeNm() ) + "\t"
            		);
            ArrayList<Contact> arrContact = reference.getArrContact();
            	if (!arrContact.isEmpty()){
            		Contact contacto1 = arrContact.get(0);
            		System.out.println(StringUtils.trimToEmpty(contacto1.getContactcontactNbr()) + "\t" + StringUtils.trimToEmpty(contacto1.getContactcontactTypeNm()) );
            	} else {
            		System.out.println();
            	}
		}
//        System.out.println(returnData.toString());
//        for (Customizables customizables : arrcustoms) {
//			if (customizables.getCustomfieldKey().contains("Tipo de Dep")){
//				metodoPago = customizables.getCustomfieldValue();
//			}
//			if (customizables.getCustomfieldKey().contains("Programa")){
//				producto = customizables.getCustomfieldValue();
//			}
//		}
//        if (!producto.toUpperCase().trim().contains("LCOM") && !metodoPago.toUpperCase().trim().contains("VENTANI")){
//        	
//        	log.info(credito.getCreditCrm() + "\t" + metodoPago + "\t" + producto);
//        }
        
//        ArrayList<Customizables> arrcust = returnData.getArrCustomizables();
//        for (Customizables customizables : arrcust) {
//            log.info( customizables.getCustomfieldValue()+ "\t" + customizables.getCustomfieldKey() );
//		}
        
        }
        
	}
}
