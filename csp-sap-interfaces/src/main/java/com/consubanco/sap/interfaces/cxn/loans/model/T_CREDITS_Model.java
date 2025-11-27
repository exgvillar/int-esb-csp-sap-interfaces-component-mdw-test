package com.consubanco.sap.interfaces.cxn.loans.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class T_CREDITS_Model implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4384195060274021345L;
	private String creditId;
	

	/**
	 * @return the creditId
	 */
	public String getCreditId() {
		return creditId;
	}


	/**
	 * @param creditId the creditId to set
	 */
	public void setCreditId(String creditId) {
		this.creditId = creditId;
	}


	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
    
}
