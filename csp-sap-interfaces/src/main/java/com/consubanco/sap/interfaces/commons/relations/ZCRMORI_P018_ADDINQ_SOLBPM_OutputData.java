/**
 * 
 */
package com.consubanco.sap.interfaces.commons.relations;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author ramon.becerra
 *
 */
public class ZCRMORI_P018_ADDINQ_SOLBPM_OutputData implements Serializable,
		IProxyOutputData {


	private String requestId = null;
	
	private long processId = 0;
	
	private Date executionDate = null;
	
	private String executionHour = null;

	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;

		
	
	/**
	 * 
	 */
	public ZCRMORI_P018_ADDINQ_SOLBPM_OutputData() {
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
	 * @return the processId
	 */
	public long getProcessId() {
		return processId;
	}



	/**
	 * @param processId the processId to set
	 */
	public void setProcessId(long processId) {
		this.processId = processId;
	}



	/**
	 * @return the executionDate
	 */
	public Date getExecutionDate() {
		return executionDate;
	}



	/**
	 * @param executionDate the executionDate to set
	 */
	public void setExecutionDate(Date executionDate) {
		this.executionDate = executionDate;
	}



	/**
	 * @return the executionHour
	 */
	public String getExecutionHour() {
		return executionHour;
	}



	/**
	 * @param executionHour the executionHour to set
	 */
	public void setExecutionHour(String executionHour) {
		this.executionHour = executionHour;
	}



	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
