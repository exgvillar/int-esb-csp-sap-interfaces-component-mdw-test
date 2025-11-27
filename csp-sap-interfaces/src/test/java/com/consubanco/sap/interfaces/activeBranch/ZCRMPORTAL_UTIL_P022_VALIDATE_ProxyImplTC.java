package com.consubanco.sap.interfaces.activeBranch;

import java.util.ArrayList;

import com.consubanco.sap.interfaces.activeBranch.model.GetBranchesStatusReqModel;
import com.consupago.sap.interfaces.env.CRMLocalConfigEnvironmentData;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;

import junit.framework.AssertionFailedError;
import junit.framework.TestCase;

public class ZCRMPORTAL_UTIL_P022_VALIDATE_ProxyImplTC extends TestCase {

	
	public void testPromotorBlocked() {
		GetBranchesStatusReqModel request = new GetBranchesStatusReqModel();
		request.setPromotorId("10003589");
		
		executeRFC(request, "E", "500", "promotor bloqueado");
	}
	
	public void testInactiveBranch() {
		GetBranchesStatusReqModel request = new GetBranchesStatusReqModel();
		request.setBranchId("50000012");
		
		executeRFC(request, "E", "500", "sucursal inactiva");
	}
	
	public void testNoBlocksBranch() {
		GetBranchesStatusReqModel request = new GetBranchesStatusReqModel();
		request.setBranchId("50000036");
		executeRFC(request, "C", "200", "No se encuentran bloqueos. Continuar con el proceso");
	}
	
	public void testNoBlocksClient() {
		GetBranchesStatusReqModel request = new GetBranchesStatusReqModel();
		request.setClientId("4461068");
		executeRFC(request, "C", "200", "No se encuentran bloqueos. Continuar con el proceso");
	}
	
	public void testNoBlocksPromotor() {
		GetBranchesStatusReqModel request = new GetBranchesStatusReqModel();
		request.setPromotorId("10004456");
		executeRFC(request, "C", "200", "No se encuentran bloqueos. Continuar con el proceso");
	}
	
	private void executeRFC(GetBranchesStatusReqModel request, String status, String code, String message) {

		try {
			CRMLocalConfigEnvironmentData.instance();        
			JCoDestination destination;
			destination = JCoDestinationManager.getDestination("CSPSAPCRM");
			ZCRMPORTAL_UTIL_P022_VALIDATE_ProxyImpl proxy = new ZCRMPORTAL_UTIL_P022_VALIDATE_ProxyImpl();
			ArrayList<IProxyOutputData> outputDataList = proxy.executeRemoteFunction(destination, request);
			ZCRMPORTAL_UTIL_P022_VALIDATE_OutputData outputData = (ZCRMPORTAL_UTIL_P022_VALIDATE_OutputData) outputDataList.get(0);
			assertEquals(status, outputData.getStatus());
			assertEquals(code, outputData.getCode());
			assertEquals(message, outputData.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new AssertionFailedError(e.getMessage());
		}

	}
}
