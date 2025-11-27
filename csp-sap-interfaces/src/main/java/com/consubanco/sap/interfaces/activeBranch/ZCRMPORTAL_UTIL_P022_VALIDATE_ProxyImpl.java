package com.consubanco.sap.interfaces.activeBranch;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.consubanco.sap.interfaces.activeBranch.exceptions.RFCExecutionException;
import com.consubanco.sap.interfaces.activeBranch.model.GetBranchesStatusReqModel;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoParameterList;

public class ZCRMPORTAL_UTIL_P022_VALIDATE_ProxyImpl {

	private static Log log = LogFactory.getLog(ZCRMPORTAL_UTIL_P022_VALIDATE_ProxyImpl.class);
	private static final String RFC = "ZCRMPORTAL_UTIL_P022_VALIDATE";

	public ArrayList<IProxyOutputData> executeRemoteFunction(JCoDestination destination,
			GetBranchesStatusReqModel request) throws RFCExecutionException {
		
		ArrayList<IProxyOutputData> returnList = new ArrayList<IProxyOutputData>();
		JCoFunctionTemplate ft = null;
		JCoFunction function = null;
		
		log.info("GetBranchesStatusReqModel ---> " + request);
		
		try {
			
			ft = destination.getRepository().getFunctionTemplate(RFC);
			if (ft == null)
				throw new RFCExecutionException(RFC + " not found in SAP.");

			function = ft.getFunction();

			JCoParameterList importParameters = function.getImportParameterList();
			
			importParameters.setValue("ZID_PROMOTOR", request.getPromotorId());
			importParameters.setValue("ZID_CLIENTE", request.getClientId());
			importParameters.setValue("ZID_SUCURSAL", request.getBranchId());
			
			function.execute(destination);
			JCoParameterList exportParameters = function.getExportParameterList();
			ZCRMPORTAL_UTIL_P022_VALIDATE_OutputData outputData = new ZCRMPORTAL_UTIL_P022_VALIDATE_OutputData();
			outputData.setStatus(exportParameters.getString("E_STATUS"));
			outputData.setCode(exportParameters.getString("E_CODE"));
			outputData.setMessage(exportParameters.getString("E_MESSAGE"));
			
			log.info("GetBranchesStatusResModel ---> " + outputData);
			
			returnList.add(outputData);
		} catch (Exception e) {
			throw new RFCExecutionException("Error during " + RFC + " call: " + e.getMessage());
		}
		return returnList;
	}
}
