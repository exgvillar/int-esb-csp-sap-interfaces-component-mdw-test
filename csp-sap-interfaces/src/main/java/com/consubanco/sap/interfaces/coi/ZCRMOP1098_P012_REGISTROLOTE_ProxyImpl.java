package com.consubanco.sap.interfaces.coi;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.IStandardSAPProxy;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.consupago.sap.interfaces.proxy.casemgt.Z_CRMRFC_ATTACHFILE2CASE_OutputData;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;

public class ZCRMOP1098_P012_REGISTROLOTE_ProxyImpl {

	private static Log log = LogFactory.getLog( ZCRMOP1098_P012_REGISTROLOTE_ProxyImpl.class );
	
	public ZCRMOP1098_P012_REGISTROLOTE_ProxyImpl() {
		super();		
	}

	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList, File file) throws Exception {
		
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;
		FileInputStream inputStream = null;
		ByteArrayOutputStream out = null;
		try {
			
			ft = destination.getRepository().getFunctionTemplate("ZCRMOP1098_P012_REGISTROLOTE");
			if(ft == null)
	            throw new RuntimeException("ZCRMOP1098_P012_REGISTROLOTE not found in SAP.");
			
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
			
			function.getImportParameterList().setValue("I_FILECONTENT", out.toByteArray() );
			
			function.execute(destination);
			
			ZCRMOP1098_P012_REGISTROLOTE_OutputData output = new ZCRMOP1098_P012_REGISTROLOTE_OutputData();

			String result = function.getExportParameterList().getString("E_RESULT");
			String caseId = function.getExportParameterList().getString("E_CASO");
			String url = function.getExportParameterList().getString("E_DOCUMENT_URL");

			
			output.setResult(result);
			output.setCaseId(caseId);
			output.setUrl(url);
			returnList.add( output );	
			
			
			returnList.add( output );
			
			log.info( "" +  output.toString() );
			
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMOP1098_P012_REGISTROLOTE" , e);
			throw e;
		} finally {
			if( out != null ) try { out.close(); out = null; } catch( Exception ex ) {}
			if( inputStream != null ) try { inputStream.close(); inputStream = null; } catch( Exception ex ) {}
		}
		
		return( returnList );		
	}
	
}
