/**
 * 
 */
package com.consubanco.sap.interfaces.commons;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author ramon.becerra
 *
 */
public class ZCRMCSB_P004_ADDUPDBP_OutputData implements Serializable,
		IProxyOutputData {



	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;

	private String bpId = null;
	
	private String clientId = null;
	
	private String errorMessage = null; 
	
	private boolean successFlag;
	
	
	
	/**
	 * 
	 */
	public ZCRMCSB_P004_ADDUPDBP_OutputData() {
		super();
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
	 * @return the clientId
	 */
	public String getClientId() {
		return clientId;
	}





	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}





	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}




	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}




	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}




	/**
	 * @return the successFlag
	 */
	public boolean isSuccessFlag() {
		return successFlag;
	}




	/**
	 * @param successFlag the successFlag to set
	 */
	public void setSuccessFlag(boolean successFlag) {
		this.successFlag = successFlag;
	}
}
