/**
 * 
 */
package com.consubanco.sap.interfaces.commons.attachments;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
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
 * @author ramon.becerra
 *
 */
public class ZCRMORI_P008_ATTACH_FILE_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMORI_P008_ATTACH_FILE_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMORI_P008_ATTACH_FILE_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMORI_P008_ATTACH_FILE_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void testDestination( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        File file = new File("/BF/970d3b5f-4ba5-4a4f-b167-6e4e9b9efc11_expediente.pdf");
        
        String encodedFile = null;
		
		ByteArrayOutputStream dataStream = null;
		OutputStream os = null;
		
		FileInputStream inputStream = new FileInputStream( file );
		
		ByteArrayOutputStream out = new ByteArrayOutputStream( );				
	
		byte[] buf = new byte[4096];  
		byte[] bytes = null;
		int read;     
		while ((read = inputStream.read(buf)) != -1) {         
			out.write(buf, 0, read);
		}
		

		String encoded = java.util.Base64.getEncoder().encodeToString( out.toByteArray() );
        
        
        ZCRMORI_P008_ATTACH_FILE_ProxyImpl proxy = new ZCRMORI_P008_ATTACH_FILE_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("LV_OBJECT");
        input.setValue( "0070000063" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("LV_TIPDOC");
        input.setValue( "ZOSR" );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("LV_FILE_NAME");
        input.setValue( file.getName() );
        inputParams.add( input );
        input = new ProxyInputParameter();
        input.setKey("LV_TIPO");
        input.setValue( "2" );
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams, file );
        
        log.info( returnData.toString() );
        
        
	}
}
