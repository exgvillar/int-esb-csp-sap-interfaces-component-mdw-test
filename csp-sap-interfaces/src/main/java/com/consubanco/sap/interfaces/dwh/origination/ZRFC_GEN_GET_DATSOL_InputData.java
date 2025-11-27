/**
 * 
 */
package com.consubanco.sap.interfaces.dwh.origination;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author ramon.becerra
 *
 */
public class ZRFC_GEN_GET_DATSOL_InputData implements Serializable,
		IProxyOutputData {


	/**
	 * 
	 */
	private static final long serialVersionUID = -6524657356090921950L;

	private String requestId = null;
	
		
	/**
	 * 
	 */
	public ZRFC_GEN_GET_DATSOL_InputData() {
		super();
	}

	
	



	/**
	 * @return the requestId
	 */
	public String getRequestId() {
		return requestId;
	}






	/**
	 * @param requestId the requestId to set
	 */
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}




	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
