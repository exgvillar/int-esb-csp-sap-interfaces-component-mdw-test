/**
 * 
 */
package com.consubanco.sap.interfaces.recommender.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author Ing. Adrian Alejo
 * 
 */
public class ServiceOrderModel implements Serializable {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;
	private String serviceOrderId;
	private String recommenderBp;
	private String employeeBp;
	private String recommendedBp;
	private String folioApplication;
	private String sourceChannel;
	private double amount;
	private String observations;
	private List<String> motives;
	private Date periodStartDate;
	private Date periodEndDate;
	private String cellPhone;
	private String completeName;
	private String paymentRTSMConcept;
	private String rtsmCode;

	/**
	 * @return the serviceOrderId
	 */
	public String getServiceOrderId() {
		return serviceOrderId;
	}

	/**
	 * @param serviceOrderId
	 *            the serviceOrderId to set
	 */
	public void setServiceOrderId(String serviceOrderId) {
		this.serviceOrderId = serviceOrderId;
	}

	/**
	 * @return the recommenderBp
	 */
	public String getRecommenderBp() {
		return recommenderBp;
	}

	/**
	 * @param recommenderBp
	 *            the recommenderBp to set
	 */
	public void setRecommenderBp(String recommenderBp) {
		this.recommenderBp = recommenderBp;
	}

	/**
	 * @return the employeeBp
	 */
	public String getEmployeeBp() {
		return employeeBp;
	}

	/**
	 * @param employeeBp
	 *            the employeeBp to set
	 */
	public void setEmployeeBp(String employeeBp) {
		this.employeeBp = employeeBp;
	}

	/**
	 * @return the recommendedBp
	 */
	public String getRecommendedBp() {
		return recommendedBp;
	}

	/**
	 * @param recommendedBp
	 *            the recommendedBp to set
	 */
	public void setRecommendedBp(String recommendedBp) {
		this.recommendedBp = recommendedBp;
	}

	/**
	 * @return the folioApplication
	 */
	public String getFolioApplication() {
		return folioApplication;
	}

	/**
	 * @param folioApplication
	 *            the folioApplication to set
	 */
	public void setFolioApplication(String folioApplication) {
		this.folioApplication = folioApplication;
	}

	/**
	 * @return the sourceChannel
	 */
	public String getSourceChannel() {
		return sourceChannel;
	}

	/**
	 * @param sourceChannel
	 *            the sourceChannel to set
	 */
	public void setSourceChannel(String sourceChannel) {
		this.sourceChannel = sourceChannel;
	}

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * @return the observations
	 */
	public String getObservations() {
		return observations;
	}

	/**
	 * @param observations
	 *            the observations to set
	 */
	public void setObservations(String observations) {
		this.observations = observations;
	}

	/**
	 * @return the motives
	 */
	public List<String> getMotives() {
		return motives;
	}

	/**
	 * @param motives
	 *            the motives to set
	 */
	public void setMotives(List<String> motives) {
		this.motives = motives;
	}

	/**
	 * @return the periodStartDate
	 */
	public Date getPeriodStartDate() {
		return periodStartDate;
	}

	/**
	 * @param periodStartDate
	 *            the periodStartDate to set
	 */
	public void setPeriodStartDate(Date periodStartDate) {
		this.periodStartDate = periodStartDate;
	}

	/**
	 * @return the periodEndDate
	 */
	public Date getPeriodEndDate() {
		return periodEndDate;
	}

	/**
	 * @param periodEndDate
	 *            the periodEndDate to set
	 */
	public void setPeriodEndDate(Date periodEndDate) {
		this.periodEndDate = periodEndDate;
	}

	/**
	 * @return the cellPhone
	 */
	public String getCellPhone() {
		return cellPhone;
	}

	/**
	 * @param cellPhone
	 *            the cellPhone to set
	 */
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	/**
	 * @return the completeName
	 */
	public String getCompleteName() {
		return completeName;
	}

	/**
	 * @param completeName
	 *            the completeName to set
	 */
	public void setCompleteName(String completeName) {
		this.completeName = completeName;
	}

	/**
	 * @return the paymentRTSMConcept
	 */
	public String getPaymentRTSMConcept() {
		return paymentRTSMConcept;
	}

	/**
	 * @param paymentRTSMConcept
	 *            the paymentRTSMConcept to set
	 */
	public void setPaymentRTSMConcept(String paymentRTSMConcept) {
		this.paymentRTSMConcept = paymentRTSMConcept;
	}

	/**
	 * @return the rtsmCode
	 */
	public String getRtsmCode() {
		return rtsmCode;
	}

	/**
	 * @param rtsmCode
	 *            the rtsmCode to set
	 */
	public void setRtsmCode(String rtsmCode) {
		this.rtsmCode = rtsmCode;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
