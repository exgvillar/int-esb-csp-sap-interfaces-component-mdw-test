/**
 * 
 */
package com.consubanco.sap.interfaces.massiveLoad;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public class ZCRMORIG_P002_ATTACHDOCS_OutputData implements Serializable,
		IProxyOutputData {

	/**
	* 
	*/
	private static final long serialVersionUID = 8153413843042941014L;

	private String url = null;
	
	private boolean success = false;
	
	private String message = null; 

	/**
* 
*/
	public ZCRMORIG_P002_ATTACHDOCS_OutputData() {
		super();
	}

	
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}


	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}


	/**
	 * @param success the success to set
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
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}


	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
