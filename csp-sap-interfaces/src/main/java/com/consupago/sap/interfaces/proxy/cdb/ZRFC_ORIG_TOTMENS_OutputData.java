/**
 * 
 */
package com.consupago.sap.interfaces.proxy.cdb;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author haydee.sanchez
 *
 */
public class ZRFC_ORIG_TOTMENS_OutputData implements Serializable,
		IProxyOutputData {



	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;

	private double cumulativeAmount = 0;
	
	private int requestsNumber = 0;
	
	private String brmsConvenio_id = null;
	
	private ArrayList<TE_MESSAGE_OutputData> messages = null;
	
	
	
	
	/**
	 * 
	 */
	public ZRFC_ORIG_TOTMENS_OutputData() {
		super();
	}

	
	

	/**
	 * @return the cumulativeAmount
	 */
	public double getCumulativeAmount() {
		return cumulativeAmount;
	}




	/**
	 * @param cumulativeAmount the cumulativeAmount to set
	 */
	public void setCumulativeAmount(double cumulativeAmount) {
		this.cumulativeAmount = cumulativeAmount;
	}




	/**
	 * @return the requestsNumber
	 */
	public int getRequestsNumber() {
		return requestsNumber;
	}




	/**
	 * @param requestsNumber the requestsNumber to set
	 */
	public void setRequestsNumber(int requestsNumber) {
		this.requestsNumber = requestsNumber;
	}




	/**
	 * @return the brmsConvenio_id
	 */
	public String getBrmsConvenio_id() {
		return brmsConvenio_id;
	}




	/**
	 * @param brmsConvenioId the brmsConvenio_id to set
	 */
	public void setBrmsConvenio_id(String brmsConvenioId) {
		brmsConvenio_id = brmsConvenioId;
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
