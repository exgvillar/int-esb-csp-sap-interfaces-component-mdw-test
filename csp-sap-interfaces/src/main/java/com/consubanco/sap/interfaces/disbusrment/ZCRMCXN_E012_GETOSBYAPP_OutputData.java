/**
 * 
 */
package com.consubanco.sap.interfaces.disbusrment;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author hsanchez
 *
 */
public class ZCRMCXN_E012_GETOSBYAPP_OutputData implements Serializable, IProxyOutputData {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;

	private String serviceOrderId = null;
	
	private String serviceOrderType = null;
	
	private String statusId = null;
	
	private String statusDesc = null;

	public ZCRMCXN_E012_GETOSBYAPP_OutputData(){
		
	}
	
	/**
	 * @return the serviceOrderId
	 */
	public String getServiceOrderId() {
		return serviceOrderId;
	}

	/**
	 * @param serviceOrderId the serviceOrderId to set
	 */
	public void setServiceOrderId(String serviceOrderId) {
		this.serviceOrderId = serviceOrderId;
	}

	/**
	 * @return the serviceOrderType
	 */
	public String getServiceOrderType() {
		return serviceOrderType;
	}

	/**
	 * @param serviceOrderType the serviceOrderType to set
	 */
	public void setServiceOrderType(String serviceOrderType) {
		this.serviceOrderType = serviceOrderType;
	}

	/**
	 * @return the statusId
	 */
	public String getStatusId() {
		return statusId;
	}

	/**
	 * @param statusId the statusId to set
	 */
	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}

	/**
	 * @return the statusDesc
	 */
	public String getStatusDesc() {
		return statusDesc;
	}

	/**
	 * @param statusDesc the statusDesc to set
	 */
	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
