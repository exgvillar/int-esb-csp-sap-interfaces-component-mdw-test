/**
 * 
 */
package com.consubanco.sap.interfaces.proxy.cm;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author hsanchez
 *
 */
public class ZCRMCOM_GET_INFOGLOB_OutputData implements Serializable,
		IProxyOutputData {



	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;

	private String branchId = null;
	
	private Date startDate = null;
	
	private Date endDate = null;
	
	private String branchShort = null;
	
	private int totalApplicationsPurchased = 0;
	
	private int totalApplicationsRejected = 0;
	
	private int totalApplicationsCancelled = 0;
	
	private int totalApplicationsProjected = 0;
	
	private double approvedRate = 0;
	
	private double amountApplicationsPurchased = 0;
	
	private double amountApplicationsRejected = 0;
	
	private double amountApplicationsCancelled = 0;
	
	private double amountApplicationsProjected = 0;
	
	
	private String message = null;
	
	
	/**
	 * 
	 */
	public ZCRMCOM_GET_INFOGLOB_OutputData() {
		super();
	}

	/**
	 * @return the branchId
	 */
	public String getBranchId() {
		return branchId;
	}

	/**
	 * @param branchId the branchId to set
	 */
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the branchShort
	 */
	public String getBranchShort() {
		return branchShort;
	}

	/**
	 * @param branchShort the branchShort to set
	 */
	public void setBranchShort(String branchShort) {
		this.branchShort = branchShort;
	}

	/**
	 * @return the totalApplicationsPurchased
	 */
	public int getTotalApplicationsPurchased() {
		return totalApplicationsPurchased;
	}

	/**
	 * @param totalApplicationsPurchased the totalApplicationsPurchased to set
	 */
	public void setTotalApplicationsPurchased(int totalApplicationsPurchased) {
		this.totalApplicationsPurchased = totalApplicationsPurchased;
	}

	/**
	 * @return the totalApplicationsRejected
	 */
	public int getTotalApplicationsRejected() {
		return totalApplicationsRejected;
	}

	/**
	 * @param totalApplicationsRejected the totalApplicationsRejected to set
	 */
	public void setTotalApplicationsRejected(int totalApplicationsRejected) {
		this.totalApplicationsRejected = totalApplicationsRejected;
	}

	/**
	 * @return the totalApplicationsCancelled
	 */
	public int getTotalApplicationsCancelled() {
		return totalApplicationsCancelled;
	}

	/**
	 * @param totalApplicationsCancelled the totalApplicationsCancelled to set
	 */
	public void setTotalApplicationsCancelled(int totalApplicationsCancelled) {
		this.totalApplicationsCancelled = totalApplicationsCancelled;
	}

	/**
	 * @return the totalApplicationsProjected
	 */
	public int getTotalApplicationsProjected() {
		return totalApplicationsProjected;
	}

	/**
	 * @param totalApplicationsProjected the totalApplicationsProjected to set
	 */
	public void setTotalApplicationsProjected(int totalApplicationsProjected) {
		this.totalApplicationsProjected = totalApplicationsProjected;
	}

	/**
	 * @return the approvedRate
	 */
	public double getApprovedRate() {
		return approvedRate;
	}

	/**
	 * @param approvedRate the approvedRate to set
	 */
	public void setApprovedRate(double approvedRate) {
		this.approvedRate = approvedRate;
	}

	/**
	 * @return the amountApplicationsPurchased
	 */
	public double getAmountApplicationsPurchased() {
		return amountApplicationsPurchased;
	}

	/**
	 * @param amountApplicationsPurchased the amountApplicationsPurchased to set
	 */
	public void setAmountApplicationsPurchased(double amountApplicationsPurchased) {
		this.amountApplicationsPurchased = amountApplicationsPurchased;
	}

	/**
	 * @return the amountApplicationsRejected
	 */
	public double getAmountApplicationsRejected() {
		return amountApplicationsRejected;
	}

	/**
	 * @param amountApplicationsRejected the amountApplicationsRejected to set
	 */
	public void setAmountApplicationsRejected(double amountApplicationsRejected) {
		this.amountApplicationsRejected = amountApplicationsRejected;
	}

	/**
	 * @return the amountApplicationsCancelled
	 */
	public double getAmountApplicationsCancelled() {
		return amountApplicationsCancelled;
	}

	/**
	 * @param amountApplicationsCancelled the amountApplicationsCancelled to set
	 */
	public void setAmountApplicationsCancelled(double amountApplicationsCancelled) {
		this.amountApplicationsCancelled = amountApplicationsCancelled;
	}

	/**
	 * @return the amountApplicationsProjected
	 */
	public double getAmountApplicationsProjected() {
		return amountApplicationsProjected;
	}

	/**
	 * @param amountApplicationsProjected the amountApplicationsProjected to set
	 */
	public void setAmountApplicationsProjected(double amountApplicationsProjected) {
		this.amountApplicationsProjected = amountApplicationsProjected;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
