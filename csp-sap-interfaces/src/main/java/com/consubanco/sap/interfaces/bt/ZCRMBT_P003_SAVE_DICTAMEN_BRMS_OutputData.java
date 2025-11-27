/**
 * 
 */
package com.consubanco.sap.interfaces.bt;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * 
 * @author <a href="mailto:juribe@consubanco.com">juribe</a>
 * 
 */
public class ZCRMBT_P003_SAVE_DICTAMEN_BRMS_OutputData implements Serializable,
		IProxyOutputData {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3152881884494080135L;

	private boolean success;
	private String message;

	/**
	 * 
	 */
	public ZCRMBT_P003_SAVE_DICTAMEN_BRMS_OutputData() {
		super();
	}

	/**
	 * @param success
	 * @param message
	 */
	public ZCRMBT_P003_SAVE_DICTAMEN_BRMS_OutputData(boolean success,
			String message) {
		super();
		this.success = success;
		this.message = message;
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
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
