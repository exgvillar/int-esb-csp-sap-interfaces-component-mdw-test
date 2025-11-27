/**
 * 
 */
package com.consubanco.sap.interfaces.massiveLoad;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
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
 * @author hsanchez
 *
 */
public class ZCRMORIG_P002_ATTACHDOCS_ProxyImplTC extends TestCase {

	private static Log log = LogFactory.getLog( ZCRMORIG_P002_ATTACHDOCS_ProxyImplTC.class );
	
	/**
	 * 
	 */
	public ZCRMORIG_P002_ATTACHDOCS_ProxyImplTC() {

	}

	/**
	 * @param name
	 */
	public ZCRMORIG_P002_ATTACHDOCS_ProxyImplTC(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	/*
	public void testDestination1( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        File file = new File("/BF/SAPJCo_MigrationGuide_2.x_3.0_EN.pdf");
        
        ZCRMORIG_P002_ATTACHDOCS_ProxyImpl proxy = new ZCRMORIG_P002_ATTACHDOCS_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_CASOID");
        input.setValue( "1058819" );
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("I_FILENAME");
        input.setValue( file.getName() );
        inputParams.add( input );
        
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams, file );
        
        log.info( returnData.toString() );
        
	}
	*/
	
	public void testDestination2( ) throws Exception {	
		
		CRMLocalConfigEnvironmentData.instance();
        
        JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");
        
        File file = new File("/BF/SAP NetWeaver BPM Tutorial.pdf");
        String encoded = null;
        
		FileInputStream inputStream = new FileInputStream( file );    		
		ByteArrayOutputStream out = new ByteArrayOutputStream( );				

		try {
			byte[] buf = new byte[4096];  
			int read;     
			while ((read = inputStream.read(buf)) != -1) {         
				out.write(buf, 0, read);
			}			
			
					
			
			encoded = java.util.Base64.getEncoder().encodeToString( out.toByteArray() );
	        
		} catch( Exception ex ) {
			throw ex;
		}
        
        ZCRMORIG_P002_ATTACHDOCS_ProxyImpl proxy = new ZCRMORIG_P002_ATTACHDOCS_ProxyImpl();
        
        ArrayList<ProxyInputParameter> inputParams = new ArrayList<ProxyInputParameter>();
        ProxyInputParameter input = new ProxyInputParameter();
        input.setKey("I_CASOID");
        input.setValue( "1058821" );
        inputParams.add( input );
        
        input = new ProxyInputParameter();
        input.setKey("I_FILENAME");
        input.setValue( file.getName() );
        inputParams.add( input );
                
        ArrayList<IProxyOutputData> returnData = proxy.executeRemoteFunction(destination, inputParams, encoded );
        
        log.info( returnData.toString() );
        
        
	}

}
