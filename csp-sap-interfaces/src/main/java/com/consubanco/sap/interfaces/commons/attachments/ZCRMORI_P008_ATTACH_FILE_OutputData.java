/**
 * 
 */
package com.consubanco.sap.interfaces.commons.attachments;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public class ZCRMORI_P008_ATTACH_FILE_OutputData implements Serializable,
		IProxyOutputData {

	/**
	* 
	*/
	private static final long serialVersionUID = 8153413843042941014L;

	private String url = null;

	/**
* 
*/
	public ZCRMORI_P008_ATTACH_FILE_OutputData() {
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


	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
