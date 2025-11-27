/**
 * 
 */
package com.consubanco.sap.interfaces.cxn.references;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author ramon.becerra
 * 
 */
public class ZCRMORI_P001_CREATE_BPRELACS_OutputData implements Serializable,
		IProxyOutputData {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;

	private String errorMessage = null;

	private String successfullIndicator = null;

	
	/**
	 * 
	 */
	public ZCRMORI_P001_CREATE_BPRELACS_OutputData() {
		super();
	}

	
	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}


	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}


	



	/**
	 * @return the successfullIndicator
	 */
	public String getSuccessfullIndicator() {
		return successfullIndicator;
	}


	/**
	 * @param successfullIndicator the successfullIndicator to set
	 */
	public void setSuccessfullIndicator(String successfullIndicator) {
		this.successfullIndicator = successfullIndicator;
	}


	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
