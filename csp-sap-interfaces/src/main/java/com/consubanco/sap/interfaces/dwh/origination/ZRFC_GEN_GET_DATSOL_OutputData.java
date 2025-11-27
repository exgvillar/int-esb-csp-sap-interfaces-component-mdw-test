/**
 * 
 */
package com.consubanco.sap.interfaces.dwh.origination;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author ramon.becerra
 *
 */
public class ZRFC_GEN_GET_DATSOL_OutputData implements Serializable,
		IProxyOutputData {


	/**
	 * 
	 */
	private static final long serialVersionUID = -6524657356090921950L;

	private String requestId = null;
	
	private String statusId = null;
	
	private String statusDescription = null;
	
	private Date requestDate = null;
	
	private Date lastStatusDate = null;
	
	private double requestedAmount = 0;
	
	private String siglaEmpresa = null;
	
	private String nombreEmpresa = null;

	
	
	
	/**
	 * 
	 */
	public ZRFC_GEN_GET_DATSOL_OutputData() {
		super();
	}

	
	
	


	/**
	 * @return the requestId
	 */
	public String getRequestId() {
		return requestId;
	}






	/**
	 * @param requestId the requestId to set
	 */
	public void setRequestId(String requestId) {
		this.requestId = requestId;
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
	 * @return the statusDescription
	 */
	public String getStatusDescription() {
		return statusDescription;
	}






	/**
	 * @param statusDescription the statusDescription to set
	 */
	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}






	/**
	 * @return the requestDate
	 */
	public Date getRequestDate() {
		return requestDate;
	}






	/**
	 * @param requestDate the requestDate to set
	 */
	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}







	/**
	 * @return the lastStatusDate
	 */
	public Date getLastStatusDate() {
		return lastStatusDate;
	}






	/**
	 * @param lastStatusDate the lastStatusDate to set
	 */
	public void setLastStatusDate(Date lastStatusDate) {
		this.lastStatusDate = lastStatusDate;
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
	 * @return the siglaEmpresa
	 */
	public String getSiglaEmpresa() {
		return siglaEmpresa;
	}






	/**
	 * @param siglaEmpresa the siglaEmpresa to set
	 */
	public void setSiglaEmpresa(String siglaEmpresa) {
		this.siglaEmpresa = siglaEmpresa;
	}






	/**
	 * @return the nombreEmpresa
	 */
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}






	/**
	 * @param nombreEmpresa the nombreEmpresa to set
	 */
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}






	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
