/**
 * 
 */
package com.consubanco.sap.interfaces.cxn.references;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author ramon.becerra
 * 
 */
public class ZCRMORI_E001_GET_BPCLIENT_OutputData implements Serializable,
		IProxyOutputData {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;

	private String clientId = null;

	private String referenceId = null;

	private String relationshipCategory = null;

	private String relationshipType = null;

	private String description = null;

	/**
	 * 
	 */
	public ZCRMORI_E001_GET_BPCLIENT_OutputData() {
		super();
	}

	/**
	 * @return the clientId
	 */
	public String getClientId() {
		return clientId;
	}

	/**
	 * @param clientId
	 *            the clientId to set
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	/**
	 * @return the referenceId
	 */
	public String getReferenceId() {
		return referenceId;
	}

	/**
	 * @param referenceId
	 *            the referenceId to set
	 */
	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}

	/**
	 * @return the relationshipCategory
	 */
	public String getRelationshipCategory() {
		return relationshipCategory;
	}

	/**
	 * @param relationshipCategory
	 *            the relationshipCategory to set
	 */
	public void setRelationshipCategory(String relationshipCategory) {
		this.relationshipCategory = relationshipCategory;
	}

	/**
	 * @return the relationshipType
	 */
	public String getRelationshipType() {
		return relationshipType;
	}

	/**
	 * @param relationshipType
	 *            the relationshipType to set
	 */
	public void setRelationshipType(String relationshipType) {
		this.relationshipType = relationshipType;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
