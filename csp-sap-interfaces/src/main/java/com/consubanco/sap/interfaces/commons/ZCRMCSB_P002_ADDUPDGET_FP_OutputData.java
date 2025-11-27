/**
 * 
 */
package com.consubanco.sap.interfaces.commons;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author user-admin
 *
 */
public class ZCRMCSB_P002_ADDUPDGET_FP_OutputData implements Serializable,
		IProxyOutputData {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String biometricsMessage;
	
	private String fingerPrintB64;
	
	private String photoB64;
	
	private boolean locked;

	/**
	 * 
	 */
	public ZCRMCSB_P002_ADDUPDGET_FP_OutputData() {
	}

	public String getBiometricsMessage() {
		return biometricsMessage;
	}

	public void setBiometricsMessage(String biometricsMessage) {
		this.biometricsMessage = biometricsMessage;
	}

	public String getFingerPrintB64() {
		return fingerPrintB64;
	}

	public void setFingerPrintB64(String fingerPrintB64) {
		this.fingerPrintB64 = fingerPrintB64;
	}

	public String getPhotoB64() {
		return photoB64;
	}

	public void setPhotoB64(String photoB64) {
		this.photoB64 = photoB64;
	}
	
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}

	/**
	 * @return the locked
	 */
	public boolean isLocked() {
		return locked;
	}

	/**
	 * @param locked the locked to set
	 */
	public void setLocked(boolean locked) {
		this.locked = locked;
	}
}
