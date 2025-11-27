/**
 * 
 */
package com.consupago.sap.interfaces.proxy.ivr;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author haydee.sanchez
 *
 */
public class ZRFC_IVR_GET_CREDITS_OutputData implements Serializable,
		IProxyOutputData {



	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;

	private ArrayList<TE_CREDITREQUEST_OutputData> creditRequests = null;
	
	private ArrayList<TE_MESSAGE_OutputData> messages = null;
	
	
	
	
	/**
	 * 
	 */
	public ZRFC_IVR_GET_CREDITS_OutputData() {
		super();
	}

	


	/**
	 * @return the creditRequests
	 */
	public ArrayList<TE_CREDITREQUEST_OutputData> getCreditRequests() {
		return creditRequests;
	}




	/**
	 * @param creditRequests the creditRequests to set
	 */
	public void setCreditRequests(
			ArrayList<TE_CREDITREQUEST_OutputData> creditRequests) {
		this.creditRequests = creditRequests;
	}




	/**
	 * @return the messages
	 */
	public ArrayList<TE_MESSAGE_OutputData> getMessages() {
		return messages;
	}


	/**
	 * @param messages the messages to set
	 */
	public void setMessages(ArrayList<TE_MESSAGE_OutputData> messages) {
		this.messages = messages;
	}


	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
