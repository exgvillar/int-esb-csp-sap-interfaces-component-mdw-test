package com.consubanco.sap.interfaces.recomendados.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author omar.corona
 *
 */
public class CONVENIO_Model implements Serializable{



	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;

	private String id = null;
	
	private String description = null;
	
	private String brmsId = null;
	
	private String productId = null;
	
	private String productDesc = null;
	
	
	public CONVENIO_Model() {
		super();
	}

	
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}



	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}



	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}



	/**
	 * @return the brmsId
	 */
	public String getBrmsId() {
		return brmsId;
	}



	/**
	 * @param brmsId the brmsId to set
	 */
	public void setBrmsId(String brmsId) {
		this.brmsId = brmsId;
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



	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
	
}
