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
public class ZCRMORI_E053_GETCATREGFISCAL_OutputData implements Serializable,
		IProxyOutputData {



	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;

	private String key = null;
	
	private String description = null;
	
	
	
	/**
	 * 
	 */
	public ZCRMORI_E053_GETCATREGFISCAL_OutputData() {
		super();
	}

	
	



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






	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
