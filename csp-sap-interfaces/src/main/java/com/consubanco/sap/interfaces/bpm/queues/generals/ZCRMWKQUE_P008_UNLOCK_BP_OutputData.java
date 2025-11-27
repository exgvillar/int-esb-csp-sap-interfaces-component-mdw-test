/**
 * 
 */
package com.consubanco.sap.interfaces.bpm.queues.generals;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author omar.corona
 *
 */
public class ZCRMWKQUE_P008_UNLOCK_BP_OutputData implements Serializable,
		IProxyOutputData {



	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;

	private boolean success = false;
	
	private String message = null;
	
	private ArrayList<String> usersCox = null;
	
	/**
	 * 
	 */
	public ZCRMWKQUE_P008_UNLOCK_BP_OutputData() {
		super();
	}

	

	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}



	/**
	 * @param success the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
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



	/**
	 * @return the usersCox
	 */
	public ArrayList<String> getUsersCox() {
		return usersCox;
	}



	/**
	 * @param usersCox the usersCox to set
	 */
	public void setUsersCox(ArrayList<String> usersCox) {
		this.usersCox = usersCox;
	}



	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
