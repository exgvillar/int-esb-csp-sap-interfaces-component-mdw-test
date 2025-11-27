package com.consubanco.sap.interfaces.cxn.loans;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.cxn.loans.model.REQUEST_CNCA_Model;
import com.consubanco.sap.interfaces.cxn.loans.model.T_CREDITS_Model;
import com.consubanco.sap.interfaces.cxn.loans.model.ZCRMCXN_E010_SOLCNCAINT_Model;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.sap.conn.jco.AbapException;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoTable;

public class ZCRMCXN_E010_SOLCNCAINT_ProxyImpl {

	private static Log log = LogFactory.getLog(ZCRMCXN_E010_SOLCNCAINT_ProxyImpl.class);
	private final String rfc = "ZCRMCXN_E010_SOLCNCAINT";

	public List<IProxyOutputData> executeRemoteFunction(JCoDestination destination,
			ZCRMCXN_E010_SOLCNCAINT_Model inputParamsModel) throws Exception {
		
		ZCRMCXN_E010_SOLCNCAINT_OutputData outputData = new ZCRMCXN_E010_SOLCNCAINT_OutputData();
		List<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		List<REQUEST_CNCA_Model> requests = new ArrayList<REQUEST_CNCA_Model>();
		
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;

		try {
			ft = destination.getRepository().getFunctionTemplate( rfc );
			if( ft == null ) {
				throw new RuntimeException(rfc + " not found in SAP.");
			}
			
			function = ft.getFunction();
			
			if( inputParamsModel != null ) {
				function.getImportParameterList().setValue("I_FECHA_INI", inputParamsModel.getInitialDate());
				log.info(function.getImportParameterList().toString());
				
				function.getImportParameterList().setValue("I_FECHA_FIN", inputParamsModel.getFinalDate());
				log.info(function.getImportParameterList().toString());
			}			
			
			function.execute(destination);			
			
			//JCoStructure outRequest = function.getExportParameterList().getStructure("ET_SALIDA");
			//log.info(outRequest.toString());
			JCoTable outTableRequests = function.getExportParameterList().getTable("ET_SALIDA");	
			log.info(outTableRequests.toString());
			
			for (int i = 0; i < outTableRequests.getNumRows(); i++, outTableRequests.nextRow()) {
				REQUEST_CNCA_Model request = new REQUEST_CNCA_Model();
				request.setTaskId(outTableRequests.getString("ID_TAREA"));
				request.setCloseDate(outTableRequests.getDate("FECHA_BAJA"));
				List<T_CREDITS_Model> credits = new ArrayList<T_CREDITS_Model>();
				JCoTable outTableCredits = outTableRequests.getTable("T_CREDITOS");	
				log.info(outTableCredits.toString());
				for (int j = 0; j < outTableCredits.getNumRows(); j++, outTableCredits.nextRow()) {
					T_CREDITS_Model credit = new T_CREDITS_Model();
					credit.setCreditId(outTableCredits.getString("ID_CREDITO"));
					credits.add(credit);
				}
				request.setCredits(credits);
				request.setBpId(outTableRequests.getString("ID_BP"));
				request.setBpName(outTableRequests.getString("NOMBRE_CTE"));
				request.setTaskId(outTableRequests.getString("NSS"));
				request.setRfc(outTableRequests.getString("RFC"));
				request.setRequestId(outTableRequests.getString("ID_SOLICITUD"));
				request.setRequestStatus(outTableRequests.getString("ESTATUS_SOL"));
				request.setLastDateStatus(outTableRequests.getDate("FECHA_ULT_EST"));
				request.setPromotorId(outTableRequests.getString("PROMOTOR_SOL"));
				request.setPromotorName(outTableRequests.getString("NOMBRE_PROM"));
				request.setRequestBranch(outTableRequests.getInt("SUC_SOLICITUD"));
				request.setDescriptionBranch(outTableRequests.getString("DESC_SUC"));
				request.setRequestRegion(outTableRequests.getString("REGION_SOL"));
				requests.add(request);
			}
			
			outputData.setRequests(requests);
		
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
