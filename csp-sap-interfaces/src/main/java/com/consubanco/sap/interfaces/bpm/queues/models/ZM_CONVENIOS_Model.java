/**
 * 
 */
package com.consubanco.sap.interfaces.bpm.queues.models;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.consupago.sap.interfaces.proxy.IProxyOutputData;

/**
 * @author hsanchez
 *
 */
public class ZM_CONVENIOS_Model implements Serializable,
		IProxyOutputData {



	/**
	 * 
	 */
	private static final long serialVersionUID = 2539082200809553985L;


	private String convenioId = null;
	
	private String convenioDesc = null;
	
	private String brmsId = null;
	
	private int ratePriority = 0;
	
	private ArrayList<ZM_PRODUCTS_Model> productsList = null;
	
	
	/**
	 * 
	 */
	public ZM_CONVENIOS_Model() {
		super();
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
	 * @return the ratePriority
	 */
	public int getRatePriority() {
		return ratePriority;
	}

	/**
	 * @param ratePriority the ratePriority to set
	 */
	public void setRatePriority(int ratePriority) {
		this.ratePriority = ratePriority;
	}

	/**
	 * @return the productsList
	 */
	public ArrayList<ZM_PRODUCTS_Model> getProductsList() {
		return productsList;
	}

	/**
	 * @param productsList the productsList to set
	 */
	public void setProductsList(ArrayList<ZM_PRODUCTS_Model> productsList) {
		this.productsList = productsList;
	}

	public String toString() {
		return ToStringBuilder.reflectionToString( this, ToStringStyle.MULTI_LINE_STYLE );
	}
}
