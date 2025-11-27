/**
 * 
 */
package com.consubanco.sap.interfaces.bpm.queues.generals;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author hsanchez
 *
 */
public class ZCRMWKQUE_E010_GET_MASTERQUEUE_OutputData implements Serializable,
		IProxyOutputData {



	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;
	
	private String folioApplication = null;
	 
	 private String processId = null;
	 
	 private String taskId = null;
	 
	 private String correlationId = null;
	 
	 private String applicationStatusKey = null;
	 
	 private String applicationStatusDesc = null;
	
	 private Date createDate = null;
	 
	 private String createHour = null;
	 
	 private Date lastUpdateDate = null;
	 
	 private String lastUpdateHour = null;
	 
	 private Date lastAssignationDate = null;
	 
	 private String lastAssignationHour = null;
	 
	 private String assignedUser = null;
	 
	 private String executorRole = null;
	 
	 private String notificationRole = null;
	 
	 private int reprocessingNumber = 0;
	 
	 private boolean recapture = false;
	 
	 private boolean executed = false;
	 
	 private long elapsedTimeMins = 0;
	 
	 private String taskPriorityKey = null;
	 
	 private String taskPriorityDesc = null;
	 
	 private boolean manualAssignationUser = false;
	 
	 private long waitTime = 0;
	 
	 private int rate = 0;
	 
	 private int recaptureNumber = 0;

	/**
	 * 
	 */
	public ZCRMWKQUE_E010_GET_MASTERQUEUE_OutputData() {
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
	 * @return the processId
	 */
	public String getProcessId() {
		return processId;
	}

	/**
	 * @param processId the processId to set
	 */
	public void setProcessId(String processId) {
		this.processId = processId;
	}

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
	 * @return the correlationId
	 */
	public String getCorrelationId() {
		return correlationId;
	}

	/**
	 * @param correlationId the correlationId to set
	 */
	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
	}

	/**
	 * @return the applicationStatusKey
	 */
	public String getApplicationStatusKey() {
		return applicationStatusKey;
	}

	/**
	 * @param applicationStatusKey the applicationStatusKey to set
	 */
	public void setApplicationStatusKey(String applicationStatusKey) {
		this.applicationStatusKey = applicationStatusKey;
	}

	/**
	 * @return the applicationStatusDesc
	 */
	public String getApplicationStatusDesc() {
		return applicationStatusDesc;
	}

	/**
	 * @param applicationStatusDesc the applicationStatusDesc to set
	 */
	public void setApplicationStatusDesc(String applicationStatusDesc) {
		this.applicationStatusDesc = applicationStatusDesc;
	}

	/**
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return the createHour
	 */
	public String getCreateHour() {
		return createHour;
	}

	/**
	 * @param createHour the createHour to set
	 */
	public void setCreateHour(String createHour) {
		this.createHour = createHour;
	}

	/**
	 * @return the lastUpdateDate
	 */
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	/**
	 * @param lastUpdateDate the lastUpdateDate to set
	 */
	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	/**
	 * @return the lastUpdateHour
	 */
	public String getLastUpdateHour() {
		return lastUpdateHour;
	}

	/**
	 * @param lastUpdateHour the lastUpdateHour to set
	 */
	public void setLastUpdateHour(String lastUpdateHour) {
		this.lastUpdateHour = lastUpdateHour;
	}

	/**
	 * @return the lastAssignationDate
	 */
	public Date getLastAssignationDate() {
		return lastAssignationDate;
	}

	/**
	 * @param lastAssignationDate the lastAssignationDate to set
	 */
	public void setLastAssignationDate(Date lastAssignationDate) {
		this.lastAssignationDate = lastAssignationDate;
	}

	/**
	 * @return the lastAssignationHour
	 */
	public String getLastAssignationHour() {
		return lastAssignationHour;
	}

	/**
	 * @param lastAssignationHour the lastAssignationHour to set
	 */
	public void setLastAssignationHour(String lastAssignationHour) {
		this.lastAssignationHour = lastAssignationHour;
	}

	/**
	 * @return the assignedUser
	 */
	public String getAssignedUser() {
		return assignedUser;
	}

	/**
	 * @param assignedUser the assignedUser to set
	 */
	public void setAssignedUser(String assignedUser) {
		this.assignedUser = assignedUser;
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
	 * @return the notificationRole
	 */
	public String getNotificationRole() {
		return notificationRole;
	}

	/**
	 * @param notificationRole the notificationRole to set
	 */
	public void setNotificationRole(String notificationRole) {
		this.notificationRole = notificationRole;
	}

	/**
	 * @return the reprocessingNumber
	 */
	public int getReprocessingNumber() {
		return reprocessingNumber;
	}

	/**
	 * @param reprocessingNumber the reprocessingNumber to set
	 */
	public void setReprocessingNumber(int reprocessingNumber) {
		this.reprocessingNumber = reprocessingNumber;
	}

	/**
	 * @return the recapture
	 */
	public boolean isRecapture() {
		return recapture;
	}

	/**
	 * @param recapture the recapture to set
	 */
	public void setRecapture(boolean recapture) {
		this.recapture = recapture;
	}

	/**
	 * @return the executed
	 */
	public boolean isExecuted() {
		return executed;
	}

	/**
	 * @param executed the executed to set
	 */
	public void setExecuted(boolean executed) {
		this.executed = executed;
	}

	/**
	 * @return the elapsedTimeMins
	 */
	public long getElapsedTimeMins() {
		return elapsedTimeMins;
	}

	/**
	 * @param elapsedTimeMins the elapsedTimeMins to set
	 */
	public void setElapsedTimeMins(long elapsedTimeMins) {
		this.elapsedTimeMins = elapsedTimeMins;
	}

	/**
	 * @return the taskPriorityKey
	 */
	public String getTaskPriorityKey() {
		return taskPriorityKey;
	}

	/**
	 * @param taskPriorityKey the taskPriorityKey to set
	 */
	public void setTaskPriorityKey(String taskPriorityKey) {
		this.taskPriorityKey = taskPriorityKey;
	}

	/**
	 * @return the taskPriorityDesc
	 */
	public String getTaskPriorityDesc() {
		return taskPriorityDesc;
	}

	/**
	 * @param taskPriorityDesc the taskPriorityDesc to set
	 */
	public void setTaskPriorityDesc(String taskPriorityDesc) {
		this.taskPriorityDesc = taskPriorityDesc;
	}

	/**
	 * @return the manualAssignationUser
	 */
	public boolean isManualAssignationUser() {
		return manualAssignationUser;
	}

	/**
	 * @param manualAssignationUser the manualAssignationUser to set
	 */
	public void setManualAssignationUser(boolean manualAssignationUser) {
		this.manualAssignationUser = manualAssignationUser;
	}

	/**
	 * @return the waitTime
	 */
	public long getWaitTime() {
		return waitTime;
	}

	/**
	 * @param waitTime the waitTime to set
	 */
	public void setWaitTime(long waitTime) {
		this.waitTime = waitTime;
	}

	/**
	 * @return the rate
	 */
	public int getRate() {
		return rate;
	}

	/**
	 * @param rate the rate to set
	 */
	public void setRate(int rate) {
		this.rate = rate;
	}

	/**
	 * @return the recaptureNumber
	 */
	public int getRecaptureNumber() {
		return recaptureNumber;
	}

	/**
	 * @param recaptureNumber the recaptureNumber to set
	 */
	public void setRecaptureNumber(int recaptureNumber) {
		this.recaptureNumber = recaptureNumber;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
