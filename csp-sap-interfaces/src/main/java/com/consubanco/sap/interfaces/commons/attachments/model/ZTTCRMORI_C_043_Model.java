package com.consubanco.sap.interfaces.commons.attachments.model;

import java.io.Serializable;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public class ZTTCRMORI_C_043_Model implements IProxyOutputData, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -801049696510694121L;

	private String documentName;
	
	private String description;
	
	private String createBy;
	
	private String modifyBy;

	/**
	 * @return the documentName
	 */
	public String getDocumentName() {
		return documentName;
	}

	/**
	 * @param documentName the documentName to set
	 */
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the createBy
	 */
	public String getCreateBy() {
		return createBy;
	}

	/**
	 * @param createBy the createBy to set
	 */
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	/**
	 * @return the modifyBy
	 */
	public String getModifyBy() {
		return modifyBy;
	}

	/**
	 * @param modifyBy the modifyBy to set
	 */
	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}

			
}
