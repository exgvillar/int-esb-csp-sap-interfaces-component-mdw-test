/**
 * 
 */
package com.consupago.sap.interfaces.proxy.casemgt;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public class ZRFC_GET_DOC_URL_OutputData implements Serializable,
		IProxyOutputData {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -797750150682539918L;
	
	private String documentURL = null;
	
	
	/**
* 
*/
	public ZRFC_GET_DOC_URL_OutputData() {
		super();
	}

	

	/**
	 * @return the documentURL
	 */
	public String getDocumentURL() {
		return documentURL;
	}



	/**
	 * @param documentURL the documentURL to set
	 */
	public void setDocumentURL(String documentURL) {
		this.documentURL = documentURL;
	}



	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
