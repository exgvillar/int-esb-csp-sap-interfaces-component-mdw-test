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
public class ZM_COMPETITOR_Model implements Serializable,
		IProxyOutputData {



	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;

	private String serviceOrderId = null;
	
	private String serviceOrderType = null;
	
	private String statusSOId =  null;
	
	private String statusSODesc =  null;

	private String competitorBp = null;
	
	private String competitorName = null;
	
	private Date emissionDate = null;
	
	private Date expirationDate = null;
	
	private Date lastDiscountDate = null;
	
	private double amount = 0;
	
	private String paymentMethodId = null;
	
	private String paymentMethodDesc = null;
	
	private Date approvedDate = null;
	
	private double discountAmount = 0;
	
	private String taskCrmId = null;
	
	private String taskCrmDesc = null;
	
	/**
	 * 
	 */
	public ZM_COMPETITOR_Model() {
		super();
	}


	/**
	 * @return the serviceOrderId
	 */
	public String getServiceOrderId() {
		return serviceOrderId;
	}


	/**
	 * @param serviceOrderId the serviceOrderId to set
	 */
	public void setServiceOrderId(String serviceOrderId) {
		this.serviceOrderId = serviceOrderId;
	}


	/**
	 * @return the serviceOrderType
	 */
	public String getServiceOrderType() {
		return serviceOrderType;
	}


	/**
	 * @param serviceOrderType the serviceOrderType to set
	 */
	public void setServiceOrderType(String serviceOrderType) {
		this.serviceOrderType = serviceOrderType;
	}


	/**
	 * @return the statusSOId
	 */
	public String getStatusSOId() {
		return statusSOId;
	}


	/**
	 * @param statusSOId the statusSOId to set
	 */
	public void setStatusSOId(String statusSOId) {
		this.statusSOId = statusSOId;
	}


	/**
	 * @return the statusSODesc
	 */
	public String getStatusSODesc() {
		return statusSODesc;
	}


	/**
	 * @param statusSODesc the statusSODesc to set
	 */
	public void setStatusSODesc(String statusSODesc) {
		this.statusSODesc = statusSODesc;
	}


	/**
	 * @return the competitorBp
	 */
	public String getCompetitorBp() {
		return competitorBp;
	}


	/**
	 * @param competitorBp the competitorBp to set
	 */
	public void setCompetitorBp(String competitorBp) {
		this.competitorBp = competitorBp;
	}


	/**
	 * @return the competitorName
	 */
	public String getCompetitorName() {
		return competitorName;
	}


	/**
	 * @param competitorName the competitorName to set
	 */
	public void setCompetitorName(String competitorName) {
		this.competitorName = competitorName;
	}


	/**
	 * @return the emissionDate
	 */
	public Date getEmissionDate() {
		return emissionDate;
	}


	/**
	 * @param emissionDate the emissionDate to set
	 */
	public void setEmissionDate(Date emissionDate) {
		this.emissionDate = emissionDate;
	}


	/**
	 * @return the expirationDate
	 */
	public Date getExpirationDate() {
		return expirationDate;
	}


	/**
	 * @param expirationDate the expirationDate to set
	 */
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}


	/**
	 * @return the lastDiscountDate
	 */
	public Date getLastDiscountDate() {
		return lastDiscountDate;
	}


	/**
	 * @param lastDiscountDate the lastDiscountDate to set
	 */
	public void setLastDiscountDate(Date lastDiscountDate) {
		this.lastDiscountDate = lastDiscountDate;
	}


	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}


	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}


	/**
	 * @return the paymentMethodId
	 */
	public String getPaymentMethodId() {
		return paymentMethodId;
	}


	/**
	 * @param paymentMethodId the paymentMethodId to set
	 */
	public void setPaymentMethodId(String paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}


	/**
	 * @return the paymentMethodDesc
	 */
	public String getPaymentMethodDesc() {
		return paymentMethodDesc;
	}


	/**
	 * @param paymentMethodDesc the paymentMethodDesc to set
	 */
	public void setPaymentMethodDesc(String paymentMethodDesc) {
		this.paymentMethodDesc = paymentMethodDesc;
	}


	/**
	 * @return the approvedDate
	 */
	public Date getApprovedDate() {
		return approvedDate;
	}


	/**
	 * @param approvedDate the approvedDate to set
	 */
	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}


	/**
	 * @return the discountAmount
	 */
	public double getDiscountAmount() {
		return discountAmount;
	}


	/**
	 * @param discountAmount the discountAmount to set
	 */
	public void setDiscountAmount(double discountAmount) {
		this.discountAmount = discountAmount;
	}


	/**
	 * @return the taskCrmId
	 */
	public String getTaskCrmId() {
		return taskCrmId;
	}


	/**
	 * @param taskCrmId the taskCrmId to set
	 */
	public void setTaskCrmId(String taskCrmId) {
		this.taskCrmId = taskCrmId;
	}


	/**
	 * @return the taskCrmDesc
	 */
	public String getTaskCrmDesc() {
		return taskCrmDesc;
	}


	/**
	 * @param taskCrmDesc the taskCrmDesc to set
	 */
	public void setTaskCrmDesc(String taskCrmDesc) {
		this.taskCrmDesc = taskCrmDesc;
	}


	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
