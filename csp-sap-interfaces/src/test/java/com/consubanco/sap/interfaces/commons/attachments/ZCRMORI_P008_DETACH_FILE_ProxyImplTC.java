/**
 * 
 */
package com.consubanco.sap.interfaces.commons.attachments;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.commons.attachments.model.ZTTCRMORI_C_043_Model;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

/**
 * @author <a href="mailto:juribe@consubanco.com.">juribe</a>
 *
 */
public class ZCRMORI_P008_DETACH_FILE_ProxyImplTC extends TestCase{
	
	private static final Log log = LogFactory.getLog(ZCRMORI_P008_DETACH_FILE_ProxyImplTC.class);

	/**
	 * 
	 */
	public ZCRMORI_P008_DETACH_FILE_ProxyImplTC() {
		super();
	}
	
	
	public void testDestination( ) throws Exception{
		
		CRMLocalConfigEnvironmentData.instance();
		
		JCoDestination destination = JCoDestinationManager.getDestination("CSPSAPCRM");

		ZCRMORI_P008_DETACH_FILE_ProxyImpl proxyImpl = new ZCRMORI_P008_DETACH_FILE_ProxyImpl();
		
		
		ArrayList<ProxyInputParameter> inputParamtersList = null;
		ArrayList<ZTTCRMORI_C_043_Model> documentList = null;
		ProxyInputParameter inputParameter = null;
		ZTTCRMORI_C_043_Model model = null;  
		
		inputParamtersList = new ArrayList<ProxyInputParameter>();
		documentList = new ArrayList<ZTTCRMORI_C_043_Model>();
		
		inputParameter = new ProxyInputParameter();
		inputParameter.setKey("I_GUID");
		inputParameter.setValue("00000000000000000000000000000000");
		inputParamtersList.add(inputParameter);
		
		inputParameter = new ProxyInputParameter();
		inputParameter.setKey("I_NUMDOC");
		inputParameter.setValue("0060073166");
		inputParamtersList.add(inputParameter);
		
		inputParameter = new ProxyInputParameter();
		inputParameter.setKey("I_TIPDOC");
		inputParameter.setValue("ZSTC");
		inputParamtersList.add(inputParameter);
		
		/*
		 * Se elimina x nombre del doc o descripcion 
		 */
		model = new ZTTCRMORI_C_043_Model();
//		model.setCreateBy("");
//		model.setDescription("JUAN_DAVID_BERNAL_GUZMAN.pdf");
//		model.setDocumentName("testUno.pdf");
		model.setDocumentName("");
//		model.setModifyBy("juribe");
		
		/*
		 * Si se quieren borrar todos hay qu enviar el documento vacio
		 * En caso contrario se manda el nombre del documento
		 *
		 */
		documentList.add(model);
		
		try{
			ArrayList<IProxyOutputData> returnData = proxyImpl.executeRemoteFunction(destination, inputParamtersList, documentList);
			log.info( returnData.toString() );
			log.info( returnData.toString() );
		
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		
	}
	
	
	

}
