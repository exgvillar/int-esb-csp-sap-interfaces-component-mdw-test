package com.consubanco.sap.interfaces.recomendados;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public class ZCRMRECO_P004_UPD_OS_X_REFEREN_OutputData implements Serializable,
	IProxyOutputData {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;
	
	private String message = null;
	
	private String operationId = null;
	
	private String paymentsNumber = null;
	
	
	
	public ZCRMRECO_P004_UPD_OS_X_REFEREN_OutputData() {
		super();
	}


	
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}



	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}



	/**
	 * @return the operationId
	 */
	public String getOperationId() {
		return operationId;
	}



	/**
	 * @param operationId the operationId to set
	 */
	public void setOperationId(String operationId) {
		this.operationId = operationId;
	}



	/**
	 * @return the paymentsNumber
	 */
	public String getPaymentsNumber() {
		return paymentsNumber;
	}



	/**
	 * @param paymentsNumber the paymentsNumber to set
	 */
	public void setPaymentsNumber(String paymentsNumber) {
		this.paymentsNumber = paymentsNumber;
	}



	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}

}
