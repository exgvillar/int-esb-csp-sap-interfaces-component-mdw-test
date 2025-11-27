/**
 * 
 */
package com.consubanco.sap.interfaces.bpm.queues.mantto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consubanco.sap.interfaces.bpm.queues.models.ZM_WORKINGHOURS_Model;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author hsanchez
 *
 */
public class ZCRMWKQUE_P001_ADDUPDUSERSCOX_OutputData implements Serializable,
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
	
	private int breakTime = 0;
	
	private String statusKey = null;
	
	private String statusDesc = null;
	
	private String userLastUpdate = null;
	
	private Date lastUpdate = null;
	
	private ArrayList<ZM_WORKINGHOURS_Model> workingHoursList = null;
	
	private String rfcCrmMode = null;
	
	private boolean result = false;
	
	private String messages = null;
	
	/**
	 * 
	 */
	public ZCRMWKQUE_P001_ADDUPDUSERSCOX_OutputData() {
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
	 * @return the breakTime
	 */
	public int getBreakTime() {
		return breakTime;
	}


	/**
	 * @param breakTime the breakTime to set
	 */
	public void setBreakTime(int breakTime) {
		this.breakTime = breakTime;
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
	 * @return the userLastUpdate
	 */
	public String getUserLastUpdate() {
		return userLastUpdate;
	}


	/**
	 * @param userLastUpdate the userLastUpdate to set
	 */
	public void setUserLastUpdate(String userLastUpdate) {
		this.userLastUpdate = userLastUpdate;
	}


	/**
	 * @return the lastUpdate
	 */
	public Date getLastUpdate() {
		return lastUpdate;
	}


	/**
	 * @param lastUpdate the lastUpdate to set
	 */
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}


	/**
	 * @return the workingHoursList
	 */
	public ArrayList<ZM_WORKINGHOURS_Model> getWorkingHoursList() {
		return workingHoursList;
	}


	/**
	 * @param workingHoursList the workingHoursList to set
	 */
	public void setWorkingHoursList(
			ArrayList<ZM_WORKINGHOURS_Model> workingHoursList) {
		this.workingHoursList = workingHoursList;
	}

	

	/**
	 * @return the rfcCrmMode
	 */
	public String getRfcCrmMode() {
		return rfcCrmMode;
	}


	/**
	 * @param rfcCrmMode the rfcCrmMode to set
	 */
	public void setRfcCrmMode(String rfcCrmMode) {
		this.rfcCrmMode = rfcCrmMode;
	}


	/**
	 * @return the result
	 */
	public boolean isResult() {
		return result;
	}


	/**
	 * @param result the result to set
	 */
	public void setResult(boolean result) {
		this.result = result;
	}


	/**
	 * @return the messages
	 */
	public String getMessages() {
		return messages;
	}


	/**
	 * @param messages the messages to set
	 */
	public void setMessages(String messages) {
		this.messages = messages;
	}


	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
