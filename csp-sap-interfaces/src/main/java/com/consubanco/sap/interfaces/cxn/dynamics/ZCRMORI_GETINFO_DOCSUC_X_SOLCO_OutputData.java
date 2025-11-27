/**
 * 
 */
package com.consubanco.sap.interfaces.cxn.dynamics;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author ramon.becerra
 *
 */
public class ZCRMORI_GETINFO_DOCSUC_X_SOLCO_OutputData implements Serializable,
		IProxyOutputData {


	private String requestId = null;
	
	private String crmConvenio = null;
	
	private String brmsConvenio = null;
	
	private String statusId = null;
	
	private String statusDesc = null;
	
	private Date lastStatusDate = null;
	
	private String documentId = null;
	
	private String fieldId = null;
	
	private String value = null;
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;

		
	
	/**
	 * 
	 */
	public ZCRMORI_GETINFO_DOCSUC_X_SOLCO_OutputData() {
		super();
	}

	
	
	/**
	 * @return the requestId
	 */
	public String getRequestId() {
		return requestId;
	}



	/**
	 * @param requestId the requestId to set
	 */
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}



	/**
	 * @return the crmConvenio
	 */
	public String getCrmConvenio() {
		return crmConvenio;
	}



	/**
	 * @param crmConvenio the crmConvenio to set
	 */
	public void setCrmConvenio(String crmConvenio) {
		this.crmConvenio = crmConvenio;
	}



	/**
	 * @return the brmsConvenio
	 */
	public String getBrmsConvenio() {
		return brmsConvenio;
	}



	/**
	 * @param brmsConvenio the brmsConvenio to set
	 */
	public void setBrmsConvenio(String brmsConvenio) {
		this.brmsConvenio = brmsConvenio;
	}



	/**
	 * @return the statusId
	 */
	public String getStatusId() {
		return statusId;
	}



	/**
	 * @param statusId the statusId to set
	 */
	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}



	/**
	 * @return the statusDesc
	 */
	public String getStatusDesc() {
		return statusDesc;
	}



	/**
	 * @param statusDesc the statusDesc to set
	 */
	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}



	/**
	 * @return the lastStatusDate
	 */
	public Date getLastStatusDate() {
		return lastStatusDate;
	}



	/**
	 * @param lastStatusDate the lastStatusDate to set
	 */
	public void setLastStatusDate(Date lastStatusDate) {
		this.lastStatusDate = lastStatusDate;
	}



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



	/**
	 * @return the fieldId
	 */
	public String getFieldId() {
		return fieldId;
	}



	/**
	 * @param fieldId the fieldId to set
	 */
	public void setFieldId(String fieldId) {
		this.fieldId = fieldId;
	}



	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}



	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}



	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
