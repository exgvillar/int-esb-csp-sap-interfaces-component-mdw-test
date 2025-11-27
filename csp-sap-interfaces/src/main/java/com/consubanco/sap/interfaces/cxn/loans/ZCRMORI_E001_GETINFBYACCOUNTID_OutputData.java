package com.consubanco.sap.interfaces.cxn.loans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consubanco.sap.interfaces.cxn.loans.model.E_CUSTOMER_Model;
import com.consubanco.sap.interfaces.cxn.loans.model.E_LOANS_Model;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public class ZCRMORI_E001_GETINFBYACCOUNTID_OutputData implements Serializable, IProxyOutputData {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5070863639715914220L;
	private String success;
	private String message;
	private E_CUSTOMER_Model customer;
	private List<E_LOANS_Model> loans = new ArrayList<E_LOANS_Model>();
	
    /**
	 * @return the success
	 */
	public String getSuccess() {
		return success;
	}

	/**
	 * @param success the success to set
	 */
	public void setSuccess(String success) {
		this.success = success;
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
	 * @return the customer
	 */
	public E_CUSTOMER_Model getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(E_CUSTOMER_Model customer) {
		this.customer = customer;
	}

	/**
	 * @return the loans
	 */
	public List<E_LOANS_Model> getLoans() {
		return loans;
	}

	/**
	 * @param loans the loans to set
	 */
	public void setLoans(List<E_LOANS_Model> loans) {
		this.loans = loans;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
    
}
