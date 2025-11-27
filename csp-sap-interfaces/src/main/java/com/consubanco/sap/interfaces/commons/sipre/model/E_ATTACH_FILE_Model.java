package com.consubanco.sap.interfaces.commons.sipre.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class E_ATTACH_FILE_Model implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1084582723397830339L;
	private String fileName;
	private String base64;
	
	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}
	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
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
