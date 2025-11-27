/**
 * 
 */
package com.consupago.sap.interfaces.proxy.ivr;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author haydee.sanchez
 *
 */
public class TE_CREDITREQUEST_OutputData implements Serializable,
		IProxyOutputData {



	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;

	private String creditRequestId = null;
	
	private String statusId = null;
	
	private String status = null; 
	
	private Date creditDateRequest = null;
	
	private Date lastDateStatus = null;
	
	private double requestedAmount = 0;
	
	private String siglaCompany = null;
	
	private String company = null;
	
	private ArrayList<TE_INCIDENCE_OutputData> incidences = null;	
	
	
	
	/**
	 * 
	 */
	public TE_CREDITREQUEST_OutputData() {
		super();
	}

	
	

	/**
	 * @return the creditRequestId
	 */
	public String getCreditRequestId() {
		return creditRequestId;
	}




	/**
	 * @param creditRequestId the creditRequestId to set
	 */
	public void setCreditRequestId(String creditRequestId) {
		this.creditRequestId = creditRequestId;
	}




	/**
	 * @return the statusId
	 */
	public String getStatusId() {
		return statusId;
	}




	/**
	 * @param statusId the statusId to set
	 */
	public void setStatusId(String statusId) {
		this.statusId = statusId;
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




	/**
	 * @return the creditDateRequest
	 */
	public Date getCreditDateRequest() {
		return creditDateRequest;
	}




	/**
	 * @param creditDateRequest the creditDateRequest to set
	 */
	public void setCreditDateRequest(Date creditDateRequest) {
		this.creditDateRequest = creditDateRequest;
	}




	/**
	 * @return the lastDateStatus
	 */
	public Date getLastDateStatus() {
		return lastDateStatus;
	}




	/**
	 * @param lastDateStatus the lastDateStatus to set
	 */
	public void setLastDateStatus(Date lastDateStatus) {
		this.lastDateStatus = lastDateStatus;
	}

	

	/**
	 * @return the requestedAmount
	 */
	public double getRequestedAmount() {
		return requestedAmount;
	}




	/**
	 * @param requestedAmount the requestedAmount to set
	 */
	public void setRequestedAmount(double requestedAmount) {
		this.requestedAmount = requestedAmount;
	}




	/**
	 * @return the siglaCompany
	 */
	public String getSiglaCompany() {
		return siglaCompany;
	}




	/**
	 * @param siglaCompany the siglaCompany to set
	 */
	public void setSiglaCompany(String siglaCompany) {
		this.siglaCompany = siglaCompany;
	}




	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}




	/**
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}




	/**
	 * @return the incidences
	 */
	public ArrayList<TE_INCIDENCE_OutputData> getIncidences() {
		return incidences;
	}




	/**
	 * @param incidences the incidences to set
	 */
	public void setIncidences(ArrayList<TE_INCIDENCE_OutputData> incidences) {
		this.incidences = incidences;
	}




	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
