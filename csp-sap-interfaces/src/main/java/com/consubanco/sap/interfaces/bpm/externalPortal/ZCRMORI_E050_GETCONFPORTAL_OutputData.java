/**
 * 
 */
package com.consubanco.sap.interfaces.bpm.externalPortal;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consubanco.sap.interfaces.bpm.externalPortal.model.ZCRMORI_E050_GETCONFPORTAL_Model;
import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author jruribes
 *
 */
public class ZCRMORI_E050_GETCONFPORTAL_OutputData implements IProxyOutputData {

	private boolean success;
	private String message;
	private ZCRMORI_E050_GETCONFPORTAL_Model datosPortal;

	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * @param success
	 *            the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the datosPortal
	 */
	public ZCRMORI_E050_GETCONFPORTAL_Model getDatosPortal() {
		return datosPortal;
	}

	/**
	 * @param datosPortal
	 *            the datosPortal to set
	 */
	public void setDatosPortal(ZCRMORI_E050_GETCONFPORTAL_Model datosPortal) {
		this.datosPortal = datosPortal;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
