package com.consubanco.sap.interfaces.cxn.loans.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class E_LOANS_Model implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6435737854971126378L;
	private String accountId;
	private String folioApplication;
	private String folioCartaLibranza;
	private String tipoPension;	
	
    /**
	 * @return the accountId
	 */
	public String getAccountId() {
		return accountId;
	}
	/**
	 * @param accountId the accountId to set
	 */
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	/**
	 * @return the folioApplication
	 */
	public String getFolioApplication() {
		return folioApplication;
	}
	/**
	 * @param folioApplication the folioApplication to set
	 */
	public void setFolioApplication(String folioApplication) {
		this.folioApplication = folioApplication;
	}
	/**
	 * @return the folioCartaLibranza
	 */
	public String getFolioCartaLibranza() {
		return folioCartaLibranza;
	}
	/**
	 * @param folioCartaLibranza the folioCartaLibranza to set
	 */
	public void setFolioCartaLibranza(String folioCartaLibranza) {
		this.folioCartaLibranza = folioCartaLibranza;
	}
	/**
	 * @return the tipoPension
	 */
	public String getTipoPension() {
		return tipoPension;
	}
	/**
	 * @param tipoPension the tipoPension to set
	 */
	public void setTipoPension(String tipoPension) {
		this.tipoPension = tipoPension;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
