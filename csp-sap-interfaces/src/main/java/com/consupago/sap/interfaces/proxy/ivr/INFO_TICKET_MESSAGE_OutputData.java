package com.consupago.sap.interfaces.proxy.ivr;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * 
 * @author juribe
 *
 */
public class INFO_TICKET_MESSAGE_OutputData implements Serializable,
		IProxyOutputData {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private String key = null;

	private String description = null;

	private String clasification = null;

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the clasification
	 */
	public String getClasification() {
		return clasification;
	}

	/**
	 * @param clasification the clasification to set
	 */
	public void setClasification(String clasification) {
		this.clasification = clasification;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
