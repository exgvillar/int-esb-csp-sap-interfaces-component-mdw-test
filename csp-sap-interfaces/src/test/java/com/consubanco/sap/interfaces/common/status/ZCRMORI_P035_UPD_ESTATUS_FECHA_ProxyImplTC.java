package com.consubanco.sap.interfaces.common.status;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.common.utils.CRM_Estatus_Solicitudes;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

public class ZCRMORI_P035_UPD_ESTATUS_FECHA_ProxyImplTC extends TestCase {
	private static Log log = LogFactory.getLog( ZCRMORI_P035_UPD_ESTATUS_FECHA_ProxyImplTC.class );
	
	private static String[] sol={
		
		"0051090414",
		"0051090435",
		"0051090447",
		"0051090418",
		"0051090424",
		"0051090426",
		"0051090431",
		"0051090429",
		"0051090450",
		"0051090458",
		"0051090417",
		"0051090428",
		"0051090437",
		"0051090466",
		"0051090527",
		"0051090330",
		"0051090422",
		"0051090432",
		"0051090434",
		"0051090438",
		"0051090443",
		"0051090445",
		"0051090451",
		"0051090463",
		"0051090474",
		"0051090477",
		"0051090482",
		"0051090484",
		"0051090502",
		"0051090521",
		"0051090522",
		"0051090536",
		"0051090471",
		"0051090480",
		"0051090483",
		"0051090523",
		"0051090530",
		"0051090542",
		"0051090551",
		"0051090589",
		"0051090605"
		};
	
	public ZCRMORI_P035_UPD_ESTATUS_FECHA_ProxyImplTC(String name) {
		super(name);
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        log.info("destination " + destination.toString());
        ZCRMORI_P035_UPD_ESTATUS_FECHA_ProxyImpl proxy = new ZCRMORI_P035_UPD_ESTATUS_FECHA_ProxyImpl();
        
        for( int i=0; i<sol.length; i++ ){
        	ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        	ProxyInputParameter input = new ProxyInputParameter();
        	input.setKey("I_DOCID");
        	input.setValue( sol[i] );
        	inputParams.add( input );
        	
        	input = new ProxyInputParameter();
        	input.setKey("I_ESTATUS");
        	input.setValue("E0014"); //SPEI-DEV E0039, AUT-PROC-COMPRA - E0031 // ESP. DISP.CLIENTE - E0094, COMPRADA E0036, COMP. DISP. E0004
        	inputParams.add( input ); //E0014 Cancelada
        	
        	input = new ProxyInputParameter();
        	input.setKey("I_DOCTYPE");
//        	input.setValue( "ZCOM"  ); // para OS  de LCOM
        	input.setValue( "ZCSP"  ); // para solicitudes de CXN.
//        	input.setValue( "ZATC"  ); // para solicitudes de CXN.
        	inputParams.add( input );
        	proxy.executeRemoteFunction(destination, inputParams );
        	log.info("Solicitud :: "+ sol[i] );
        }	
	}


}
