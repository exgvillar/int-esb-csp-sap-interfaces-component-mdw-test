/**
 * 
 */
package com.consubanco.sap.interfaces.commons;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author <a href="mailto:juribe@consubanco.com">juribe</a>
 *
 */
public class ZCRMCSB_P002_LOCK_BP_OutputData implements IProxyOutputData, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;
	/**
	 * 
	 */
	public ZCRMCSB_P002_LOCK_BP_OutputData() {
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
