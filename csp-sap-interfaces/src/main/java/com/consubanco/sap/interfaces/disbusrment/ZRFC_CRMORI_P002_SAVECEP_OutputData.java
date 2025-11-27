/**
 * 
 */
package com.consubanco.sap.interfaces.disbusrment;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author hsanchez
 *
 */
public class ZRFC_CRMORI_P002_SAVECEP_OutputData implements Serializable, IProxyOutputData {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;

	private boolean success = false;
	
	private String message = null;
	
	
	public boolean isSuccess() {
		return success;
	}


	public void setSuccess(boolean success) {
		this.success = success;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
