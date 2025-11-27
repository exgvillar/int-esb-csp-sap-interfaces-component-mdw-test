/**
 * 
 */
package com.consubanco.sap.interfaces.commons;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;

/**
 * @author <a href="mailto:juribe@consubanco.com">juribe</a>
 *
 */
public class ZCRMCSB_P002_ADDUPDGET_FP_ProxyImpl {

	private static Log log = LogFactory.getLog( ZCRMCSB_P002_ADDUPDGET_FP_ProxyImpl.class );
	
	/**
	 * 
	 */
	public ZCRMCSB_P002_ADDUPDGET_FP_ProxyImpl() {
	}

	/**
	 * Lectura de la huella digital / de la foto
	 * 
	 * @param destination
	 * @param inputParamtersList
	 * @param readTypefile 1: FingerPrint; 2: Photo; 3: Ambas
	 * @return
	 * @throws Exception
	 */
	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList, int readTypeFile ) throws Exception {
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;
		
		try {
			
			ft = destination.getRepository().getFunctionTemplate("ZCRMCSB_P002_ADDUPDGET_FP");
			if(ft == null)
	            throw new RuntimeException("ZCRMCSB_P002_ADDUPDGET_FP not found in SAP.");
			
			function = ft.getFunction();
	
			
			Iterator<ProxyInputParameter> iterator = inputParamtersList.iterator();
			
			while (iterator.hasNext()) {
				ProxyInputParameter inputParameter = iterator.next();
				if( StringUtils.trimToNull( inputParameter.getType() ) == null ){
					function.getImportParameterList().setValue(inputParameter.getKey(), inputParameter.getValue());
				}else{
					if(inputParameter.getType().equals("java.util.date")){
						function.getImportParameterList().setValue(inputParameter.getKey(), inputParameter.getDateValue());
					}else{
						function.getImportParameterList().setValue(inputParameter.getKey(), inputParameter.getValue());
					}
					
				}
			}
			
			function.execute(destination);
		
			log.info(function.toString());
			
			String fingerPrintString = null;
			byte[] photoBytes = null;
			
			ZCRMCSB_P002_ADDUPDGET_FP_OutputData fp_OutputData = new ZCRMCSB_P002_ADDUPDGET_FP_OutputData();
			
			String isLocked = function.getExportParameterList().getString("E_LOCKED");
			if("X".equalsIgnoreCase(isLocked)){
				fp_OutputData.setLocked(Boolean.TRUE);
			}
    		try {
    			if(readTypeFile == 3){
    				
    				fingerPrintString = function.getExportParameterList().getString("E_FP");
    				photoBytes = function.getExportParameterList().getByteArray("E_PICTURE");
    				
        			fp_OutputData.setFingerPrintB64(fingerPrintString);
        			
        			byte[] encodeBase64 = base64Encode(photoBytes);
        			String photoEncodeB64 = new String(encodeBase64);
        			
        			fp_OutputData.setPhotoB64(photoEncodeB64);
        			
        			fp_OutputData.setBiometricsMessage("Both files Have Been downloaded...! ");
        			
        			returnList.add(fp_OutputData);
    			}else if(readTypeFile == 2){
    				photoBytes = function.getExportParameterList().getByteArray("E_PICTURE");
    				
    				byte[] encodeBase64 = base64Encode(photoBytes);
        			String photoEncodeB64 = new String(encodeBase64);
        			
        			fp_OutputData.setPhotoB64(photoEncodeB64);
        			
    				fp_OutputData.setBiometricsMessage("The image Has Been downloaded...!");
    				returnList.add(fp_OutputData);
    			}else if(readTypeFile == 1){
    				fingerPrintString = function.getExportParameterList().getString("E_FP");
    				
    				fp_OutputData.setFingerPrintB64(fingerPrintString);
    				fp_OutputData.setBiometricsMessage("The finger Print Has Been downloaded...!");
    				
    				returnList.add(fp_OutputData);
    			}
    			
    			
    		} catch( Exception ex ) {
    			log.error("getting files", ex );
    			throw ex;
    		}
    		
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMCSB_P002_ADDUPDGET_FP" , e);
			throw e;
		}
		
		return returnList;
	}
	
	public ArrayList<IProxyOutputData> executeRemoteFunction( JCoDestination destination, ArrayList<ProxyInputParameter> inputParamtersList, String base64Content, byte[] photo ) throws Exception {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			ft = destination.getRepository().getFunctionTemplate("ZCRMCSB_P002_ADDUPDGET_FP");
			
			if(ft == null)
	            throw new RuntimeException("ZCRMCSB_P002_ADDUPDGET_FP not found in SAP.");
			
			function = ft.getFunction();
	
			Iterator<ProxyInputParameter> iter = inputParamtersList.iterator();
			while( iter.hasNext() ) {
				ProxyInputParameter inputParam = iter.next();
				function.getImportParameterList().setValue( inputParam.getKey(), inputParam.getValue() );	
			}
			
			if(base64Content != null){
				function.getImportParameterList().setValue("I_FP", base64Content );
			}
			
			if(photo != null){
				function.getImportParameterList().setValue("I_PICTURE", photo );
			}
	        
	        function.execute(destination);
	        
	        log.info(function.toString());
	        
	        ZCRMCSB_P002_ADDUPDGET_FP_OutputData fp_OutputData = new ZCRMCSB_P002_ADDUPDGET_FP_OutputData();
	        
	        String urlFingerPrint = function.getExportParameterList().getString("E_URLF");
			String urlPhoto = function.getExportParameterList().getString("E_URLP");
			
	        fp_OutputData.setBiometricsMessage("URL_FINGER PRINT: " + urlFingerPrint + " URL_PHOTO: " + urlPhoto);
	        
	        returnList.add(fp_OutputData);
			
			
		} catch (AbapException e) {
			log.error(" executing function " + "ZCRMCSB_P002_ADDUPDGET_FP" , e);
			throw e;
		}
		
		return( returnList );
	}
	
	private byte[] base64Encode( byte[] byteArray ){
		if (byteArray == null) return null;
		byte[] encodeS =  null;
		try {
			encodeS = Base64.encodeBase64( byteArray );
		} catch (Exception e) {
			e.printStackTrace();
		}
		return encodeS;
	}

}
