/**
 * 
 */
package com.consubanco.sap.interfaces.sic;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author hsanchez
 *
 */
public class ZUT_PHONE_OutputData implements Serializable,
		IProxyOutputData {



	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;

	private String number = null;
	
	private String extension = null; 
	
	private String phoneType = null;
	
	
	
	/**
	 * 
	 */
	public ZUT_PHONE_OutputData() {
		super();
	}

	




	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}






	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}






	/**
	 * @return the extension
	 */
	public String getExtension() {
		return extension;
	}






	/**
	 * @param extension the extension to set
	 */
	public void setExtension(String extension) {
		this.extension = extension;
	}






	/**
	 * @return the phoneType
	 */
	public String getPhoneType() {
		return phoneType;
	}




	/**
	 * @param phoneType the phoneType to set
	 */
	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}




	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
