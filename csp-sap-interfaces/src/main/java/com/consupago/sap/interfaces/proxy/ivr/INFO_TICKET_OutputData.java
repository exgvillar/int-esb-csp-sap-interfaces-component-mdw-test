/**
 * 
 */
package com.consupago.sap.interfaces.proxy.ivr;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author juribe
 * 
 */
public class INFO_TICKET_OutputData implements Serializable, IProxyOutputData {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean isValid;
	private String statusId;
	private String statusDesc;
	private String typeId;
	private String typeDesc;
	private Date createDate;
	private Date finalizedDate;
	private boolean expired;
	
	private INFO_TICKET_MESSAGE_OutputData message;

	/**
	 * @return the isValid
	 */
	public boolean isValid() {
		return isValid;
	}

	/**
	 * @param isValid
	 *            the isValid to set
	 */
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	/**
	 * @return the statusId
	 */
	public String getStatusId() {
		return statusId;
	}

	/**
	 * @param statusId
	 *            the statusId to set
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
	 * @param statusDesc
	 *            the statusDesc to set
	 */
	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	/**
	 * @return the typeId
	 */
	public String getTypeId() {
		return typeId;
	}

	/**
	 * @param typeId
	 *            the typeId to set
	 */
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	/**
	 * @return the typeDesc
	 */
	public String getTypeDesc() {
		return typeDesc;
	}

	/**
	 * @param typeDesc
	 *            the typeDesc to set
	 */
	public void setTypeDesc(String typeDesc) {
		this.typeDesc = typeDesc;
	}

	/**
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate
	 *            the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return the finalizedDate
	 */
	public Date getFinalizedDate() {
		return finalizedDate;
	}

	/**
	 * @param finalizedDate
	 *            the finalizedDate to set
	 */
	public void setFinalizedDate(Date finalizedDate) {
		this.finalizedDate = finalizedDate;
	}

	/**
	 * @return the expired
	 */
	public boolean isExpired() {
		return expired;
	}

	/**
	 * @param expired
	 *            the expired to set
	 */
	public void setExpired(boolean expired) {
		this.expired = expired;
	}

	/**
	 * @return the message
	 */
	public INFO_TICKET_MESSAGE_OutputData getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(INFO_TICKET_MESSAGE_OutputData message) {
		this.message = message;
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}

}
