package com.consubanco.sap.interfaces.common.terminados;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class ZCRMCRT_P001_SAVE_CONYUGE_Model implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2579849244298352491L;

	private String customerId;
	
	private String firstName;
	
	private String middleName;
	
	private String paternalLastName;
	
	private String maternalLastName;

	/**
	 * @return the customerId
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * @return the paternalLastName
	 */
	public String getPaternalLastName() {
		return paternalLastName;
	}

	/**
	 * @param paternalLastName the paternalLastName to set
	 */
	public void setPaternalLastName(String paternalLastName) {
		this.paternalLastName = paternalLastName;
	}

	/**
	 * @return the maternalLastName
	 */
	public String getMaternalLastName() {
		return maternalLastName;
	}

	/**
	 * @param maternalLastName the maternalLastName to set
	 */
	public void setMaternalLastName(String maternalLastName) {
		this.maternalLastName = maternalLastName;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
	
}
