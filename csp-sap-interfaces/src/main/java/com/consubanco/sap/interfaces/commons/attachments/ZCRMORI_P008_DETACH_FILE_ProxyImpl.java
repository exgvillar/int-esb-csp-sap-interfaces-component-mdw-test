/**
 * 
 */
package com.consubanco.sap.interfaces.commons.attachments;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.commons.attachments.model.ZTTCRMORI_C_043_Model;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.consupago.sap.interfaces.proxy.ProxyInputParameter;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoTable;

/**
 * @author <a href="mailto:juribe@consubanco.com.">juribe</a>
 *
 */
public class ZCRMORI_P008_DETACH_FILE_ProxyImpl {

	private static final Log log = LogFactory.getLog(ZCRMORI_P008_DETACH_FILE_ProxyImpl.class);
	
	/* (non-Javadoc)
	 * @see com.consupago.sap.interfaces.proxy.IStandardSAPProxy#executeRemoteFunction(com.sap.conn.jco.JCoDestination, java.util.ArrayList)
	 */
	public ArrayList<IProxyOutputData> executeRemoteFunction(JCoDestination destination,
			ArrayList<ProxyInputParameter> inputParamtersList, ArrayList<ZTTCRMORI_C_043_Model> documentList  ) throws Exception {
		
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;
		
		try {
			
			ft = destination.getRepository().getFunctionTemplate("ZCRMORI_P008_DETACH_FILE");
			if(ft == null)
	            throw new RuntimeException("ZCRMORI_P008_DETACH_FILE not found in SAP.");
			
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
			
			JCoTable table = function.getImportParameterList().getTable("IT_DETACH");
			
			if(documentList != null && !documentList.isEmpty()){
				
				Iterator<ZTTCRMORI_C_043_Model> iteratorTmp = documentList.iterator();
				while (iteratorTmp.hasNext()) {
					ZTTCRMORI_C_043_Model document = iteratorTmp.next();
					table.appendRow();
					table.setValue("DOCUMENTO", document.getDocumentName());
					table.setValue("DESCRIPCION",document.getDescription());
					table.setValue("CREADO",document.getCreateBy());
					table.setValue("MODIFICADO",document.getModifyBy());					
				}
				
			}
			
			function.execute(destination);
			
			String message = function.getExportParameterList().getString("E_MESSAGE");
			
			log.info("executiong ZCRMORI_P008_DETACH_FILE successful :" + message);
			
			ZCRMORI_P008_DETACH_FILE_OutputData outputData = new ZCRMORI_P008_DETACH_FILE_OutputData();
			outputData.setMessage(message);
			
			returnList.add(outputData);
			
		} catch (AbapException abapex) {
			log.error("executing function ZCRMORI_P008_DETACH_FILE ", abapex);
			throw abapex;
		}finally{
			
		}
		
		return returnList;
	}


}
