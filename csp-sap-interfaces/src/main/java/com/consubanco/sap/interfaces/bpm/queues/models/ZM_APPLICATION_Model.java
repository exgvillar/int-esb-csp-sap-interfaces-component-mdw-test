/**
 * 
 */
package com.consubanco.sap.interfaces.bpm.queues.models;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author hsanchez
 *
 */
public class ZM_APPLICATION_Model implements Serializable,
		IProxyOutputData {



	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;
	
	private String folioApplication = null;
	
	private Date createDate = null;
	
	private Date lastUpdateDate = null;
	
	private String executorRole = null;
	
	private long waitingTimeMins = 0;
	
	private String name1= null;
	
	private String name2 = null;
	
	private String lastName1 = null;
	
	private String lastName2 = null;
	
	private String convenioKey = null;
	
	private String convenioDesc = null;
	
	private String productKey = null;
	
	private String productDesc = null;
	
	private double requestAmount = 0;
	
	private String frecuency = null;
	
	private int plazo = 0;
	
	private boolean assigned = false;
	
	private String requestStatusKey = null;
	
	private String requestStatusDesc = null;
	
	private String userAssigned = null;
	
	/**
	 * 
	 */
	public ZM_APPLICATION_Model() {
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
	 * @return the waitingTimeMins
	 */
	public long getWaitingTimeMins() {
		return waitingTimeMins;
	}

	/**
	 * @param waitingTimeMins the waitingTimeMins to set
	 */
	public void setWaitingTimeMins(long waitingTimeMins) {
		this.waitingTimeMins = waitingTimeMins;
	}

	/**
	 * @return the name1
	 */
	public String getName1() {
		return name1;
	}

	/**
	 * @param name1 the name1 to set
	 */
	public void setName1(String name1) {
		this.name1 = name1;
	}

	/**
	 * @return the name2
	 */
	public String getName2() {
		return name2;
	}

	/**
	 * @param name2 the name2 to set
	 */
	public void setName2(String name2) {
		this.name2 = name2;
	}

	/**
	 * @return the lastName1
	 */
	public String getLastName1() {
		return lastName1;
	}

	/**
	 * @param lastName1 the lastName1 to set
	 */
	public void setLastName1(String lastName1) {
		this.lastName1 = lastName1;
	}

	/**
	 * @return the lastName2
	 */
	public String getLastName2() {
		return lastName2;
	}

	/**
	 * @param lastName2 the lastName2 to set
	 */
	public void setLastName2(String lastName2) {
		this.lastName2 = lastName2;
	}

	/**
	 * @return the convenioKey
	 */
	public String getConvenioKey() {
		return convenioKey;
	}

	/**
	 * @param convenioKey the convenioKey to set
	 */
	public void setConvenioKey(String convenioKey) {
		this.convenioKey = convenioKey;
	}

	/**
	 * @return the convenioDesc
	 */
	public String getConvenioDesc() {
		return convenioDesc;
	}

	/**
	 * @param convenioDesc the convenioDesc to set
	 */
	public void setConvenioDesc(String convenioDesc) {
		this.convenioDesc = convenioDesc;
	}

	/**
	 * @return the productKey
	 */
	public String getProductKey() {
		return productKey;
	}

	/**
	 * @param productKey the productKey to set
	 */
	public void setProductKey(String productKey) {
		this.productKey = productKey;
	}

	/**
	 * @return the productDesc
	 */
	public String getProductDesc() {
		return productDesc;
	}

	/**
	 * @param productDesc the productDesc to set
	 */
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	/**
	 * @return the requestAmount
	 */
	public double getRequestAmount() {
		return requestAmount;
	}

	/**
	 * @param requestAmount the requestAmount to set
	 */
	public void setRequestAmount(double requestAmount) {
		this.requestAmount = requestAmount;
	}

	/**
	 * @return the frecuency
	 */
	public String getFrecuency() {
		return frecuency;
	}

	/**
	 * @param frecuency the frecuency to set
	 */
	public void setFrecuency(String frecuency) {
		this.frecuency = frecuency;
	}

	/**
	 * @return the plazo
	 */
	public int getPlazo() {
		return plazo;
	}

	/**
	 * @param plazo the plazo to set
	 */
	public void setPlazo(int plazo) {
		this.plazo = plazo;
	}

	/**
	 * @return the assigned
	 */
	public boolean isAssigned() {
		return assigned;
	}

	/**
	 * @param assigned the assigned to set
	 */
	public void setAssigned(boolean assigned) {
		this.assigned = assigned;
	}

	
	/**
	 * @return the requestStatusKey
	 */
	public String getRequestStatusKey() {
		return requestStatusKey;
	}

	/**
	 * @param requestStatusKey the requestStatusKey to set
	 */
	public void setRequestStatusKey(String requestStatusKey) {
		this.requestStatusKey = requestStatusKey;
	}

	/**
	 * @return the requestStatusDesc
	 */
	public String getRequestStatusDesc() {
		return requestStatusDesc;
	}

	/**
	 * @param requestStatusDesc the requestStatusDesc to set
	 */
	public void setRequestStatusDesc(String requestStatusDesc) {
		this.requestStatusDesc = requestStatusDesc;
	}

	/**
	 * @return the userAssigned
	 */
	public String getUserAssigned() {
		return userAssigned;
	}

	/**
	 * @param userAssigned the userAssigned to set
	 */
	public void setUserAssigned(String userAssigned) {
		this.userAssigned = userAssigned;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
