/**
 * 
 */
package com.consupago.sap.interfaces.proxy.commons.utils;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.ProxyInputParameterWithTable;
import com.consupago.sap.interfaces.proxy.common.utils.ZCRMORI_P023_CAMBIA_FECHA_ProxyImpl;
import com.consupago.sap.interfaces.proxy.lcom.cartas.ZCRMLCOM_E001_READLCOM_XSTATUS_ProxyImpl;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author ramon.becerra
 *
 */
public class ZCRMORI_P023_CAMBIA_FECHA_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMORI_P023_CAMBIA_FECHA_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMORI_P023_CAMBIA_FECHA_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMORI_P023_CAMBIA_FECHA_ProxyImplTC(String name) {
		super(name);
	}

	public void testExecute( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        System.out.println("INFO::" + destination.getClient());
        ZCRMORI_P023_CAMBIA_FECHA_ProxyImpl proxy = new ZCRMORI_P023_CAMBIA_FECHA_ProxyImpl();
        
        String[] solicitudes = 
        {
        		
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
        }
        ;
        Long inicio = System.currentTimeMillis();

        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        for (String idSolic : solicitudes) {
            ProxyInputParameter input = new ProxyInputParameter();
            input.setKey("I_NUMDOC");
            input.setValue(idSolic );
            inputParams.add( input );
            
            input = new ProxyInputParameter();
            input.setKey("I_TIPDOC");
            input.setValue( "ZCSP" ); // ZCSP / ZCOM 
            inputParams.add( input );
            
            input = new ProxyInputParameter();
            input.setKey("I_FECHA");
            input.setType("java.util.date");
            input.setDateValue( null );
            inputParams.add( input );

            input = new ProxyInputParameter();
            input.setKey("I_TIPFEC");
            input.setValue( "ZFS000000014" ); //ZCSP=ZFS000000014 / ZCOM=ZFS000000013
            inputParams.add( input );
            proxy.executeRemoteFunction(destination, inputParams );
			
		}

        Long fin = System.currentTimeMillis();
        System.out.println("tiempo: "+ (fin-inicio)/1000 );
	}
}
