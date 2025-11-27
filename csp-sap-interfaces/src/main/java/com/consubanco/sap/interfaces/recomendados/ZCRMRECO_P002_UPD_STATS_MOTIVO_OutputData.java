package com.consubanco.sap.interfaces.recomendados;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public class ZCRMRECO_P002_UPD_STATS_MOTIVO_OutputData implements Serializable,
	IProxyOutputData {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;
	
	private String message = null;
	
	
	
	public ZCRMRECO_P002_UPD_STATS_MOTIVO_OutputData() {
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



	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}

}