/**
 * 
 */
package com.consubanco.sap.interfaces.debtBalanceInsurance;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author hsanchez
 *
 */
public class ZCRMSGDEU_UPDOSSEGDEUD_OutputData implements Serializable,
		IProxyOutputData {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5733394777292678952L;

	private boolean result = false;
	
	private String messages = null;
	
	/**
	 * 
	 */
	public ZCRMSGDEU_UPDOSSEGDEUD_OutputData() {
		super();
	}

	
	/**
	 * @return the result
	 */
	public boolean isResult() {
		return result;
	}


	/**
	 * @param result the result to set
	 */
	public void setResult(boolean result) {
		this.result = result;
	}


	/**
	 * @return the messages
	 */
	public String getMessages() {
		return messages;
	}


	/**
	 * @param messages the messages to set
	 */
	public void setMessages(String messages) {
		this.messages = messages;
	}


	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
