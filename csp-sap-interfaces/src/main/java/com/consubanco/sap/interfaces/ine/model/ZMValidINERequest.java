package com.consubanco.sap.interfaces.ine.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class ZMValidINERequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7042955001772790244L;

	private String customerBp;
	private String sheetAPPReference;

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

    /**
	 * @return the sheetAPPReference
	 */
	public String getSheetAPPReference() {
		return sheetAPPReference;
	}

	/**
	 * @param sheetAPPReference the sheetAPPReference to set
	 */
	public void setSheetAPPReference(String sheetAPPReference) {
		this.sheetAPPReference = sheetAPPReference;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
