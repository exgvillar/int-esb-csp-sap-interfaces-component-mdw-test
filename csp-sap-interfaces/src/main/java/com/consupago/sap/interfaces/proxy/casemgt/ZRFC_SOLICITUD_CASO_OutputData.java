/**
 * 
 */
package com.consupago.sap.interfaces.proxy.casemgt;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

public class ZRFC_SOLICITUD_CASO_OutputData implements Serializable,
		IProxyOutputData {

	/**
	* 
	*/
	private static final long serialVersionUID = 8153413843042941014L;

	private String caseId = null;

	/**
* 
*/
	public ZRFC_SOLICITUD_CASO_OutputData() {
		super();
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





	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.MULTI_LINE_STYLE);
	}
}
