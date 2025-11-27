/**
 * 
 */
package com.consubanco.sap.interfaces.common.survey.models;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author hsanchez
 *
 */
public class ZTE_SURVEY_Model implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7816106684033965379L;

	private String id = null;
	
	private String textInfo = null;
	
	private String version = null;
	
	private String masterLenguage = null;
	
	private String language = null;
	
	private String applicationId = null;
	
	private String bpId = null;
	
	private String valueGuid = null;
	
	private String valueVersion = null;
	
	private String valueVersionInfoText = null;
	
	private String valueXml = null;
	
	private String must = null;
	
	private String notChangeable = null;
	
	private String createdAt = null;
	
	private String createdBy = null;
	
	private String modifiedAt = null;
	
	private String modifiedBy = null;
	
	private String processMode = null;
    
	private String processText = null;
      
	private ArrayList<ZTL_QUESTION_Model> questions = null;		      
	
	/**
	 * 
	 */
	public ZTE_SURVEY_Model() {
		super();
	}

	


	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}




	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}




	/**
	 * @return the textInfo
	 */
	public String getTextInfo() {
		return textInfo;
	}




	/**
	 * @param textInfo the textInfo to set
	 */
	public void setTextInfo(String textInfo) {
		this.textInfo = textInfo;
	}




	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}




	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}




	/**
	 * @return the masterLenguage
	 */
	public String getMasterLenguage() {
		return masterLenguage;
	}




	/**
	 * @param masterLenguage the masterLenguage to set
	 */
	public void setMasterLenguage(String masterLenguage) {
		this.masterLenguage = masterLenguage;
	}




	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}




	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}




	/**
	 * @return the applicationId
	 */
	public String getApplicationId() {
		return applicationId;
	}




	/**
	 * @param applicationId the applicationId to set
	 */
	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}




	/**
	 * @return the bpId
	 */
	public String getBpId() {
		return bpId;
	}




	/**
	 * @param bpId the bpId to set
	 */
	public void setBpId(String bpId) {
		this.bpId = bpId;
	}




	/**
	 * @return the valueGuid
	 */
	public String getValueGuid() {
		return valueGuid;
	}




	/**
	 * @param valueGuid the valueGuid to set
	 */
	public void setValueGuid(String valueGuid) {
		this.valueGuid = valueGuid;
	}




	/**
	 * @return the valueVersion
	 */
	public String getValueVersion() {
		return valueVersion;
	}




	/**
	 * @param valueVersion the valueVersion to set
	 */
	public void setValueVersion(String valueVersion) {
		this.valueVersion = valueVersion;
	}




	/**
	 * @return the valueVersionInfoText
	 */
	public String getValueVersionInfoText() {
		return valueVersionInfoText;
	}




	/**
	 * @param valueVersionInfoText the valueVersionInfoText to set
	 */
	public void setValueVersionInfoText(String valueVersionInfoText) {
		this.valueVersionInfoText = valueVersionInfoText;
	}




	/**
	 * @return the valueXml
	 */
	public String getValueXml() {
		return valueXml;
	}




	/**
	 * @param valueXml the valueXml to set
	 */
	public void setValueXml(String valueXml) {
		this.valueXml = valueXml;
	}




	/**
	 * @return the must
	 */
	public String getMust() {
		return must;
	}




	/**
	 * @param must the must to set
	 */
	public void setMust(String must) {
		this.must = must;
	}




	/**
	 * @return the notChangeable
	 */
	public String getNotChangeable() {
		return notChangeable;
	}




	/**
	 * @param notChangeable the notChangeable to set
	 */
	public void setNotChangeable(String notChangeable) {
		this.notChangeable = notChangeable;
	}




	/**
	 * @return the createdAt
	 */
	public String getCreatedAt() {
		return createdAt;
	}




	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}




	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}




	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}




	/**
	 * @return the modifiedAt
	 */
	public String getModifiedAt() {
		return modifiedAt;
	}




	/**
	 * @param modifiedAt the modifiedAt to set
	 */
	public void setModifiedAt(String modifiedAt) {
		this.modifiedAt = modifiedAt;
	}




	/**
	 * @return the modifiedBy
	 */
	public String getModifiedBy() {
		return modifiedBy;
	}




	/**
	 * @param modifiedBy the modifiedBy to set
	 */
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}




	/**
	 * @return the processMode
	 */
	public String getProcessMode() {
		return processMode;
	}




	/**
	 * @param processMode the processMode to set
	 */
	public void setProcessMode(String processMode) {
		this.processMode = processMode;
	}




	/**
	 * @return the processText
	 */
	public String getProcessText() {
		return processText;
	}




	/**
	 * @param processText the processText to set
	 */
	public void setProcessText(String processText) {
		this.processText = processText;
	}




	/**
	 * @return the questions
	 */
	public ArrayList<ZTL_QUESTION_Model> getQuestions() {
		return questions;
	}




	/**
	 * @param questions the questions to set
	 */
	public void setQuestions(ArrayList<ZTL_QUESTION_Model> questions) {
		this.questions = questions;
	}




	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
