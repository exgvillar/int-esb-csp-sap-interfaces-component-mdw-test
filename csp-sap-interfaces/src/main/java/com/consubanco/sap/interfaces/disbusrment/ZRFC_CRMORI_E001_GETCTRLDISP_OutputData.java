/**
 * 
 */
package com.consubanco.sap.interfaces.disbusrment;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author hsanchez
 *
 */
public class ZRFC_CRMORI_E001_GETCTRLDISP_OutputData implements Serializable, IProxyOutputData {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;

	private String documentId = null;
	
	private String operationType = null;
	
	private String trackingId = null;
	
	private boolean sameBank = false;
	
	private Date createDate = null;
	
	private String createHour = null;
	
	private String 	applicationIdAssociated = null;
	
	
	/**
	 * @return the documentId
	 */
	public String getDocumentId() {
		return documentId;
	}


	/**
	 * @param documentId the documentId to set
	 */
	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

	public String getOperationType() {
		return operationType;
	}


	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}


	/**
	 * @return the trackingId
	 */
	public String getTrackingId() {
		return trackingId;
	}


	/**
	 * @param trackingId the trackingId to set
	 */
	public void setTrackingId(String trackingId) {
		this.trackingId = trackingId;
	}


	/**
	 * @return the sameBank
	 */
	public boolean isSameBank() {
		return sameBank;
	}


	/**
	 * @param sameBank the sameBank to set
	 */
	public void setSameBank(boolean sameBank) {
		this.sameBank = sameBank;
	}


	/**
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}


	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	/**
	 * @return the createHour
	 */
	public String getCreateHour() {
		return createHour;
	}


	/**
	 * @param createHour the createHour to set
	 */
	public void setCreateHour(String createHour) {
		this.createHour = createHour;
	}

	public String getApplicationIdAssociated() {
		return applicationIdAssociated;
	}


	public void setApplicationIdAssociated(String applicationIdAssociated) {
		this.applicationIdAssociated = applicationIdAssociated;
	}


	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
