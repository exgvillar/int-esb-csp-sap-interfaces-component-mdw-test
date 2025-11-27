/**
 * 
 */
package com.consubanco.sap.interfaces.common.terminados;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author estefania.montoya
 *
 */
public class ZCRMCRT_P001_SAVE_CONYUGE_OutputData implements Serializable, IProxyOutputData {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5394952687443795869L;

	private String bp;

	private boolean success;

	private String message;

	/**
	 * @return the bp
	 */
	public String getBp() {
		return bp;
	}

	/**
	 * @param bp
	 *            the bp to set
	 */
	public void setBp(String bp) {
		this.bp = bp;
	}

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

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
