/**
 * 
 */
package com.consubanco.sap.interfaces.commons;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author ramon.becerra
 *
 */
public class ZCRMORI_E006_BUSCATTRMKTG_OutputData implements Serializable,
		IProxyOutputData {



	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;

	private String bpId = null;
	
	private String attributeMktId = null;
	
	private String attributeMktDesc = null;
	
	private String valueAttributeMkt = null;
	
	private String attributeMktGroupId = null;
	
	private String attributeMktGroupDesc = null;
	
	
	
	
	/**
	 * 
	 */
	public ZCRMORI_E006_BUSCATTRMKTG_OutputData() {
		super();
	}

	

	
	/**
	 * @return the bpId
	 */
	public String getBpId() {
		return bpId;
	}




	/**
	 * @param bpId the bpId to set
	 */
	public void setBpId(String bpId) {
		this.bpId = bpId;
	}




	/**
	 * @return the attributeMktId
	 */
	public String getAttributeMktId() {
		return attributeMktId;
	}




	/**
	 * @param attributeMktId the attributeMktId to set
	 */
	public void setAttributeMktId(String attributeMktId) {
		this.attributeMktId = attributeMktId;
	}




	/**
	 * @return the attributeMktDesc
	 */
	public String getAttributeMktDesc() {
		return attributeMktDesc;
	}




	/**
	 * @param attributeMktDesc the attributeMktDesc to set
	 */
	public void setAttributeMktDesc(String attributeMktDesc) {
		this.attributeMktDesc = attributeMktDesc;
	}




	/**
	 * @return the valueAttributeMkt
	 */
	public String getValueAttributeMkt() {
		return valueAttributeMkt;
	}




	/**
	 * @param valueAttributeMkt the valueAttributeMkt to set
	 */
	public void setValueAttributeMkt(String valueAttributeMkt) {
		this.valueAttributeMkt = valueAttributeMkt;
	}




	/**
	 * @return the attributeMktGroupId
	 */
	public String getAttributeMktGroupId() {
		return attributeMktGroupId;
	}




	/**
	 * @param attributeMktGroupId the attributeMktGroupId to set
	 */
	public void setAttributeMktGroupId(String attributeMktGroupId) {
		this.attributeMktGroupId = attributeMktGroupId;
	}




	/**
	 * @return the attributeMktGroupDesc
	 */
	public String getAttributeMktGroupDesc() {
		return attributeMktGroupDesc;
	}




	/**
	 * @param attributeMktGroupDesc the attributeMktGroupDesc to set
	 */
	public void setAttributeMktGroupDesc(String attributeMktGroupDesc) {
		this.attributeMktGroupDesc = attributeMktGroupDesc;
	}




	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
