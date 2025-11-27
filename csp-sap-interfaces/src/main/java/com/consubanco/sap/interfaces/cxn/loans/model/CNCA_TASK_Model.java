package com.consubanco.sap.interfaces.cxn.loans.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class CNCA_TASK_Model implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3885771186865758033L;
	private String taskId;
	private String bp;
	private String name;
	private GENERIC_CATALOG_Model status;
	private String lastUpdateDate;
	
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
	 * @return the bp
	 */
	public String getBp() {
		return bp;
	}
	/**
	 * @param bp the bp to set
	 */
	public void setBp(String bp) {
		this.bp = bp;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return the lastUpdateDate
	 */
	public String getLastUpdateDate() {
		return lastUpdateDate;
	}
	/**
	 * @param lastUpdateDate the lastUpdateDate to set
	 */
	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
