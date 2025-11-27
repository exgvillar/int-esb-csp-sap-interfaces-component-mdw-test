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
public class ZCRMORI_E012_LEE_PRODCB_OutputData implements Serializable,
		IProxyOutputData {



	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;

	private String productCRMId = null;
	
	private String productICBSId = null;
	
	private String descripcion = null;
	
	
	
	/**
	 * 
	 */
	public ZCRMORI_E012_LEE_PRODCB_OutputData() {
		super();
	}

	


	/**
	 * @return the productCRMId
	 */
	public String getProductCRMId() {
		return productCRMId;
	}




	/**
	 * @param productCRMId the productCRMId to set
	 */
	public void setProductCRMId(String productCRMId) {
		this.productCRMId = productCRMId;
	}




	/**
	 * @return the productICBSId
	 */
	public String getProductICBSId() {
		return productICBSId;
	}




	/**
	 * @param productICBSId the productICBSId to set
	 */
	public void setProductICBSId(String productICBSId) {
		this.productICBSId = productICBSId;
	}




	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}




	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}




	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
