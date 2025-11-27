package com.consubanco.sap.interfaces.cxn.loans.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class REQUEST_CNCA_Model implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6341809777745943123L;
	private String taskId;
	private Date closeDate;
	private List <T_CREDITS_Model> credits;
	private String bpId;
	private String bpName;
	private String nss;
	private String rfc;
	private String requestId;
	private String requestStatus;
	private Date lastDateStatus;
	private String promotorId;
	private String promotorName;
	private int requestBranch;
	private String descriptionBranch;
	private String requestRegion;
	
	/**
	 * @return the taskId
	 */
	public String getTaskId() {
		return taskId;
	}



	/**
	 * @param taskId the taskId to set
	 */
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}



	/**
	 * @return the closeDate
	 */
	public Date getCloseDate() {
		return closeDate;
	}



	/**
	 * @param closeDate the closeDate to set
	 */
	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}



	/**
	 * @return the credits
	 */
	public List<T_CREDITS_Model> getCredits() {
		return credits;
	}



	/**
	 * @param credits the credits to set
	 */
	public void setCredits(List<T_CREDITS_Model> credits) {
		this.credits = credits;
	}



	/**
	 * @return the bpId
	 */
	public String getBpId() {
		return bpId;
	}



	/**
	 * @param bpId the bpId to set
	 */
	public void setBpId(String bpId) {
		this.bpId = bpId;
	}



	/**
	 * @return the bpName
	 */
	public String getBpName() {
		return bpName;
	}



	/**
	 * @param bpName the bpName to set
	 */
	public void setBpName(String bpName) {
		this.bpName = bpName;
	}



	/**
	 * @return the nss
	 */
	public String getNss() {
		return nss;
	}



	/**
	 * @param nss the nss to set
	 */
	public void setNss(String nss) {
		this.nss = nss;
	}



	/**
	 * @return the rfc
	 */
	public String getRfc() {
		return rfc;
	}



	/**
	 * @param rfc the rfc to set
	 */
	public void setRfc(String rfc) {
		this.rfc = rfc;
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
	 * @return the requestStatus
	 */
	public String getRequestStatus() {
		return requestStatus;
	}



	/**
	 * @param requestStatus the requestStatus to set
	 */
	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}



	/**
	 * @return the lastDateStatus
	 */
	public Date getLastDateStatus() {
		return lastDateStatus;
	}



	/**
	 * @param lastDateStatus the lastDateStatus to set
	 */
	public void setLastDateStatus(Date lastDateStatus) {
		this.lastDateStatus = lastDateStatus;
	}



	/**
	 * @return the promotorId
	 */
	public String getPromotorId() {
		return promotorId;
	}



	/**
	 * @param promotorId the promotorId to set
	 */
	public void setPromotorId(String promotorId) {
		this.promotorId = promotorId;
	}



	/**
	 * @return the promotorName
	 */
	public String getPromotorName() {
		return promotorName;
	}



	/**
	 * @param promotorName the promotorName to set
	 */
	public void setPromotorName(String promotorName) {
		this.promotorName = promotorName;
	}



	/**
	 * @return the requestBranch
	 */
	public int getRequestBranch() {
		return requestBranch;
	}



	/**
	 * @param requestBranch the requestBranch to set
	 */
	public void setRequestBranch(int requestBranch) {
		this.requestBranch = requestBranch;
	}



	/**
	 * @return the descriptionBranch
	 */
	public String getDescriptionBranch() {
		return descriptionBranch;
	}



	/**
	 * @param descriptionBranch the descriptionBranch to set
	 */
	public void setDescriptionBranch(String descriptionBranch) {
		this.descriptionBranch = descriptionBranch;
	}



	/**
	 * @return the requestRegion
	 */
	public String getRequestRegion() {
		return requestRegion;
	}



	/**
	 * @param requestRegion the requestRegion to set
	 */
	public void setRequestRegion(String requestRegion) {
		this.requestRegion = requestRegion;
	}



	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
