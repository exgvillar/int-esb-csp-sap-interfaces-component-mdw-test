package com.consubanco.sap.interfaces.cxn.loans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consubanco.sap.interfaces.cxn.loans.model.CNCA_TASK_Model;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public class ZCRMORI_E003_GETCNCATASKBYSTS_OutputData implements Serializable, IProxyOutputData {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4172118425521116460L;
	private List<CNCA_TASK_Model> tasks = new ArrayList<CNCA_TASK_Model>();
	
	/**
	 * @return the tasks
	 */
	public List<CNCA_TASK_Model> getTasks() {
		return tasks;
	}
	/**
	 * @param tasks the tasks to set
	 */
	public void setTasks(List<CNCA_TASK_Model> tasks) {
		this.tasks = tasks;
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
