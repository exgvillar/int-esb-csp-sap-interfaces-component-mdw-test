/**
 * 
 */
package com.consubanco.sap.interfaces.cxn.followup;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author ramon.becerra
 *
 */
public class ZRFC_FOLLOWUP_OutputData implements Serializable,
		IProxyOutputData {


	private String requestId = null;
	
	private String caseId = null;
	
	private String opportunityId = null;
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;

		
	
	/**
	 * 
	 */
	public ZRFC_FOLLOWUP_OutputData() {
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
	 * @return the caseId
	 */
	public String getCaseId() {
		return caseId;
	}




	/**
	 * @param caseId the caseId to set
	 */
	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}




	/**
	 * @return the opportunityId
	 */
	public String getOpportunityId() {
		return opportunityId;
	}




	/**
	 * @param opportunityId the opportunityId to set
	 */
	public void setOpportunityId(String opportunityId) {
		this.opportunityId = opportunityId;
	}




	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
