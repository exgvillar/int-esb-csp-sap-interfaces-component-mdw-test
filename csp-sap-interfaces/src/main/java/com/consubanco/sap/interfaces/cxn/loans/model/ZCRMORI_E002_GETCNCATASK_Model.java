package com.consubanco.sap.interfaces.cxn.loans.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class ZCRMORI_E002_GETCNCATASK_Model implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6661333532732651999L;
	private String taskId;
	private boolean findFiles;

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
	 * @return the findFiles
	 */
	public boolean isFindFiles() {
		return findFiles;
	}

	/**
	 * @param findFiles the findFiles to set
	 */
	public void setFindFiles(boolean findFiles) {
		this.findFiles = findFiles;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
