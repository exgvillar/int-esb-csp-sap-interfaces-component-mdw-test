/**
 * 
 */
package com.consubanco.sap.interfaces.coi;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author ramon.becerra
 *
 */
public class ZCRMOP1098_P012_REGISTROLOTE_OutputData implements Serializable,
		IProxyOutputData {


	/**
	 * 
	 */
	private static final long serialVersionUID = 8367063448524098874L;

	private String result = null;
	
	private String caseId = null;
	
	private String url = null;
	
	
	/**
	 * 
	 */
	public ZCRMOP1098_P012_REGISTROLOTE_OutputData() {
		super();
	}

	
	



	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}






	/**
	 * @param result the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}






	/**
	 * @return the caseId
	 */
	public String getCaseId() {
		return caseId;
	}






	/**
	 * @param caseId the caseId to set
	 */
	public void setCaseId(String caseId) {
		this.caseId = caseId;
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
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
