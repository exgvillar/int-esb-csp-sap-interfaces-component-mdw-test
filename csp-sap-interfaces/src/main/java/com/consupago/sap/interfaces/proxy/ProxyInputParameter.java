/**
 * 
 */
package com.consupago.sap.interfaces.proxy;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author ramon.becerra
 *
 */
public class ProxyInputParameter implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7666895722076799778L;

	private String key = null;
	
	private String type = null;
	
	private String value = null;
	
	private Date dateValue = null;
	
	/**
	 * 
	 */
	public ProxyInputParameter() {
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
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
	

	/**
	 * @return the dateValue
	 */
	public Date getDateValue() {
		return dateValue;
	}

	/**
	 * @param dateValue the dateValue to set
	 */
	public void setDateValue(Date dateValue) {
		this.dateValue = dateValue;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
	
}
