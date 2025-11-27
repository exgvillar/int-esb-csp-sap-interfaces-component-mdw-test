package com.consubanco.sap.interfaces.ine.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class ZMGetInfoINERequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2187987871971153856L;

	private String customerBp;

	/**
	 * @return the customerBp
	 */
	public String getCustomerBp() {
		return customerBp;
	}

	/**
	 * @param customerBp the customerBp to set
	 */
	public void setCustomerBp(String customerBp) {
		this.customerBp = customerBp;
	}
	
    @Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
