package com.consubanco.sap.interfaces.digital.app.common;
/**
 * 
 */


import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author hsanchez
 *
 */
public class ZCRMCMM_E001_GET_TRMCND_BY_BP_OutputData implements Serializable,
		IProxyOutputData {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8013627703464501130L;

	private boolean termsConditionsAccepted = false;
	
	private Date createDate = null;
	
	private Date updateDate = null;
	
	private String message = null;
		
	/**
	 * 
	 */
	public ZCRMCMM_E001_GET_TRMCND_BY_BP_OutputData() {
		super();
	}

	/**
	 * @return the termsConditionsAccepted
	 */
	public boolean isTermsConditionsAccepted() {
		return termsConditionsAccepted;
	}

	/**
	 * @param termsConditionsAccepted the termsConditionsAccepted to set
	 */
	public void setTermsConditionsAccepted(boolean termsConditionsAccepted) {
		this.termsConditionsAccepted = termsConditionsAccepted;
	}

	/**
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return the updateDate
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * @param updateDate the updateDate to set
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
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
