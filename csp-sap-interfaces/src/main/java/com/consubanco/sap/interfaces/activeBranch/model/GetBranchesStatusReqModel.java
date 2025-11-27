package com.consubanco.sap.interfaces.activeBranch.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class GetBranchesStatusReqModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1349730834144890570L;
	private String promotorId;
	private String clientId;
	private String branchId;
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
	 * @return the clientId
	 */
	public String getClientId() {
		return clientId;
	}
	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	/**
	 * @return the branchId
	 */
	public String getBranchId() {
		return branchId;
	}
	/**
	 * @param branchId the branchId to set
	 */
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
