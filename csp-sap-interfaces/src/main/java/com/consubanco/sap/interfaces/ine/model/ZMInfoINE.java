package com.consubanco.sap.interfaces.ine.model;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class ZMInfoINE implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6301429439174581334L;
	private String voterId;
	private String stateId;
	private String registrationYear;
	private String issueNumber;
	private String issueYear;
	private String validityYear;
	private String cic;
	private String ocr;
	private String mechanicalReading;
	private String portalCode;
	private String city;
	private String curp;
	private List<ZMFile> files;

	
	/**
	 * @return the portalCode
	 */
	public String getPortalCode() {
		return portalCode;
	}
	/**
	 * @param portalCode the portalCode to set
	 */
	public void setPortalCode(String portalCode) {
		this.portalCode = portalCode;
	}
	/**
	 * @return the voterId
	 */
	public String getVoterId() {
		return voterId;
	}
	/**
	 * @param voterId the voterId to set
	 */
	public void setVoterId(String voterId) {
		this.voterId = voterId;
	}
	/**
	 * @return the stateId
	 */
	public String getStateId() {
		return stateId;
	}
	/**
	 * @param stateId the stateId to set
	 */
	public void setStateId(String stateId) {
		this.stateId = stateId;
	}
	/**
	 * @return the registrationYear
	 */
	public String getRegistrationYear() {
		return registrationYear;
	}
	/**
	 * @param registrationYear the registrationYear to set
	 */
	public void setRegistrationYear(String registrationYear) {
		this.registrationYear = registrationYear;
	}
	/**
	 * @return the issueNumber
	 */
	public String getIssueNumber() {
		return issueNumber;
	}
	/**
	 * @param issueNumber the issueNumber to set
	 */
	public void setIssueNumber(String issueNumber) {
		this.issueNumber = issueNumber;
	}
	/**
	 * @return the issueYear
	 */
	public String getIssueYear() {
		return issueYear;
	}
	/**
	 * @param issueYear the issueYear to set
	 */
	public void setIssueYear(String issueYear) {
		this.issueYear = issueYear;
	}
	/**
	 * @return the validityYear
	 */
	public String getValidityYear() {
		return validityYear;
	}
	/**
	 * @param validityYear the validityYear to set
	 */
	public void setValidityYear(String validityYear) {
		this.validityYear = validityYear;
	}
	/**
	 * @return the cic
	 */
	public String getCic() {
		return cic;
	}
	/**
	 * @param cic the cic to set
	 */
	public void setCic(String cic) {
		this.cic = cic;
	}
	/**
	 * @return the ocr
	 */
	public String getOcr() {
		return ocr;
	}
	/**
	 * @param ocr the ocr to set
	 */
	public void setOcr(String ocr) {
		this.ocr = ocr;
	}
	/**
	 * @return the mechanicalReading
	 */
	public String getMechanicalReading() {
		return mechanicalReading;
	}
	/**
	 * @param mechanicalReading the mechanicalReading to set
	 */
	public void setMechanicalReading(String mechanicalReading) {
		this.mechanicalReading = mechanicalReading;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the curp
	 */
	public String getCurp() {
		return curp;
	}
	/**
	 * @param curp the curp to set
	 */
	public void setCurp(String curp) {
		this.curp = curp;
	}
	/**
	 * @return the files
	 */
	public List<ZMFile> getFiles() {
		return files;
	}
	/**
	 * @param files the files to set
	 */
	public void setFiles(List<ZMFile> files) {
		this.files = files;
	}
	
    @Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
