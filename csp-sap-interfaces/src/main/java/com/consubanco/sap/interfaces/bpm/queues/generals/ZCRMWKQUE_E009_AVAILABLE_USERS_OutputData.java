/**
 * 
 */
package com.consubanco.sap.interfaces.bpm.queues.generals;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consubanco.sap.interfaces.bpm.queues.models.ZM_CATEGORIAS_Model;
import com.consubanco.sap.interfaces.bpm.queues.models.ZM_CONVENIOS_Model;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author hsanchez
 *
 */
public class ZCRMWKQUE_E009_AVAILABLE_USERS_OutputData implements Serializable,
		IProxyOutputData {



	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;
	
	private String businessPartner = null;
	
	private String userName = null;
	
	private String name1 = null;
	
	private String name2 = null;
	
	private String lastName1 = null;
	
	private String lastName2 = null;
	
	private String areaKey = null;
	
	private String areaDesc = null;
	
	private String locationKey = null;
	
	private String locationDesc = null;
	
	private String experienceLevelKey = null;
	
	private String experienceLevelDesc = null;
	
	private String statusKey = null;
	
	private String statusDesc = null;
	
	private Date lastAssignationDate = null;
	
	private String lastAssignationHour = null;
	
	private int numberAssignedRequests = 0;
	
	private long waitingTimeMins = 0;
	
	private String convenioId = null;
	
	private String productCategoryId = null;
	
	private String sourceChannelId = null;
	
	private int maxNumberRecords = 0;
	
	private String lastUserAssigned = null;
	
	private ArrayList<ZM_CONVENIOS_Model> specializationConvenios = null;
	
	private ArrayList<ZM_CATEGORIAS_Model> specializationProductCategories = null;
	
	private ArrayList<String> sourceChannels = null;
	
	/**
	 * 
	 */
	public ZCRMWKQUE_E009_AVAILABLE_USERS_OutputData() {
		super();
	}

	/**
	 * @return the businessPartner
	 */
	public String getBusinessPartner() {
		return businessPartner;
	}

	/**
	 * @param businessPartner the businessPartner to set
	 */
	public void setBusinessPartner(String businessPartner) {
		this.businessPartner = businessPartner;
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
	 * @return the areaKey
	 */
	public String getAreaKey() {
		return areaKey;
	}

	/**
	 * @param areaKey the areaKey to set
	 */
	public void setAreaKey(String areaKey) {
		this.areaKey = areaKey;
	}

	/**
	 * @return the areaDesc
	 */
	public String getAreaDesc() {
		return areaDesc;
	}

	/**
	 * @param areaDesc the areaDesc to set
	 */
	public void setAreaDesc(String areaDesc) {
		this.areaDesc = areaDesc;
	}

	/**
	 * @return the locationKey
	 */
	public String getLocationKey() {
		return locationKey;
	}

	/**
	 * @param locationKey the locationKey to set
	 */
	public void setLocationKey(String locationKey) {
		this.locationKey = locationKey;
	}

	/**
	 * @return the locationDesc
	 */
	public String getLocationDesc() {
		return locationDesc;
	}

	/**
	 * @param locationDesc the locationDesc to set
	 */
	public void setLocationDesc(String locationDesc) {
		this.locationDesc = locationDesc;
	}

	/**
	 * @return the experienceLevelKey
	 */
	public String getExperienceLevelKey() {
		return experienceLevelKey;
	}

	/**
	 * @param experienceLevelKey the experienceLevelKey to set
	 */
	public void setExperienceLevelKey(String experienceLevelKey) {
		this.experienceLevelKey = experienceLevelKey;
	}

	/**
	 * @return the experienceLevelDesc
	 */
	public String getExperienceLevelDesc() {
		return experienceLevelDesc;
	}

	/**
	 * @param experienceLevelDesc the experienceLevelDesc to set
	 */
	public void setExperienceLevelDesc(String experienceLevelDesc) {
		this.experienceLevelDesc = experienceLevelDesc;
	}

	/**
	 * @return the statusKey
	 */
	public String getStatusKey() {
		return statusKey;
	}

	/**
	 * @param statusKey the statusKey to set
	 */
	public void setStatusKey(String statusKey) {
		this.statusKey = statusKey;
	}

	/**
	 * @return the statusDesc
	 */
	public String getStatusDesc() {
		return statusDesc;
	}

	/**
	 * @param statusDesc the statusDesc to set
	 */
	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
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
	 * @return the numberAssignedRequests
	 */
	public int getNumberAssignedRequests() {
		return numberAssignedRequests;
	}

	/**
	 * @param numberAssignedRequests the numberAssignedRequests to set
	 */
	public void setNumberAssignedRequests(int numberAssignedRequests) {
		this.numberAssignedRequests = numberAssignedRequests;
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
	 * @return the convenioId
	 */
	public String getConvenioId() {
		return convenioId;
	}

	/**
	 * @param convenioId the convenioId to set
	 */
	public void setConvenioId(String convenioId) {
		this.convenioId = convenioId;
	}

	/**
	 * @return the productCategoryId
	 */
	public String getProductCategoryId() {
		return productCategoryId;
	}

	/**
	 * @param productCategoryId the productCategoryId to set
	 */
	public void setProductCategoryId(String productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

	/**
	 * @return the sourceChannelId
	 */
	public String getSourceChannelId() {
		return sourceChannelId;
	}

	/**
	 * @param sourceChannelId the sourceChannelId to set
	 */
	public void setSourceChannelId(String sourceChannelId) {
		this.sourceChannelId = sourceChannelId;
	}

	/**
	 * @return the maxNumberRecords
	 */
	public int getMaxNumberRecords() {
		return maxNumberRecords;
	}

	/**
	 * @param maxNumberRecords the maxNumberRecords to set
	 */
	public void setMaxNumberRecords(int maxNumberRecords) {
		this.maxNumberRecords = maxNumberRecords;
	}

	/**
	 * @return the lastUserAssigned
	 */
	public String getLastUserAssigned() {
		return lastUserAssigned;
	}

	/**
	 * @param lastUserAssigned the lastUserAssigned to set
	 */
	public void setLastUserAssigned(String lastUserAssigned) {
		this.lastUserAssigned = lastUserAssigned;
	}

	/**
	 * @return the specializationConvenios
	 */
	public ArrayList<ZM_CONVENIOS_Model> getSpecializationConvenios() {
		return specializationConvenios;
	}

	/**
	 * @param specializationConvenios the specializationConvenios to set
	 */
	public void setSpecializationConvenios(
			ArrayList<ZM_CONVENIOS_Model> specializationConvenios) {
		this.specializationConvenios = specializationConvenios;
	}

	/**
	 * @return the specializationProductCategories
	 */
	public ArrayList<ZM_CATEGORIAS_Model> getSpecializationProductCategories() {
		return specializationProductCategories;
	}

	/**
	 * @param specializationProductCategories the specializationProductCategories to set
	 */
	public void setSpecializationProductCategories(
			ArrayList<ZM_CATEGORIAS_Model> specializationProductCategories) {
		this.specializationProductCategories = specializationProductCategories;
	}

	/**
	 * @return the sourceChannels
	 */
	public ArrayList<String> getSourceChannels() {
		return sourceChannels;
	}

	/**
	 * @param sourceChannels the sourceChannels to set
	 */
	public void setSourceChannels(ArrayList<String> sourceChannels) {
		this.sourceChannels = sourceChannels;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
