/**
 * 
 */
package com.consubanco.sap.interfaces.bt.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author hsanchez
 *
 */
public class ZTL_PHONE_Model implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2964962166008427160L;

	private String addressType = null;
	
	private String phoneType = null;
	
	private String phoneNumber = null;	
	/**
	 * 
	 */
	public ZTL_PHONE_Model() {
		super();
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public String getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
