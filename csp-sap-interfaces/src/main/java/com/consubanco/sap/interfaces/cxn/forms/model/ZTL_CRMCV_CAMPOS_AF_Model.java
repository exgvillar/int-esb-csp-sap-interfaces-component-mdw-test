/**
 * 
 */
package com.consubanco.sap.interfaces.cxn.forms.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author rbecerra
 *
 */
public class ZTL_CRMCV_CAMPOS_AF_Model implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2964962166008427160L;

	private String id = null;
	
	private String value = null;
	
	private int format = 0;
	
	private int spacing = 0;
	
	private int type = 0;
	
	/**
	 * 
	 */
	public ZTL_CRMCV_CAMPOS_AF_Model() {
		super();
	}

	

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
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
	 * @return the format
	 */
	public int getFormat() {
		return format;
	}



	/**
	 * @param format the format to set
	 */
	public void setFormat(int format) {
		this.format = format;
	}



	/**
	 * @return the spacing
	 */
	public int getSpacing() {
		return spacing;
	}



	/**
	 * @param spacing the spacing to set
	 */
	public void setSpacing(int spacing) {
		this.spacing = spacing;
	}



	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}



	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}



	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
