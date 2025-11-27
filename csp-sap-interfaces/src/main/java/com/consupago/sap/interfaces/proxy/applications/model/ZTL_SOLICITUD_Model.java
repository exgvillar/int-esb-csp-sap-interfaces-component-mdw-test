/**
 * 
 */
package com.consupago.sap.interfaces.proxy.applications.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author rbecerra
 *
 */
public class ZTL_SOLICITUD_Model implements Serializable, IProxyOutputData {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2964962166008427160L;

	private String applicationId = null;
	
	private String productId = null;
	
	private String productDesc = null;
	
	private String convenioId = null;
	
	private String convenioDesc = null;
	
	/**
	 * 
	 */
	public ZTL_SOLICITUD_Model() {
		super();
	}

	

	/**
	 * @return the applicationId
	 */
	public String getApplicationId() {
		return applicationId;
	}



	/**
	 * @param applicationId the applicationId to set
	 */
	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}



	/**
	 * @return the productId
	 */
	public String getProductId() {
		return productId;
	}



	/**
	 * @param productId the productId to set
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}



	/**
	 * @return the productDesc
	 */
	public String getProductDesc() {
		return productDesc;
	}



	/**
	 * @param productDesc the productDesc to set
	 */
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}



	/**
	 * @return the convenioId
	 */
	public String getConvenioId() {
		return convenioId;
	}



	/**
	 * @param convenioId the convenioId to set
	 */
	public void setConvenioId(String convenioId) {
		this.convenioId = convenioId;
	}



	/**
	 * @return the convenioDesc
	 */
	public String getConvenioDesc() {
		return convenioDesc;
	}



	/**
	 * @param convenioDesc the convenioDesc to set
	 */
	public void setConvenioDesc(String convenioDesc) {
		this.convenioDesc = convenioDesc;
	}



	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
