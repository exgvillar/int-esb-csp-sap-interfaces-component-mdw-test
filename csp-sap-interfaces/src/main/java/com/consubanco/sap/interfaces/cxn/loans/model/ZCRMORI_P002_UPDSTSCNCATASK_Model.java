package com.consubanco.sap.interfaces.cxn.loans.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class ZCRMORI_P002_UPDSTSCNCATASK_Model implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7738358389569964622L;
	private String taskId;
	private GENERIC_CATALOG_Model status;	
	private String comments;
	
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
	 * @return the status
	 */
	public GENERIC_CATALOG_Model getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(GENERIC_CATALOG_Model status) {
		this.status = status;
	}
	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}
	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
