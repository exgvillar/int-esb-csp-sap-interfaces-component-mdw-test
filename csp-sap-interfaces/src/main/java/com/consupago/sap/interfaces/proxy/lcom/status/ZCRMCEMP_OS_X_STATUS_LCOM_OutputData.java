/**
 * 
 */
package com.consupago.sap.interfaces.proxy.lcom.status;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public class ZCRMCEMP_OS_X_STATUS_LCOM_OutputData implements Serializable,
IProxyOutputData {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1838952624801050152L;

	private String documentId;
	private String statusId;
	private String status;	
	private String competidor;
	private double amount;
	private String rfc;
	private String accountNumber;
	private String bankId;
	private String requestId;
	private String statusRequestId;
	private String statusRequest;
	
	
	public String getDocumentId() {
		return documentId;
	}



	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}



	public String getStatusId() {
		return statusId;
	}



	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getCompetidor() {
		return competidor;
	}



	public void setCompetidor(String competidor) {
		this.competidor = competidor;
	}



	public double getAmount() {
		return amount;
	}



	public void setAmount(double amount) {
		this.amount = amount;
	}



	public String getRfc() {
		return rfc;
	}



	public void setRfc(String rfc) {
		this.rfc = rfc;
	}



	public String getAccountNumber() {
		return accountNumber;
	}



	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}



	public String getBankId() {
		return bankId;
	}



	public void setBankId(String bankId) {
		this.bankId = bankId;
	}



	public String getRequestId() {
		return requestId;
	}



	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}



	public String getStatusRequestId() {
		return statusRequestId;
	}



	public void setStatusRequestId(String statusRequestId) {
		this.statusRequestId = statusRequestId;
	}



	public String getStatusRequest() {
		return statusRequest;
	}



	public void setStatusRequest(String statusRequest) {
		this.statusRequest = statusRequest;
	}



	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
