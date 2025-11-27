package com.consubanco.sap.interfaces.cxn.loans.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class ZCRMCXN_E010_SOLCNCAINT_Model implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2823745906848138130L;	
	private Date initialDate;
	private Date finalDate;
		
	/**
	 * @return the initialDate
	 */
	public Date getInitialDate() {
		return initialDate;
	}



	/**
	 * @param initialDate the initialDate to set
	 */
	public void setInitialDate(Date initialDate) {
		this.initialDate = initialDate;
	}



	/**
	 * @return the finalDate
	 */
	public Date getFinalDate() {
		return finalDate;
	}



	/**
	 * @param finalDate the finalDate to set
	 */
	public void setFinalDate(Date finalDate) {
		this.finalDate = finalDate;
	}



	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
