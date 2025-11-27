package com.consubanco.sap.interfaces.ine.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class ZMFile implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6557490677376649426L;
	private String name;
	private String base64;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the base64
	 */
	public String getBase64() {
		return base64;
	}
	/**
	 * @param base64 the base64 to set
	 */
	public void setBase64(String base64) {
		this.base64 = base64;
	}
	
    @Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
