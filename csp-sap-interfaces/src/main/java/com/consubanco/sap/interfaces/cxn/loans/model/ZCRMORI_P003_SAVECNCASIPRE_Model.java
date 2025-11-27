package com.consubanco.sap.interfaces.cxn.loans.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class ZCRMORI_P003_SAVECNCASIPRE_Model  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6511315577045584107L;
	private String taskId;
	private String accountId;
	private GENERIC_CATALOG_Model statusSipre;
	private List<I_FILES_Model> fileEvidences = new ArrayList<I_FILES_Model>();
	
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
	 * @return the accountId
	 */
	public String getAccountId() {
		return accountId;
	}
	/**
	 * @param accountId the accountId to set
	 */
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	/**
	 * @return the statusSipre
	 */
	public GENERIC_CATALOG_Model getStatusSipre() {
		return statusSipre;
	}
	/**
	 * @param statusSipre the statusSipre to set
	 */
	public void setStatusSipre(GENERIC_CATALOG_Model statusSipre) {
		this.statusSipre = statusSipre;
	}
	/**
	 * @return the fileEvidences
	 */
	public List<I_FILES_Model> getFileEvidences() {
		return fileEvidences;
	}
	/**
	 * @param fileEvidences the fileEvidences to set
	 */
	public void setFileEvidences(List<I_FILES_Model> fileEvidences) {
		this.fileEvidences = fileEvidences;
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
