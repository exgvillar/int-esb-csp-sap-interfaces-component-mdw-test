package com.consubanco.sap.interfaces.cxn.loans;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.cxn.loans.model.CNCA_TASK_Model;
import com.consubanco.sap.interfaces.cxn.loans.model.GENERIC_CATALOG_Model;
import com.consubanco.sap.interfaces.cxn.loans.model.ZCRMORI_E003_GETCNCATASKBYSTS_Model;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoTable;

public class ZCRMORI_E003_GETCNCATASKBYSTS_ProxyImpl {

	private static Log log = LogFactory.getLog(ZCRMORI_E003_GETCNCATASKBYSTS_ProxyImpl.class);
	private final String rfc = "ZCRMORI_E003_GETCNCATASKBYSTS";

	public List<IProxyOutputData> executeRemoteFunction(JCoDestination destination,
			ZCRMORI_E003_GETCNCATASKBYSTS_Model inputParamsModel) throws Exception {
		
		ZCRMORI_E003_GETCNCATASKBYSTS_OutputData outputData = new ZCRMORI_E003_GETCNCATASKBYSTS_OutputData();
		List<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		List<CNCA_TASK_Model> taks = new ArrayList<CNCA_TASK_Model>();	
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			ft = destination.getRepository().getFunctionTemplate( rfc );
			if( ft == null ) {
				throw new RuntimeException(rfc + " not found in SAP.");
			}
			
			function = ft.getFunction();
			
			if( inputParamsModel != null ) {
				
				function.getImportParameterList().setValue("I_PROMOTOR", inputParamsModel.getPromotorBp());			
				
				JCoTable tableStatus = function.getImportParameterList().getTable("I_STATUSID");
				for(GENERIC_CATALOG_Model statusModel: inputParamsModel.getStatus()){
					tableStatus.appendRow();
					tableStatus.setValue("I_STATUSID", statusModel.getKey());	
				}
				log.info(tableStatus.toString());
									
			}
			
			log.info(function.getImportParameterList().toString());
			
			function.execute(destination);
			
			log.info(function.getExportParameterList().toString());
			
			JCoTable outTableTask = function.getExportParameterList().getTable("E_CNCATASK");	
			log.info(outTableTask.toString());
					
			for (int i = 0; i < outTableTask.getNumRows(); i++, outTableTask.nextRow()) {
				CNCA_TASK_Model taskModel = new CNCA_TASK_Model();
				taskModel.setTaskId(outTableTask.getString("E_ID"));				
				taskModel.setBp(outTableTask.getString("E_BP"));				
				taskModel.setName(outTableTask.getString("E_NOMBRE"));
								
				GENERIC_CATALOG_Model status = new GENERIC_CATALOG_Model();
				status.setKey(outTableTask.getString("E_STATUSID"));
				status.setDescription(outTableTask.getString("E_STATUSDESC"));				
				taskModel.setStatus(status);
				taskModel.setLastUpdateDate(outTableTask.getString("E_LASTUPDATEDATE"));
				taks.add(taskModel);
			}
			
			outputData.setTasks(taks);
			returnList.add(outputData);
			
			log.info( "RFC :: " + rfc );
			log.info( "Return data ---> " + returnList.toString());
	
		} catch (AbapException e) {
			log.error(" executing function " + rfc);
			log.error(e);
			throw e;
		} 
		
		return (returnList);
	}
}
