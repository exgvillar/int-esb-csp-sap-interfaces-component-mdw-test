package com.consubanco.sap.interfaces.recomendados.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author omar.corona
 *
 */
public class DISTRIBUIDOR_Model implements Serializable{



	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;

	private String id = null;
	
	private String description = null;
	
	private String siglas = null;
	
	
	
	public DISTRIBUIDOR_Model() {
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
	 * @return the siglas
	 */
	public String getSiglas() {
		return siglas;
	}



	/**
	 * @param siglas the siglas to set
	 */
	public void setSiglas(String siglas) {
		this.siglas = siglas;
	}



	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
	
}
