/**
 * 
 */
package com.consubanco.sap.interfaces.bpm.queues.generals;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author hsanchez
 *
 */
public class ZCRMWKQUE_E012_LAST_USR_ASSIGN_OutputData implements Serializable,
		IProxyOutputData {



	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;
	
	 private String folioApplication = null;
	 
	 private String userName = null;
	 
	 private String executorRole = null;
	 
	 private String status = null;
	 
	/**
	 * 
	 */
	public ZCRMWKQUE_E012_LAST_USR_ASSIGN_OutputData() {
		super();
	}

	/**
	 * @return the folioApplication
	 */
	public String getFolioApplication() {
		return folioApplication;
	}

	/**
	 * @param folioApplication the folioApplication to set
	 */
	public void setFolioApplication(String folioApplication) {
		this.folioApplication = folioApplication;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the executorRole
	 */
	public String getExecutorRole() {
		return executorRole;
	}

	/**
	 * @param executorRole the executorRole to set
	 */
	public void setExecutorRole(String executorRole) {
		this.executorRole = executorRole;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
