package com.consubanco.sap.interfaces.cxn.forms;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public class ZCRMORI_P102_PDF_FOLIOCC_OutputData implements Serializable, IProxyOutputData {

	private static final long serialVersionUID = 2983804407536394686L;

	private boolean success = false;
	private String message = "";

	public ZCRMORI_P102_PDF_FOLIOCC_OutputData() {
		super();
	}

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
