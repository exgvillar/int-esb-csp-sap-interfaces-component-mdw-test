package com.consupago.sap.interfaces.proxy.casemgt;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.IStandardSAPProxy;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;


public class Z_CRMRFC_ATTACHFILE2CASE_ProxyImpl {

	private static Log log = LogFactory.getLog( Z_CRMRFC_ATTACHFILE2CASE_ProxyImpl.class );
	
	public Z_CRMRFC_ATTACHFILE2CASE_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList, File file) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;
		FileInputStream inputStream = null;
		ByteArrayOutputStream out = null;
		try {
			
			ft = destination.getRepository().getFunctionTemplate("Z_CRMRFC_ATTACHFILE2CASE");
			if(ft == null)
	            throw new RuntimeException("Z_CRMRFC_ATTACHFILE2CASE not found in SAP.");
			
			function = ft.getFunction();
	
			
			Iterator<ProxyInputParameter> iter = inputParamtersList.iterator();
			while( iter.hasNext() ) {
				ProxyInputParameter inputParam = iter.next();
				function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );	
			}
			
			// add file content to the parameter list
			
			inputStream = new FileInputStream( file );			
			out = new ByteArrayOutputStream( );				

			byte[] buf = new byte[4096];  
			int read;     
			while ((read = inputStream.read(buf)) != -1) {
				out.write(buf, 0, read);
			}
			
			function.getImportParameterList().setValue("FILECONTENT", out.toByteArray() );
			
			function.execute(destination);
			
			Z_CRMRFC_ATTACHFILE2CASE_OutputData output = new Z_CRMRFC_ATTACHFILE2CASE_OutputData();
			output.setUrl( function.getExportParameterList().getString("DOCUMENT_URL") );
			
			returnList.add( output );
			
			log.info( "" +  output.toString() );
			
		} catch (AbapException e) {
			log.error(" executing function " + "Z_CRMRFC_ATTACHFILE2CASE" , e);
			throw e;
		} finally {
			if( out != null ) try { out.close(); out = null; } catch( Exception ex ) {}
			if( inputStream != null ) try { inputStream.close(); inputStream = null; } catch( Exception ex ) {}
		}
		
		return( returnList );
	}
	
	
	/**
	 * 
	 * @param destination
	 * @param inputParamtersList
	 * @param base64Content
	 * @return
	 * @throws Exception
	 */
	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList, String base64Content ) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;
		FileInputStream inputStream = null;
		ByteArrayOutputStream out = null;
		try {
			
			ft = destination.getRepository().getFunctionTemplate("Z_CRMRFC_ATTACHFILE2CASE");
			if(ft == null)
	            throw new RuntimeException("Z_CRMRFC_ATTACHFILE2CASE not found in SAP.");
			
			function = ft.getFunction();
	
			
			Iterator<ProxyInputParameter> iter = inputParamtersList.iterator();
			while( iter.hasNext() ) {
				ProxyInputParameter inputParam = iter.next();
				function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );	
			}
			
			// add file content to the parameter list
			
			
			
			
	        byte[] decodedBytes = java.util.Base64.getDecoder().decode(base64Content );
	        
			function.getImportParameterList().setValue("FILECONTENT", decodedBytes );
			
			function.execute(destination);
			
			Z_CRMRFC_ATTACHFILE2CASE_OutputData output = new Z_CRMRFC_ATTACHFILE2CASE_OutputData();
			output.setUrl( function.getExportParameterList().getString("DOCUMENT_URL") );
			
			returnList.add( output );
			
			log.info( "" +  output.toString() );
			
		} catch (AbapException e) {
			log.error(" executing function " + "Z_CRMRFC_ATTACHFILE2CASE" , e);
			throw e;
		} finally {
			if( out != null ) try { out.close(); out = null; } catch( Exception ex ) {}
			if( inputStream != null ) try { inputStream.close(); inputStream = null; } catch( Exception ex ) {}
		}
		
		return( returnList );
	}
}
