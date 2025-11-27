package com.consubanco.sap.interfaces.cxn.loans.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class ZCRMORI_E001_GETINFBYACCOUNTID_Model implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4991195664389523629L;
	private String customerBp;
	private List<I_LOANDS_Model> loans = new ArrayList<I_LOANDS_Model>();
	
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
	 * @return the loans
	 */
	public List<I_LOANDS_Model> getLoans() {
		return loans;
	}
	/**
	 * @param loans the loans to set
	 */
	public void setLoans(List<I_LOANDS_Model> loans) {
		this.loans = loans;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
